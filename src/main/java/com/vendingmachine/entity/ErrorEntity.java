package com.vendingmachine.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * ErrorEntity is the entity of error stored in DB
 * Represents errors of internal modules (e.g. motors not working),
 * products out of stock, water/cups not available, etc
 */
@Entity
@Table(name = "error")
public class ErrorEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "solved")
    private boolean solved;

    public ErrorEntity() {}

    public ErrorEntity(String type, LocalDateTime date, boolean solved) {
        this.type = type;
        this.date = date;
        this.solved = solved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}