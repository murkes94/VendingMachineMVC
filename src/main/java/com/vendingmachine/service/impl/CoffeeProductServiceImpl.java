package com.vendingmachine.service.impl;

import com.vendingmachine.entity.CoffeeProduct;
import com.vendingmachine.repository.CoffeeProductRepository;
import com.vendingmachine.service.CoffeeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeProductServiceImpl implements CoffeeProductService {

    @Autowired
    private CoffeeProductRepository coffeeProductRepository;

    @Override
    public Optional<CoffeeProduct> getById(String id) {
        return coffeeProductRepository.findById(id);
    }

    @Override
    public CoffeeProduct editSnackProduct(CoffeeProduct coffeeProduct) {
        return coffeeProductRepository.saveAndFlush(coffeeProduct);
    }

    @Override
    public List<CoffeeProduct> getAll() {
        return coffeeProductRepository.findAll();
    }

}
