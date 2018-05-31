package com.bian.product.service;

import com.bian.product.jooq.tables.pojos.Product;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bian.product.jooq.tables.Product.PRODUCT_;

@Service
public class ProductService {
    @Autowired
    DSLContext create;

    public List<Product> findAll() {
        return create.select()
          .from(PRODUCT_)
          .fetchInto(Product.class);
    }


    public Product selectById(Long id) {
        List<Product> products = create.select()
          .from(PRODUCT_)
          .where(PRODUCT_.ID.eq(ULong.valueOf(id)))
          .fetchInto(Product.class);
        return products.size() > 0 ? products.get(0) : null;
    }
}
