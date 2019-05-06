package com.vendingmachine.entity;

import javax.persistence.*;

/**
 * TemperatureSettings is the entity of settings stored in DB
 * Represents temperature settings of WaterSensor {@link com.vendingmachine.sensors.WaterSensor},
 * FridgeSensor {@link com.vendingmachine.sensors.FridgeSensor}
 */
@Entity
@Table(name = "temperaturesettings")
public class TemperatureSettings {

    @Column(name = "type")
    @Id
    private String type;

    @Column(name = "mintemp")
    private int minTemperature;

    @Column(name = "maxtemp")
    private int maxTemperature;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
