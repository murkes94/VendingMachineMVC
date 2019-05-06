package com.vendingmachine.service;

import com.vendingmachine.entity.TemperatureSettings;

import java.util.List;
import java.util.Optional;

public interface TemperatureSettingsService {
    Optional<TemperatureSettings> getById(String id);
    TemperatureSettings editTemperatureSettings(TemperatureSettings temperatureSettings);
    List<TemperatureSettings> getAll();
}
