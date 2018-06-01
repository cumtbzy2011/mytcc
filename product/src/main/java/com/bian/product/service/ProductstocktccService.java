package com.bian.product.service;

import com.bian.product.jooq.tables.pojos.Productstocktcc;
import org.springframework.transaction.annotation.Transactional;

public interface ProductstocktccService {
    int insert(Productstocktcc productstocktcc);

    @Transactional(rollbackFor = Exception.class)
    Productstocktcc trying(long productId);

    @Transactional(rollbackFor = Exception.class)
    int confirmReservation(Long id);

    @Transactional(rollbackFor = Exception.class)
    int cancelReservation(Long id);
}
