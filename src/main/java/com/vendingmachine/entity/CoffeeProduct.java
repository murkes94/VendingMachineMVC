package com.vendingmachine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CoffeeProduct is the entity of coffee product stored in DB
 * It extends abstract class Product {@link com.vendingmachine.entity.Product}
 * that has basic fields
 */
@Entity
@Table(name = "coffeeproduct")
public class CoffeeProduct extends Product {

    @Column(name = "ingredient1")
    private int ingredient1;
    @Column(name = "ingredient2")
    private int ingredient2;
    @Column(name = "ingredient3")
    private int ingredient3;

    @Column(name = "ingredient1amount")
    private int ingredient1Amount;
    @Column(name = "ingredient2amount")
    private int ingredient2Amount;
    @Column(name = "ingredient3amount")
    private int ingredient3Amount;

    @Column(name = "wateramountingredient1")
    private int waterAmountIngredient1;
    @Column(name = "wateramountingredient2")
    private int waterAmountIngredient2;
    @Column(name = "wateramountingredient3")
    private int waterAmountIngredient3;

    public int getIngredient1() { return ingredient1; }

    public int getIngredient2() {
        return ingredient2;
    }

    public int getIngredient3() {
        return ingredient3;
    }

    public int getIngredient1Amount() { return ingredient1Amount; }

    public int getIngredient2Amount() { return ingredient2Amount; }

    public int getIngredient3Amount() { return ingredient3Amount; }

    public int getWaterAmountIngredient1() {
        return waterAmountIngredient1;
    }

    public int getWaterAmountIngredient2() {
        return waterAmountIngredient2;
    }

    public int getWaterAmountIngredient3() {
        return waterAmountIngredient3;
    }

    public void setIngredient1(int ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public void setIngredient2(int ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public void setIngredient3(int ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public void setIngredient1Amount(int ingredient1Amount) { this.ingredient1Amount = ingredient1Amount; }

    public void setIngredient2Amount(int ingredient2Amount) { this.ingredient2Amount = ingredient2Amount; }

    public void setIngredient3Amount(int ingredient3Amount) { this.ingredient3Amount = ingredient3Amount; }

    public void setWaterAmountIngredient1(int waterAmountIngredient1) {
        this.waterAmountIngredient1 = waterAmountIngredient1;
    }

    public void setWaterAmountIngredient2(int waterAmountIngredient2) {
        this.waterAmountIngredient2 = waterAmountIngredient2;
    }

    public void setWaterAmountIngredient3(int waterAmountIngredient3) {
        this.waterAmountIngredient3 = waterAmountIngredient3;
    }

}
