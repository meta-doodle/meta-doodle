package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.WorkflowInstanceStateDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.WorkflowInstanceState}.
 */
public interface WorkflowInstanceStateService {

    /**
     * Save a workflowInstanceState.
     *
     * @param workflowInstanceStateDTO the entity to save.
     * @return the persisted entity.
     */
    WorkflowInstanceStateDTO save(WorkflowInstanceStateDTO workflowInstanceStateDTO);

    /**
     * Get all the workflowInstanceStates.
     *
     * @return the list of entities.
     */
    List<WorkflowInstanceStateDTO> findAll();
    /**
     * Get all the WorkflowInstanceStateDTO where WorkflowInstance is {@code null}.
     *
     * @return the list of entities.
     */
    List<WorkflowInstanceStateDTO> findAllWhereWorkflowInstanceIsNull();

    /**
     * Get the "id" workflowInstanceState.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WorkflowInstanceStateDTO> findOne(Long id);

    /**
     * Delete the "id" workflowInstanceState.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
