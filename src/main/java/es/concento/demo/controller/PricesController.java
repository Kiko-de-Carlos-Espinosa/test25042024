package es.concento.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.concento.demo.model.Price;

@RestController
public class PricesController {

    

    @GetMapping("/price")
    public Price price (
        @RequestParam(value = "BRAND", defaultValue = "1" ) String brandId,
        @RequestParam(value = "PRODUCT") long productId
        ) {
        

        return new Price();
    }

}
