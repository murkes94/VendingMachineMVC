package com.vendingmachine.service;

import com.vendingmachine.entity.SnackProduct;

import java.util.List;
import java.util.Optional;

public interface SnackProductService {
    Optional<SnackProduct> getById(String id);
    SnackProduct editSnackProduct(SnackProduct snackProduct);
    List<SnackProduct> getAll();
}
