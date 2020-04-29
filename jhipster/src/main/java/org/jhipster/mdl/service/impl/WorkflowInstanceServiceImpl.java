package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.WorkflowInstanceService;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.repository.WorkflowInstanceRepository;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceParamsDTO;
import org.jhipster.mdl.service.mapper.WorkflowInstanceMapper;
import org.jhipster.mdl.workflow.to_transfert_data.WorkflowStepData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link WorkflowInstance}.
 */
@Service
@Transactional
public class WorkflowInstanceServiceImpl implements WorkflowInstanceService {

	private final Logger log = LoggerFactory.getLogger(WorkflowInstanceServiceImpl.class);

	private final WorkflowInstanceRepository workflowInstanceRepository;

	private final WorkflowInstanceMapper workflowInstanceMapper;

	public WorkflowInstanceServiceImpl(WorkflowInstanceRepository workflowInstanceRepository,
			WorkflowInstanceMapper workflowInstanceMapper) {
		this.workflowInstanceRepository = workflowInstanceRepository;
		this.workflowInstanceMapper = workflowInstanceMapper;
	}

	/**
	 * Save a workflowInstance.
	 *
	 * @param workflowInstanceDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public WorkflowInstanceDTO save(WorkflowInstanceDTO workflowInstanceDTO) {
		log.debug("Request to save WorkflowInstance : {}", workflowInstanceDTO);
		WorkflowInstance workflowInstance = workflowInstanceMapper.toEntity(workflowInstanceDTO);
		workflowInstance = workflowInstanceRepository.save(workflowInstance);
		return workflowInstanceMapper.toDto(workflowInstance);
	}

	/**
	 * Get all the workflowInstances.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<WorkflowInstanceDTO> findAll() {
		log.debug("Request to get all WorkflowInstances");
		return workflowInstanceRepository.findAllWithEagerRelationships().stream().map(workflowInstanceMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get all the workflowInstances with eager load of many-to-many relationships.
	 *
	 * @return the list of entities.
	 */
	public Page<WorkflowInstanceDTO> findAllWithEagerRelationships(Pageable pageable) {
		return workflowInstanceRepository.findAllWithEagerRelationships(pageable).map(workflowInstanceMapper::toDto);
	}

	/**
	 * Get one workflowInstance by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<WorkflowInstanceDTO> findOne(Long id) {
		log.debug("Request to get WorkflowInstance : {}", id);
		return workflowInstanceRepository.findOneWithEagerRelationships(id).map(workflowInstanceMapper::toDto);
	}

	/**
	 * Delete the workflowInstance by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete WorkflowInstance : {}", id);
		workflowInstanceRepository.deleteById(id);
	}

	@Override
	public Optional<WorkflowStepData> getWorkflowStep(String login, Long wfiID) {
		log.debug("Request wf step : {}", login, wfiID);
		return Optional.of(new WorkflowStepData());
	}

	@Override
	public Optional<WorkflowInstanceDTO> create(WorkflowInstanceParamsDTO workflowInstanceParamsDTO) {
		return Optional.of(new WorkflowInstanceDTO());
	}

	@Override
	public void addGuest(long wfiId, long mdlUserId) {
		// No implem on this branch
	}

	@Override
	public void removeGuest(long wfiId, long mdlUserId) {
		// No implem on this branch
	}
}
