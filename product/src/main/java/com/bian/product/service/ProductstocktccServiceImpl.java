package com.bian.product.service;

import com.bian.product.jooq.tables.pojos.Product;
import com.bian.product.jooq.tables.pojos.Productstocktcc;
import com.bian.product.model.TccStatus;
import org.jooq.DSLContext;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.product.jooq.tables.Product.PRODUCT_;
import static com.bian.product.jooq.tables.Productstocktcc.PRODUCTSTOCKTCC;

@Service
public class ProductstocktccServiceImpl implements ProductstocktccService {
    @Autowired
    DSLContext create;

    @Override
    public int insert(Productstocktcc productstocktcc) {
        productstocktcc.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        return create.insertInto(PRODUCTSTOCKTCC)
          .set(PRODUCTSTOCKTCC.STOCK, productstocktcc.getStock())
          .set(PRODUCTSTOCKTCC.STATUS, productstocktcc.getStatus())
          .set(PRODUCTSTOCKTCC.T_PRODUCT_ID, productstocktcc.getTProductId())
          .set(PRODUCTSTOCKTCC.CREATE_TIME, productstocktcc.getCreateTime())
          .execute();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Productstocktcc trying(long productId) {
        Product product = selectProductById(productId);
        if (product == null) {
            throw new RuntimeException("需要预留的商品不存在");
        }
        return trying(product, 15);
    }

    @Transactional(rollbackFor = Exception.class)
    public Productstocktcc trying(Product product, long expireSeconds) {
        int isLock = this.consumeStock(product.getId());
        if (isLock == 0) {
            throw new RuntimeException("预留失败");
        }
        Productstocktcc tcc = new Productstocktcc();
        tcc.setStock(UInteger.valueOf(1));
        tcc.setStatus(UByte.valueOf(TccStatus.TRYING));
        tcc.setTProductId(product.getId());
        tcc.setExpireTime(Timestamp.valueOf(LocalDateTime.now().plusSeconds(expireSeconds)));

        this.insert(tcc);
        return tcc;
    }

    private Product selectProductById(Long id) {
        List<Product> products = create.select()
          .from(PRODUCT_)
          .where(PRODUCT_.ID.eq(ULong.valueOf(id)))
          .fetchInto(Product.class);

        return products.size() > 0 ? products.get(0) : null;
    }

    private int consumeStock(ULong id) {
        return create.update(PRODUCT_)
          .set(PRODUCT_.STOCK, PRODUCT_.STOCK.sub(1))
          .where(PRODUCT_.ID.eq(id))
          .execute();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int confirmReservation(Long id) {
        Productstocktcc tcc = selectTccById(id);
        if (tcc == null) {
            throw new RuntimeException("resource " + id + " has been cancelled or does not exist at all");
        }
        if (TccStatus.TRYING == tcc.getStatus().intValue()) {
            int result = updateToConfirmationById(tcc.getId());
            if (result == 0) {
                throw new RuntimeException("resource " + id + " has been cancelled");
            }
        } else if (TccStatus.CANCEL == tcc.getStatus().intValue()) {
            throw new RuntimeException("resource " + id + " has been cancelled");
        }
        return 1;

    }

    private Productstocktcc selectTccById(Long id) {
        List<Productstocktcc> productstocktccs = create.select()
          .from(PRODUCTSTOCKTCC)
          .where(PRODUCTSTOCKTCC.ID.eq(ULong.valueOf(id)))
          .fetchInto(Productstocktcc.class);
        return productstocktccs.size() > 0 ? productstocktccs.get(0) : null;
    }

    @Scheduled
    private int updateToConfirmationById(ULong id) {
        return create.update(PRODUCTSTOCKTCC)
          .set(PRODUCTSTOCKTCC.STATUS, UByte.valueOf(TccStatus.CONFIRM))
          .where(PRODUCTSTOCKTCC.ID.eq(id))
          .and(PRODUCTSTOCKTCC.STATUS.eq(UByte.valueOf(TccStatus.TRYING))
            .or(PRODUCTSTOCKTCC.STATUS.eq(UByte.valueOf(TccStatus.CONFIRM))))
          .execute();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int cancelReservation(Long id) {
        Productstocktcc tcc = selectTccById(id);
        if (tcc == null) {
            throw new RuntimeException("resource " + id + " has been cancelled or does not exist at all");
        }
        if (TccStatus.CANCEL != tcc.getStatus().intValue()) {
            int result = deleteTccById(ULong.valueOf(id));
            if (result == 1) {  //返回0说明有其他线程已经回退了库存，这时候直接返回1即可
                int returnReservedStock = returnReservedStock(tcc.getTProductId());
                if (returnReservedStock == 0) {
                    //回退本次事务
                    throw new IllegalStateException("product stock reservation id " + tcc.getId() + " was succeeded in deleting, but failed to make compensation for product id " + tcc.getTProductId());
                }
            }
        }
        return 1;
    }

    private int deleteTccById(ULong id) {
        return create.update(PRODUCTSTOCKTCC)
          .set(PRODUCTSTOCKTCC.STATUS, UByte.valueOf(TccStatus.CANCEL))
          .where(PRODUCTSTOCKTCC.ID.eq(id))
          .and(PRODUCTSTOCKTCC.STATUS.ne(UByte.valueOf(TccStatus.CANCEL)))
          .execute();
    }

    private int returnReservedStock(ULong id) {
        return create.update(PRODUCT_)
          .set(PRODUCT_.STOCK, PRODUCT_.STOCK.add(1))
          .where(PRODUCT_.ID.eq(id))
          .execute();
    }
}
