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
 * Contains temperature settings of fridge.
 * Reads current temperature of fridge.
 * Sends temperature of fridge to clients via web socket.
 */
@Component
public class FridgeSensor {

    @Autowired
    private SimpMessagingTemplate webSocket;

    //when the temperature drops below the freezer/evaporator stops
    private int minTemperature;
    //when the temperature gets above the freezer/evaporator starts
    private int maxTemperature;

    @Autowired
    public FridgeSensor(TemperatureSettingsService temperatureSettingsService) {
        Optional<TemperatureSettings> optionalTemperatureSettings = temperatureSettingsService
                .getById(TempSettingsType.TYPE_FREEZER);
        if (!optionalTemperatureSettings.isPresent()) {
            //TODO logger
            throw new EntityNotFoundException("Entity Temperature settings with id "
                    + TempSettingsType.TYPE_FREEZER + " not found in DB");
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
     * Sends current temperature of fridge to clients via websocket
     */
    @Scheduled(fixedDelay = 1000)
    public void sendFridgeTemp() {
        //simulator. call physical sensor and read temperature
        //set min and max temp

        Random rn = new Random();
        //calls random to simulate temperature reading
        int randTemperature = rn.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
        webSocket.convertAndSend("/freezer-temp", randTemperature);
    }
}
