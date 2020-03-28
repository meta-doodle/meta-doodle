package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.WorkflowInstanceStateService;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.jhipster.mdl.repository.WorkflowInstanceStateRepository;
import org.jhipster.mdl.service.dto.WorkflowInstanceStateDTO;
import org.jhipster.mdl.service.mapper.WorkflowInstanceStateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link WorkflowInstanceState}.
 */
@Service
@Transactional
public class WorkflowInstanceStateServiceImpl implements WorkflowInstanceStateService {

    private final Logger log = LoggerFactory.getLogger(WorkflowInstanceStateServiceImpl.class);

    private final WorkflowInstanceStateRepository workflowInstanceStateRepository;

    private final WorkflowInstanceStateMapper workflowInstanceStateMapper;

    public WorkflowInstanceStateServiceImpl(WorkflowInstanceStateRepository workflowInstanceStateRepository, WorkflowInstanceStateMapper workflowInstanceStateMapper) {
        this.workflowInstanceStateRepository = workflowInstanceStateRepository;
        this.workflowInstanceStateMapper = workflowInstanceStateMapper;
    }

    /**
     * Save a workflowInstanceState.
     *
     * @param workflowInstanceStateDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public WorkflowInstanceStateDTO save(WorkflowInstanceStateDTO workflowInstanceStateDTO) {
        log.debug("Request to save WorkflowInstanceState : {}", workflowInstanceStateDTO);
        WorkflowInstanceState workflowInstanceState = workflowInstanceStateMapper.toEntity(workflowInstanceStateDTO);
        workflowInstanceState = workflowInstanceStateRepository.save(workflowInstanceState);
        return workflowInstanceStateMapper.toDto(workflowInstanceState);
    }

    /**
     * Get all the workflowInstanceStates.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<WorkflowInstanceStateDTO> findAll() {
        log.debug("Request to get all WorkflowInstanceStates");
        return workflowInstanceStateRepository.findAll().stream()
            .map(workflowInstanceStateMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     *  Get all the workflowInstanceStates where WorkflowInstance is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<WorkflowInstanceStateDTO> findAllWhereWorkflowInstanceIsNull() {
        log.debug("Request to get all workflowInstanceStates where WorkflowInstance is null");
        return StreamSupport
            .stream(workflowInstanceStateRepository.findAll().spliterator(), false)
            .filter(workflowInstanceState -> workflowInstanceState.getWorkflowInstance() == null)
            .map(workflowInstanceStateMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one workflowInstanceState by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WorkflowInstanceStateDTO> findOne(Long id) {
        log.debug("Request to get WorkflowInstanceState : {}", id);
        return workflowInstanceStateRepository.findById(id)
            .map(workflowInstanceStateMapper::toDto);
    }

    /**
     * Delete the workflowInstanceState by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WorkflowInstanceState : {}", id);
        workflowInstanceStateRepository.deleteById(id);
    }
}
