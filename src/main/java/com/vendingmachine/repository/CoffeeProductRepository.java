package com.vendingmachine.repository;

import com.vendingmachine.entity.CoffeeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeProductRepository extends JpaRepository<CoffeeProduct, String> {
}
