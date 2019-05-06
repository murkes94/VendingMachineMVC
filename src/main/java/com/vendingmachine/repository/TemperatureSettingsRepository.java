package com.vendingmachine.repository;

import com.vendingmachine.entity.TemperatureSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureSettingsRepository extends JpaRepository<TemperatureSettings, String> {
}
