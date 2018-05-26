package com.bian.product.service;

import com.bian.product.jooq.tables.pojos.Productstocktcc;
import org.jooq.DSLContext;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bian.product.jooq.tables.Productstocktcc.PRODUCTSTOCKTCC;

@Service
public class ProductstocktccServiceImpl implements ProductstocktccService {
    @Autowired
    DSLContext create;

    public int insert(Productstocktcc productstocktcc) {
        return create.insertInto(PRODUCTSTOCKTCC)
          .set(PRODUCTSTOCKTCC.STOCK, UInteger.valueOf(1))
          .set(PRODUCTSTOCKTCC.STATUS, UByte.valueOf(1))
          .set(PRODUCTSTOCKTCC.T_PRODUCT_ID, ULong.valueOf(1))
          .execute();
    }
}
