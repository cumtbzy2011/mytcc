package com.bian.order.service;

import com.bian.common.exception.BusinessException;
import com.bian.common.model.OrderStatus;
import com.bian.common.model.vo.VoProduct;
import com.bian.common.model.vo.VoUser;
import com.bian.order.feign.ProductClient;
import com.bian.order.feign.UserClient;
import com.bian.order.jooq.tables.pojos.Conflict;
import com.bian.order.jooq.tables.pojos.Order;
import com.bian.order.jooq.tables.pojos.Participant;
import com.bian.order.jooq.tables.records.OrderRecord;
import org.jooq.DSLContext;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.bian.order.jooq.tables.Order.ORDER_;
import static com.bian.order.jooq.tables.Participant.PARTICIPANT;
import static com.bian.order.jooq.tables.Conflict.CONFLICT;

@Service
public class OrderService {

    @Autowired
    DSLContext create;
    @Autowired
    ProductClient productClient;
    @Autowired
    UserClient userClient;

    public int insert(Order order) {
        OrderRecord orderRecord = create.insertInto(ORDER_)
          .set(ORDER_.USER_ID, order.getUserId())
          .set(ORDER_.PRODUCT_ID, order.getProductId())
          .set(ORDER_.PRICE, order.getPrice())
          .returning(ORDER_.ID)
          .fetchOne();
        ULong id = orderRecord.getId();
        if (id == null) {
            throw new RuntimeException("订单插入失败");
        }
        order.setId(id);
        return 1;
    }

    private int changeOrderStatus(Order order) {
        return create.update(ORDER_)
          .set(ORDER_.STATUS, order.getStatus())
          .where(ORDER_.ID.eq(order.getId()))
          .execute();
    }

    public List<Order> findAll() {
        return create.select()
          .from(ORDER_)
          .fetchInto(Order.class);
    }

    private Order selectById(Long id) {
        List<Order> orders = create.select()
          .from(ORDER_)
          .where(ORDER_.ID.eq(ULong.valueOf(id)))
          .fetchInto(Order.class);

        return orders.size() > 0 ? orders.get(0) : null;
    }

    private List<Participant> selectByOrderId(ULong orderId) {
        return create.select()
          .from(PARTICIPANT)
          .where(PARTICIPANT.T_ORDER_ID.eq(orderId))
          .fetchInto(Participant.class);
    }

    @Transactional
    public Order confirm(Long orderId) {
        Order order = selectById(orderId);
        checkNotNull(order, new BusinessException("订单不存在"));
        List<Participant> participants = selectByOrderId(order.getId());
        checkTrue(!CollectionUtils.isEmpty(participants), new BusinessException("该订单不存在可用资源"));
        //虽然资源支持重复确认-为了重试，但是订单的其他三个状态，DONE代表订单已完成，没有必要再确认，
        // TIMEOUT、CONFLICT说明有资源已经过期了，这时候肯定不能确认所有资源，所以也没有确认的意义
        if (order.getStatus().intValue() == OrderStatus.PROCESSING) {
            confirmPhase(order, participants);
        }
        return order;
    }

    private void confirmPhase(Order order, List<Participant> participants) {
        AtomicInteger confirmNum = new AtomicInteger();
        participants.forEach(
          participant -> {
              if ("balance".equals(participant.getPartType())) {
                  confirmNum.addAndGet(userClient.confirm(Long.parseLong(participant.getPartId())));
              } else {
                  confirmNum.addAndGet(productClient.confirm(Long.parseLong(participant.getPartId())));
              }
          }
        );
        if (confirmNum.intValue() == participants.size()) {
            order.setStatus(UByte.valueOf(OrderStatus.DONE));
            changeOrderStatus(order);
        } else if (confirmNum.intValue() == 0) {
            order.setStatus(UByte.valueOf(OrderStatus.TIMEOUT));
            changeOrderStatus(order);
        } else {
            //有一部分被确认，一部分没有呗确认，那么被确认的资源将不会被回退，必须要人工去取消确认的资源
            order.setStatus(UByte.valueOf(OrderStatus.CONFLICT));
            changeOrderStatus(order);
            Conflict conflict = new Conflict();
            conflict.setErrorDetail("test detail");
            conflict.setTOrderId(order.getId());
            insertConflict(conflict);
        }

    }


    private int insertConflict(Conflict conflict) {
        return create.insertInto(CONFLICT)
          .set(CONFLICT.ERROR_DETAIL, conflict.getErrorDetail())
          .set(CONFLICT.T_ORDER_ID, conflict.getTOrderId())
          .execute();
    }

    @Transactional
    public Order placeOrder(Long userId, Long productId) {
        VoProduct product = productClient.findProduct(productId);
        VoUser user = userClient.findUser(userId);
        checkNotNull(product, new BusinessException("商品不存在"));
        checkNotNull(user, new BusinessException("用户不存在"));
        checkTrue(user.getBalance() >= product.getPrice(), new BusinessException("余额不足"));

        final Order order = new Order();
        order.setUserId(ULong.valueOf(userId));
        order.setProductId(ULong.valueOf(productId));
        order.setPrice(UInteger.valueOf(product.getPrice()));
        order.setStatus(UByte.valueOf(OrderStatus.PROCESSING));
        this.insert(order);

        reserveBalance(order);
        reserveProduct(order);
        return order;
    }

    private void reserveProduct(Order order) {
        Long reserveId = productClient.reserve(order.getProductId().longValue());
        checkNotNull(reserveId, new BusinessException("库存不足"));
        persistParticipant(reserveId, "product", order.getId());
    }

    private void reserveBalance(Order order) {
        Long reserveId = userClient.reserve(order.getUserId().longValue(), order.getPrice().longValue());
        checkNotNull(reserveId, new BusinessException("余额不足"));
        persistParticipant(reserveId, "balance", order.getId());
    }

    private void checkTrue(boolean result, RuntimeException err) {
        if (!result) {
            throw err;
        }
    }

    private void checkNotNull(Object obj, RuntimeException err) {
        if (obj == null) {
            throw err;
        }
    }

    private void persistParticipant(Long partId, String type, ULong orderId) {
        create.insertInto(PARTICIPANT)
          .set(PARTICIPANT.T_ORDER_ID, orderId)
          .set(PARTICIPANT.PART_ID, partId.toString())
          .set(PARTICIPANT.PART_TYPE, type)
          .execute();
    }
}
