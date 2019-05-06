package com.vendingmachine.service;

import com.vendingmachine.entity.Sale;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    void addNewSale(String productId, double price, LocalDateTime date);
    List<Sale> getAll();
}
