package com.vendingmachine.service;

import com.vendingmachine.entity.ErrorEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ErrorEntityService {
    void markAsSolved(long errorId);
    void addNewError(String type, LocalDateTime date);
    List<ErrorEntity> getAll();
}
