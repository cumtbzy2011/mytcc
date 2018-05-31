package com.bian.product.rest;


import com.bian.common.model.vo.Participant;
import com.bian.common.model.vo.VoProduct;
import com.bian.product.jooq.tables.pojos.Product;
import com.bian.product.jooq.tables.pojos.Productstocktcc;
import com.bian.product.service.ProductService;
import com.bian.product.service.ProductstocktccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rpc")
public class ProductStockReservationController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    ProductstocktccService productstocktccService;

    //预留库存try
    @GetMapping(value = "/stocks/reservation")
    public Long reserve(@RequestParam Long productId) {
        Productstocktcc tcc = productstocktccService.trying(productId);
        return tcc.getId().longValue();
    }


    //确认库存confirm
    @RequestMapping(value = "/stocks/confirm", method = RequestMethod.GET)
    public Integer confirm(@RequestParam Long partId) {
        return productstocktccService.confirmReservation(partId);
    }

    //取消预留cancel
    @RequestMapping(value = "/stocks/reservation", method = RequestMethod.DELETE)
    public void cancel(@PathVariable Long reservationId) {
        productstocktccService.cancelReservation(reservationId);
    }



    //////////////
    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/{id}")
    public Product findById(@PathVariable("id") Long id) {
        Product product = productService.selectById(id);

        VoProduct voProduct = new VoProduct();
        voProduct.setCreateTime(product.getCreateTime().toLocalDateTime());
        voProduct.setDeleteTime(product.getDeleteTime().toLocalDateTime());
        voProduct.setId(product.getId().longValue());
        voProduct.setName(product.getName());
        voProduct.setPrice(product.getPrice().intValue());
        voProduct.setStock(product.getStock().intValue());
        voProduct.setUpdateTime(product.getUpdateTime().toLocalDateTime());

        return product;
    }
}
