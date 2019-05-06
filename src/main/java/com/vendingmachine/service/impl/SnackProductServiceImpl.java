package com.vendingmachine.service.impl;

import com.vendingmachine.entity.SnackProduct;
import com.vendingmachine.repository.SnackProductRepository;
import com.vendingmachine.service.SnackProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackProductServiceImpl implements SnackProductService {

    @Autowired
    private SnackProductRepository snackProductRepository;

    @Override
    public Optional<SnackProduct> getById(String id) {
        return snackProductRepository.findById(id);
    }

    @Override
    public SnackProduct editSnackProduct(SnackProduct snackProduct) {
        return snackProductRepository.saveAndFlush(snackProduct);
    }

    @Override
    public List<SnackProduct> getAll() {
        return snackProductRepository.findAll();
    }
}

