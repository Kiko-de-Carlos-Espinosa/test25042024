package es.concento.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.concento.demo.model.Price;
import es.concento.demo.repository.PriceRepo;

@Service
public class PriceService {

    @Autowired
    PriceRepo priceRepo;
    
    public <Optional> Price getPrice(long brinadId, long productId) {
        return priceRepo.getPrice(brinadId, productId, System.currentTimeMillis());
    }

}
