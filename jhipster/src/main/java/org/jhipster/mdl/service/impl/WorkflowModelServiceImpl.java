package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.WorkflowModelService;
import org.jhipster.mdl.domain.WorkflowModel;
import org.jhipster.mdl.repository.WorkflowModelRepository;
import org.jhipster.mdl.service.dto.WorkflowModelDTO;
import org.jhipster.mdl.service.mapper.WorkflowModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link WorkflowModel}.
 */
@Service
@Transactional
public class WorkflowModelServiceImpl implements WorkflowModelService {

    private final Logger log = LoggerFactory.getLogger(WorkflowModelServiceImpl.class);

    private final WorkflowModelRepository workflowModelRepository;

    private final WorkflowModelMapper workflowModelMapper;

    public WorkflowModelServiceImpl(WorkflowModelRepository workflowModelRepository, WorkflowModelMapper workflowModelMapper) {
        this.workflowModelRepository = workflowModelRepository;
        this.workflowModelMapper = workflowModelMapper;
    }

    /**
     * Save a workflowModel.
     *
     * @param workflowModelDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public WorkflowModelDTO save(WorkflowModelDTO workflowModelDTO) {
        log.debug("Request to save WorkflowModel : {}", workflowModelDTO);
        WorkflowModel workflowModel = workflowModelMapper.toEntity(workflowModelDTO);
        workflowModel = workflowModelRepository.save(workflowModel);
        return workflowModelMapper.toDto(workflowModel);
    }

    /**
     * Get all the workflowModels.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<WorkflowModelDTO> findAll() {
        log.debug("Request to get all WorkflowModels");
        return workflowModelRepository.findAll().stream()
            .map(workflowModelMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one workflowModel by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WorkflowModelDTO> findOne(Long id) {
        log.debug("Request to get WorkflowModel : {}", id);
        return workflowModelRepository.findById(id)
            .map(workflowModelMapper::toDto);
    }

    /**
     * Delete the workflowModel by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WorkflowModel : {}", id);
        workflowModelRepository.deleteById(id);
    }
}
