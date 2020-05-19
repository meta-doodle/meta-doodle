package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.WorkflowInstanceService;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.User;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.domain.WorkflowModel;
import org.jhipster.mdl.interpreter.InterpreterInterface;
import org.jhipster.mdl.repository.MdlUserRepository;
import org.jhipster.mdl.repository.WorkflowInstanceRepository;
import org.jhipster.mdl.repository.WorkflowModelRepository;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceParamsDTO;
import org.jhipster.mdl.service.mapper.WorkflowInstanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;

import java.util.ArrayList;
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

	private WorkflowModelRepository workflowModelRepository;

	private MdlUserRepository mdlUserRepository;

	private InterpreterInterface interpreterInterface;

	public WorkflowInstanceServiceImpl(WorkflowInstanceRepository workflowInstanceRepository,
			WorkflowInstanceMapper workflowInstanceMapper, WorkflowModelRepository workflowModelRepository,
			MdlUserRepository mdlUserRepository, InterpreterInterface interpreterInterface) {
		this.workflowInstanceRepository = workflowInstanceRepository;
		this.workflowInstanceMapper = workflowInstanceMapper;
		this.workflowModelRepository = workflowModelRepository;
		this.mdlUserRepository = mdlUserRepository;
		this.interpreterInterface = interpreterInterface;
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
	public Optional<StepDTO> getWorkflowStep(String login, Long wfiID) {
		log.debug("Request wf step : {}", login, wfiID);

		if (wfiID == null) {
			log.debug("wfiID is null");
			return Optional.empty();
		}

		Optional<WorkflowInstance> optWFI = workflowInstanceRepository.findById(wfiID);

		if (!optWFI.isPresent()) {
			log.debug("WorkflowInstance not found in BDD with id : {}", wfiID);
			return Optional.empty();
		}

		WorkflowInstance wfi = optWFI.get();
		Optional<MdlUser> mdlUser = wfi.findMdlUserByLogin(login);

		if (!mdlUser.isPresent()) {
			log.debug("MdlUser {} not found in WorkflowInstance guests", login);
			return Optional.empty();
		}

//		WorkflowExecutionStateImpl workflowExecutionStateImpl = new WorkflowExecutionStateImpl(wfi, mdlUser.get(),
//				currentStepRepository, answerRepository);
//		workflowExecutionStateImpl.setEndOfStep(true);

		return interpreterInterface.getStepDTO(wfi, mdlUser.get());

		/*
		 * FakeReturnExec ret = FakeInterpreter.INTERPRETER.exec(
		 * wfi.getWfModel().getBody(), new
		 * FakeState(Integer.parseInt(step.getStepIdent()), wfi.getGuests().size(), 0));
		 * return Optional.of(ret.stepData);
		 */

	}

	@Override
	public Optional<WorkflowInstanceDTO> create(WorkflowInstanceParamsDTO workflowInstanceParamsDTO) {
		WorkflowInstance workflowInstance = new WorkflowInstance();

		Optional<MdlUser> optMdlUser = mdlUserRepository.findById(workflowInstanceParamsDTO.getCreatorId());
		Optional<WorkflowModel> optWFM = workflowModelRepository.findById(workflowInstanceParamsDTO.getWfModelId());

		if (optMdlUser.isPresent()) {
			workflowInstance.setCreator(optMdlUser.get());
		} else {
			log.debug("MdlUser not found in DB with id {}", workflowInstanceParamsDTO.getCreatorId());
			return Optional.empty();
		}

		if (optWFM.isPresent()) {
			workflowInstance.setWfModel(optWFM.get());
		} else {
			log.debug("WorkflowModel not found in DB with id {}", workflowInstanceParamsDTO.getWfModelId());
			return Optional.empty();
		}

		for (MdlUser mdlUser : mdlUserRepository.findAll()) {
			for (String mails : workflowInstanceParamsDTO.getGuests()) {
				User user = mdlUser.getUser();
				if (user != null && mails.equalsIgnoreCase(user.getEmail())) {
					log.info("New user add in workflowinstance : {}", user.getLogin());
					workflowInstance.addGuests(mdlUser);
				}
			}
		}

		workflowInstance = workflowInstanceRepository.save(workflowInstance);

		interpreterInterface.initNewWorkflowData(optWFM.get().getBody(), workflowInstance);

		workflowInstance = workflowInstanceRepository.save(workflowInstance);

		return Optional.of(workflowInstanceMapper.toDto(workflowInstance));
	}

	@Override
	public void addGuest(long wfiId, long mdlUserId) {
		MdlUser user = mdlUserRepository.getOne(mdlUserId);
		workflowInstanceRepository.save(workflowInstanceRepository.getOne(wfiId).addGuests(user));
	}

	@Override
	public void removeGuest(long wfiId, long mdlUserId) {
		MdlUser user = mdlUserRepository.getOne(mdlUserId);
		workflowInstanceRepository.save(workflowInstanceRepository.getOne(wfiId).removeGuests(user));
	}

	@Override
	public List<String> getRoles(Long idWFI) {
		// No implem on this branch
		return new ArrayList<String>();
	}
}
