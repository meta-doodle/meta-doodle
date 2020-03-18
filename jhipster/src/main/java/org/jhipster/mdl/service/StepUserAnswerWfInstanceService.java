package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.StepUserAnswerWfInstanceDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.StepUserAnswerWfInstance}.
 */
public interface StepUserAnswerWfInstanceService {

    /**
     * Save a stepUserAnswerWfInstance.
     *
     * @param stepUserAnswerWfInstanceDTO the entity to save.
     * @return the persisted entity.
     */
    StepUserAnswerWfInstanceDTO save(StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO);

    /**
     * Get all the stepUserAnswerWfInstances.
     *
     * @return the list of entities.
     */
    List<StepUserAnswerWfInstanceDTO> findAll();


    /**
     * Get the "id" stepUserAnswerWfInstance.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StepUserAnswerWfInstanceDTO> findOne(Long id);

    /**
     * Delete the "id" stepUserAnswerWfInstance.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
