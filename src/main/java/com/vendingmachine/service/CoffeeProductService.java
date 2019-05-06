package com.vendingmachine.service;

import com.vendingmachine.entity.CoffeeProduct;

import java.util.List;
import java.util.Optional;

public interface CoffeeProductService {
    Optional<CoffeeProduct> getById(String id);
    CoffeeProduct editSnackProduct(CoffeeProduct coffeeProduct);
    List<CoffeeProduct> getAll();
}
