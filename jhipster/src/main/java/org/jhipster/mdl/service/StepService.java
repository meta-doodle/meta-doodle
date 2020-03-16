package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.StepDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.Step}.
 */
public interface StepService {

    /**
     * Save a step.
     *
     * @param stepDTO the entity to save.
     * @return the persisted entity.
     */
    StepDTO save(StepDTO stepDTO);

    /**
     * Get all the steps.
     *
     * @return the list of entities.
     */
    List<StepDTO> findAll();
    /**
     * Get all the StepDTO where StepUserAnswer is {@code null}.
     *
     * @return the list of entities.
     */
    List<StepDTO> findAllWhereStepUserAnswerIsNull();


    /**
     * Get the "id" step.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StepDTO> findOne(Long id);

    /**
     * Delete the "id" step.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
