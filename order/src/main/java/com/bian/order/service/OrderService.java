package com.bian.order.service;

import com.bian.common.exception.BusinessException;
import com.bian.common.model.OrderStatus;
import com.bian.common.model.vo.Participant;
import com.bian.order.feign.ProductClient;
import com.bian.order.feign.UserClient;
import com.bian.order.jooq.tables.pojos.Order;
import com.bian.order.model.vo.Product;
import com.bian.order.model.vo.User;
import org.jooq.DSLContext;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static com.bian.order.jooq.tables.Order.ORDER_;
import static com.bian.order.jooq.tables.Participant.PARTICIPANT;

@Service
public class OrderService {

    @Autowired
    DSLContext create;
    @Autowired
    ProductClient productClient;
    @Autowired
    UserClient userClient;

    public int insert(Order order) {
        return create.insertInto(ORDER_)
          .set(ORDER_.USER_ID, order.getUserId())
          .set(ORDER_.PRODUCT_ID, order.getProductId())
          .set(ORDER_.PRICE, order.getPrice())
          .execute();
    }

    public List<Order> findAll() {
        return create.select()
          .from(ORDER_)
          .fetchInto(Order.class);
    }


    @Transactional
    public Order placeOrder(Long userId, Long productId) {
        Product product = productClient.findProduct(productId);
        User user = userClient.findUser(userId);
        checkNotNull(product, new BusinessException("商品不存在"));
        checkNotNull(user, new BusinessException("用户不存在"));
        chectTrue(user.getBalance() >= product.getPrice(), new BusinessException("余额不足"));

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
        Participant reserve = productClient.reserve(order.getProductId().longValue());
        checkNotNull(reserve, new BusinessException("库存不足"));
        persistParticipant(reserve, order.getId());
    }

    private void reserveBalance(Order order) {
        Participant reserve = userClient.reserve(order.getUserId().longValue(), order.getPrice().longValue());
        checkNotNull(reserve, new BusinessException("余额不足"));
        persistParticipant(reserve, order.getId());
    }

    private void chectTrue(boolean result, RuntimeException err) {
        if (!result) {
            throw err;
        }
    }

    private void checkNotNull(Object obj, RuntimeException err) {
        if (obj == null) {
            throw err;
        }
    }

    private void persistParticipant(Participant participant, ULong orderId) {
        create.insertInto(PARTICIPANT)
          .set(PARTICIPANT.T_ORDER_ID, orderId)
          .set(PARTICIPANT.URI, participant.getUri())
          .set(PARTICIPANT.EXPIRE_TIME, Timestamp.valueOf(participant.getExpireTime()))
          .execute();
    }
}
