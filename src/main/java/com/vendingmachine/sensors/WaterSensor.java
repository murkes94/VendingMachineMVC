package com.vendingmachine.sensors;

import com.vendingmachine.entity.TemperatureSettings;
import com.vendingmachine.entity.constants.TempSettingsType;
import com.vendingmachine.service.TemperatureSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Random;

/**
 * Contains temperature settings of water heater.
 * Reads current temperature of water.
 * Sends temperature of water to clients via web socket.
 */
@Component
public class WaterSensor {

    @Autowired
    private SimpMessagingTemplate webSocket;

    public boolean isWaterAvailable() {

        //some logic to check availability of water

        return true;
    }

    private int minTemperature;
    private int maxTemperature;

    @Autowired
    public WaterSensor(TemperatureSettingsService temperatureSettingsService) {
        Optional<TemperatureSettings> optionalTemperatureSettings = temperatureSettingsService
                .getById(TempSettingsType.TYPE_WATER);
        if (!optionalTemperatureSettings.isPresent()) {
            //TODO logger
            throw new EntityNotFoundException("Entity Temperature settings with id "
                    + TempSettingsType.TYPE_WATER + " not found in DB");
        }
        TemperatureSettings temperatureSettings = optionalTemperatureSettings.get();
        minTemperature = temperatureSettings.getMinTemperature();
        maxTemperature = temperatureSettings.getMaxTemperature();
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * Sends current temperature of water to clients via websocket
     */
    @Scheduled(fixedDelay = 1000)
    public void sendWaterTemp() {

        //simulator. call physical sensor and read temperature
        //set min and max temp

        Random rn = new Random();
        //calls random to simulate temperature reading
        int randTemperature = rn.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
        webSocket.convertAndSend("/water-temp", randTemperature);
    }

}
