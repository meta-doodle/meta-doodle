package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.CurrentStepDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.CurrentStep}.
 */
public interface CurrentStepService {

    /**
     * Save a currentStep.
     *
     * @param currentStepDTO the entity to save.
     * @return the persisted entity.
     */
    CurrentStepDTO save(CurrentStepDTO currentStepDTO);

    /**
     * Get all the currentSteps.
     *
     * @return the list of entities.
     */
    List<CurrentStepDTO> findAll();

    /**
     * Get the "id" currentStep.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CurrentStepDTO> findOne(Long id);

    /**
     * Delete the "id" currentStep.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
