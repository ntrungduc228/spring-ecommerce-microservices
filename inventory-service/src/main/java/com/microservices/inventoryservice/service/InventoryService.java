package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}