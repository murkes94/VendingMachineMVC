package com.vendingmachine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * SnackProduct is the entity of snack product stored in DB
 * It extends abstract class Product {@link com.vendingmachine.entity.Product}
 * that has basic fields
 */
@Entity
@Table(name = "snackproduct")
public class SnackProduct extends Product {

    @Column(name = "availablequantity")
    private int availableQuantity;

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
