package com.bian.product.service;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.common.exception.ReservationExpireException;
import com.bian.product.jooq.tables.pojos.Product;
import com.bian.product.jooq.tables.pojos.Productstocktcc;
import com.bian.common.model.TccStatus;
import org.jooq.DSLContext;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.product.jooq.tables.Productstocktcc.PRODUCTSTOCKTCC;
import static com.bian.product.jooq.tables.Product.PRODUCT_;

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
            Shift.fatal(StatusCode.PRODUCT_NOT_EXISTS);
        }
        return trying(product, 15);
    }

    @Transactional(rollbackFor = Exception.class)
    public Productstocktcc trying(Product product, long expireSeconds) {
        int isLock = this.consumeStock(product.getId());
        if (isLock == 0) {
            Shift.fatal(StatusCode.INSUFFICIENT_PRODUCT);
        }
        Productstocktcc tcc = new Productstocktcc();
        tcc.setStock(UInteger.valueOf(1));
        tcc.setStatus(UByte.valueOf(TccStatus.TRY));
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
    public void confirmReservation(Long id) {
        Productstocktcc tcc = selectTccById(id);
        if (tcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }

        if (TccStatus.TRY == tcc.getStatus().intValue()) {
            int result = updateToConfirmationById(tcc.getId());
            if (result == 0) {
                throw new ReservationExpireException("resource " + id + " has been cancelled");
            }
        }
    }

    private Productstocktcc selectTccById(Long id) {
        List<Productstocktcc> productstocktccs = create.select()
          .from(PRODUCTSTOCKTCC)
          .where(PRODUCTSTOCKTCC.ID.eq(ULong.valueOf(id)))
          .fetchInto(Productstocktcc.class);
        return productstocktccs.size() > 0 ? productstocktccs.get(0) : null;
    }

    private int updateToConfirmationById(ULong id) {
        return create.update(PRODUCTSTOCKTCC)
          .set(PRODUCTSTOCKTCC.STATUS, UByte.valueOf(TccStatus.CONFIRM))
          .where(PRODUCTSTOCKTCC.ID.eq(id))
          .and(PRODUCTSTOCKTCC.STATUS.eq(UByte.valueOf(TccStatus.TRY)))
          .execute();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelReservation(Long id) {
        Productstocktcc tcc = selectTccById(id);
        if (tcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        if (TccStatus.TRY == tcc.getStatus().intValue()) {
            int result = deleteTccById(tcc.getId());
            if (result == 1) {
                int returnReservedStock = returnReservedStock(tcc.getTProductId());
                if (returnReservedStock == 0) {
                    throw new IllegalStateException("product stock reservation id " + tcc.getId() + " was succeeded in deleting, but failed to make compensation for product id " + tcc.getTProductId());
                }
            }
        }
    }

    private int deleteTccById(ULong id) {
        return create.delete(PRODUCTSTOCKTCC)
          .where(PRODUCTSTOCKTCC.ID.eq(id))
          .and(PRODUCTSTOCKTCC.STATUS.eq(UByte.valueOf(TccStatus.TRY)))
          .execute();
    }

    private int returnReservedStock(ULong id) {
        return create.update(PRODUCT_)
          .set(PRODUCT_.STOCK, PRODUCT_.STOCK.add(1))
          .where(PRODUCT_.ID.eq(id))
          .execute();
    }
}
