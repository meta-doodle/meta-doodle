package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.WorkflowModelDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.WorkflowModel}.
 */
public interface WorkflowModelService {

    /**
     * Save a workflowModel.
     *
     * @param workflowModelDTO the entity to save.
     * @return the persisted entity.
     */
    WorkflowModelDTO save(WorkflowModelDTO workflowModelDTO);

    /**
     * Get all the workflowModels.
     *
     * @return the list of entities.
     */
    List<WorkflowModelDTO> findAll();


    /**
     * Get the "id" workflowModel.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WorkflowModelDTO> findOne(Long id);

    /**
     * Delete the "id" workflowModel.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
