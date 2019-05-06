package com.vendingmachine.repository;

import com.vendingmachine.entity.SnackProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackProductRepository extends JpaRepository<SnackProduct, String> {
}
