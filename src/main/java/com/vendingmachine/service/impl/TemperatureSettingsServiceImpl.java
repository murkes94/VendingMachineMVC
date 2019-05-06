package com.vendingmachine.service.impl;

import com.vendingmachine.entity.TemperatureSettings;
import com.vendingmachine.entity.constants.TempSettingsType;
import com.vendingmachine.repository.TemperatureSettingsRepository;
import com.vendingmachine.sensors.FridgeSensor;
import com.vendingmachine.sensors.WaterSensor;
import com.vendingmachine.service.TemperatureSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureSettingsServiceImpl implements TemperatureSettingsService {

    @Autowired
    private TemperatureSettingsRepository temperatureSettingsRepository;

    @Autowired
    private WaterSensor waterSensor;

    @Autowired
    private FridgeSensor fridgeSensor;

    @Override
    public Optional<TemperatureSettings> getById(String id) {
        return temperatureSettingsRepository.findById(id);
    }

    @Override
    public TemperatureSettings editTemperatureSettings(TemperatureSettings temperatureSettings) {
        updateSensorTemperatures(temperatureSettings);
        return temperatureSettingsRepository.saveAndFlush(temperatureSettings);
    }

    @Override
    public List<TemperatureSettings> getAll() {
        return temperatureSettingsRepository.findAll();
    }

    //TODO is it better to use custom event listener?
    /**
     * Updates temperature settings sensors, e.g. WaterSensor; FridgeSensor. It depends on setting type (field)
     * @param temperatureSettings to get min and max values of temperature
     */
    private void updateSensorTemperatures(TemperatureSettings temperatureSettings) {
        int minTemperature = temperatureSettings.getMinTemperature();
        int maxTemperature = temperatureSettings.getMaxTemperature();

        if (TempSettingsType.TYPE_WATER.equals(temperatureSettings.getType())) {
            waterSensor.setMinTemperature(minTemperature);
            waterSensor.setMaxTemperature(maxTemperature);
        } else if (TempSettingsType.TYPE_FREEZER.equals(temperatureSettings.getType())) {
            fridgeSensor.setMinTemperature(minTemperature);
            fridgeSensor.setMaxTemperature(maxTemperature);
        }
    }
}
