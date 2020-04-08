package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.workflow.to_transfert_data.WorkflowStepData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.WorkflowInstance}.
 */
public interface WorkflowInstanceService {

    /**
     * Save a workflowInstance.
     *
     * @param workflowInstanceDTO the entity to save.
     * @return the persisted entity.
     */
    WorkflowInstanceDTO save(WorkflowInstanceDTO workflowInstanceDTO);

    /**
     * Get all the workflowInstances.
     *
     * @return the list of entities.
     */
    List<WorkflowInstanceDTO> findAll();

    /**
     * Get all the workflowInstances with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<WorkflowInstanceDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" workflowInstance.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WorkflowInstanceDTO> findOne(Long id);

    /**
     * Delete the "id" workflowInstance.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    Optional<WorkflowStepData> getWorkflowStep(String login, Long wfiID);
}
