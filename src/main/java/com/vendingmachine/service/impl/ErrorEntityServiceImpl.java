package com.vendingmachine.service.impl;

import com.vendingmachine.entity.ErrorEntity;
import com.vendingmachine.repository.ErrorEntityRepository;
import com.vendingmachine.service.ErrorEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ErrorEntityServiceImpl implements ErrorEntityService {

    @Autowired
    private ErrorEntityRepository errorEntityRepository;

    /**
     * Adds new ErrorEntity {@link com.vendingmachine.entity.ErrorEntity} to db.
     * If unsolved error with specific type already exist,
     * it just updates date. Otherwise it creates new error of given type.
     * @param type
     * @param date
     */
    @Override
    public void addNewError(String type, LocalDateTime date) {
        List<ErrorEntity> errorEntityList = errorEntityRepository.findErrorEntityByTypeUnsolved(type);
        int errorEntityListSize = errorEntityList.size();
        if (errorEntityListSize > 1) {
            //TODO logger something went wrong with DB logic.
            // There are more than one error items unsolved with the same type
        } else if (errorEntityListSize == 1) {
            //update date of existing error unsolved with specific type
            ErrorEntity errorEntity = errorEntityList.get(0);
            errorEntity.setDate(date);
            errorEntityRepository.saveAndFlush(errorEntity);
        } else {
            ErrorEntity error = new ErrorEntity(type, date, false);
            errorEntityRepository.saveAndFlush(error);
        }
    }

    @Override
    public List<ErrorEntity> getAll() {
        return errorEntityRepository.findAll();
    }

    /**
     * Changes field('solved') to true of ErrorEntity {@link com.vendingmachine.entity.ErrorEntity} in DB
     * @param errorId
     * @throws EntityNotFoundException
     */
    @Override
    public void markAsSolved(long errorId) throws EntityNotFoundException {
        Optional<ErrorEntity> optionalErrorEntity = errorEntityRepository.findById(errorId);
        if (!optionalErrorEntity.isPresent()) {
            throw new EntityNotFoundException("Entity ErrorEntity with id " + errorId + " not found in DB");
        }
        ErrorEntity errorEntity = optionalErrorEntity.get();
        errorEntity.setSolved(true);
        errorEntityRepository.saveAndFlush(errorEntity);
    }
}
