package com.bian.product.service;

import com.bian.product.jooq.tables.pojos.Product;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bian.product.jooq.tables.Product.PRODUCT_;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    DSLContext create;

    public List<Product> findAll() {
        return create.select()
          .from(PRODUCT_)
          .fetchInto(Product.class);
    }
}
