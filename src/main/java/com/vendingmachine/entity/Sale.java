package com.vendingmachine.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Sale is the entity of sale stored in DB
 * Presents sale of products: snack product, coffee product
 */
@Entity
@Table(name = "sale")
public class Sale {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productid")
    private String productId;

    @Column(name = "price")
    private double price;

    @Column(name = "date")
    private LocalDateTime date;

    public Sale() {}

    public Sale(String productId, double price, LocalDateTime date) {
        this.productId = productId;
        this.price = price;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
