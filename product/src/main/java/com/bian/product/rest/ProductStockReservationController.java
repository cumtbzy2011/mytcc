package com.bian.product.rest;


import com.bian.common.model.request.StockReservationRequest;
import com.bian.common.model.response.StockReservationResponse;
import com.bian.common.model.vo.Participant;
import com.bian.product.jooq.tables.pojos.Productstocktcc;
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
    @RequestMapping(name = "/stocks/reservation", method = RequestMethod.POST)
    public StockReservationResponse reserve(@RequestBody StockReservationRequest reservationRequest) {
        Productstocktcc tcc = productstocktccService.trying(reservationRequest.getProductId());
        Participant participant = new Participant();
        participant.setExpireTime(tcc.getExpireTime().toLocalDateTime());
        participant.setUri("http://" + applicationName + "/rpc/stocks/reservation/" + tcc.getId());
        return new StockReservationResponse(participant);
    }


    //确认库存confirm
    @RequestMapping(value = "/stocks/reservation", method = RequestMethod.PUT)
    public void confirm(@PathVariable Long reservationId) {
        productstocktccService.confirmReservation(reservationId);
    }

    //取消预留cancel
    @RequestMapping(value = "/stocks/reservation", method = RequestMethod.DELETE)
    public void cancel(@PathVariable Long reservationId) {
        productstocktccService.cancelReservation(reservationId);
    }
}
