package com.vendingmachine.service.impl;

import com.vendingmachine.entity.Sale;
import com.vendingmachine.repository.SaleRepository;
import com.vendingmachine.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void addNewSale(String productId, double price, LocalDateTime date) {
        Sale sale = new Sale(productId, price, date);
        saleRepository.saveAndFlush(sale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }
}
