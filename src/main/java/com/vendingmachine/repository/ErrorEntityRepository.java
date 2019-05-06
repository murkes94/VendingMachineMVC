package com.vendingmachine.repository;

import com.vendingmachine.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ErrorEntityRepository extends JpaRepository<ErrorEntity, Long> {

    /**
     * Gets ErrorEntity with specific type unsolved.
     * This List should contain one element, otherwise something went wrong.
     * @param type
     * @return List of ErrorEntity {@link com.vendingmachine.entity.ErrorEntity}
     */
    @Query("SELECT e FROM ErrorEntity e WHERE e.type = ?1 and e.solved = false")
    List<ErrorEntity> findErrorEntityByTypeUnsolved(String type);
}
