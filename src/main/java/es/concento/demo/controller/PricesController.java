package es.concento.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.concento.demo.model.Price;
import es.concento.demo.service.PriceService;

@RestController
public class PricesController {

    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public Price price (
        @RequestParam(value = "brand") long brandId,
        @RequestParam(value = "product") long productId,
        @RequestParam(value = "date") long date
        ) {
        return priceService.getPrice(productId, brandId, date);
    }

}
