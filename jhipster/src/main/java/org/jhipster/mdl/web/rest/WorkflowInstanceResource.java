package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.security.SecurityUtils;
import org.jhipster.mdl.service.MdlUserService;
import org.jhipster.mdl.service.WorkflowInstanceService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.MdlUserDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceParamsDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing
 * {@link org.jhipster.mdl.domain.WorkflowInstance}.
 */
@RestController
@RequestMapping("/api")
public class WorkflowInstanceResource {

	private final Logger log = LoggerFactory.getLogger(WorkflowInstanceResource.class);

	private static final String ENTITY_NAME = "workflowInstance";

	@Value("${jhipster.clientApp.name}")
	private String applicationName;

	private final WorkflowInstanceService workflowInstanceService;
	
	private final MdlUserService mdlUserService;

	public WorkflowInstanceResource(WorkflowInstanceService workflowInstanceService, MdlUserService mdlUserService) {
		this.workflowInstanceService = workflowInstanceService;
		this.mdlUserService = mdlUserService;
	}

	/**
	 * {@code POST  /workflow-instances} : Create a new workflowInstance.
	 *
	 * @param workflowInstanceDTO the workflowInstanceDTO to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
	 *         body the new workflowInstanceDTO, or with status
	 *         {@code 400 (Bad Request)} if the workflowInstance has already an ID.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PostMapping("/workflow-instances")
	public ResponseEntity<WorkflowInstanceDTO> createWorkflowInstance(
			@RequestBody WorkflowInstanceDTO workflowInstanceDTO) throws URISyntaxException {
		log.debug("REST request to save WorkflowInstance : {}", workflowInstanceDTO);
		if (workflowInstanceDTO.getId() != null) {
			throw new BadRequestAlertException("A new workflowInstance cannot already have an ID", ENTITY_NAME,
					"idexists");
		}
		WorkflowInstanceDTO result = workflowInstanceService.save(workflowInstanceDTO);
		return ResponseEntity
				.created(new URI("/api/workflow-instances/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
				.body(result);
	}

	/**
	 * {@code PUT  /workflow-instances} : Updates an existing workflowInstance.
	 *
	 * @param workflowInstanceDTO the workflowInstanceDTO to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the updated workflowInstanceDTO, or with status
	 *         {@code 400 (Bad Request)} if the workflowInstanceDTO is not valid, or
	 *         with status {@code 500 (Internal Server Error)} if the
	 *         workflowInstanceDTO couldn't be updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping("/workflow-instances")
	public ResponseEntity<WorkflowInstanceDTO> updateWorkflowInstance(
			@RequestBody WorkflowInstanceDTO workflowInstanceDTO) throws URISyntaxException {
		log.debug("REST request to update WorkflowInstance : {}", workflowInstanceDTO);
		if (workflowInstanceDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		WorkflowInstanceDTO result = workflowInstanceService.save(workflowInstanceDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
				workflowInstanceDTO.getId().toString())).body(result);
	}

	/**
	 * {@code GET  /workflow-instances} : get all the workflowInstances.
	 *
	 * @param eagerload flag to eager load entities from relationships (This is
	 *                  applicable for many-to-many).
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
	 *         of workflowInstances in body.
	 */
	@GetMapping("/workflow-instances")
	public List<WorkflowInstanceDTO> getAllWorkflowInstances(
			@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
		log.debug("REST request to get all WorkflowInstances");
		return workflowInstanceService.findAll();
	}

	/**
	 * {@code GET  /workflow-instances/:id} : get the "id" workflowInstance.
	 *
	 * @param id the id of the workflowInstanceDTO to retrieve.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the workflowInstanceDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/workflow-instances/{id}")
	public ResponseEntity<WorkflowInstanceDTO> getWorkflowInstance(@PathVariable Long id) {
		log.debug("REST request to get WorkflowInstance : {}", id);
		Optional<WorkflowInstanceDTO> workflowInstanceDTO = workflowInstanceService.findOne(id);
		return ResponseUtil.wrapOrNotFound(workflowInstanceDTO);
	}

	/**
	 * {@code DELETE  /workflow-instances/:id} : delete the "id" workflowInstance.
	 *
	 * @param id the id of the workflowInstanceDTO to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */
	@DeleteMapping("/workflow-instances/{id}")
	public ResponseEntity<Void> deleteWorkflowInstance(@PathVariable Long id) {
		log.debug("REST request to delete WorkflowInstance : {}", id);
		workflowInstanceService.delete(id);
		return ResponseEntity.noContent()
				.headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
				.build();
	}

	@GetMapping("/workflow-instances-view/{login}/{idWFI}")
	public ResponseEntity<StepDTO> getWorkflowStepData(@PathVariable String login, @PathVariable Long idWFI) {
		log.debug("REST request to get WorkflowStepData : {}", login, idWFI);
		Optional<StepDTO> data = workflowInstanceService.getWorkflowStep(login, idWFI);
		return ResponseUtil.wrapOrNotFound(data);
	}

	@PostMapping("/workflow-instances/create")
	public ResponseEntity<WorkflowInstanceDTO> createWorkflowInstancePerso(
			@RequestBody WorkflowInstanceParamsDTO workflowInstanceParamsDTO) {
		log.debug("REST request to get create new Worflow Instance : {}", workflowInstanceParamsDTO);
		if (workflowInstanceParamsDTO.getCreatorId() == null) {
			throw new BadRequestAlertException("Invalide user creator ID", ENTITY_NAME,
					"idnull");
		}
		if (workflowInstanceParamsDTO.getWfModelId() == null) {
			throw new BadRequestAlertException("Invalide workflox model ID", ENTITY_NAME,
					"idnull");
		}
		Optional<WorkflowInstanceDTO> workflowInstance = workflowInstanceService.create(workflowInstanceParamsDTO);
		return ResponseUtil.wrapOrNotFound(workflowInstance);
	}
	
	@PutMapping("/workflow-instances/{idWFI}/join/{idMdlUser}")
	public ResponseEntity<WorkflowInstanceDTO> joinWorkflowInstance(@PathVariable Long idWFI, @PathVariable Long idMdlUser) {
		// Only the user of the workflow owner are allowed to perform this action
		
		Optional<String> currentUserLogin = SecurityUtils.getCurrentUserLogin();
		if( currentUserLogin.isPresent() ) {
			Optional<MdlUserDTO> currentMdlUser = mdlUserService.convert(currentUserLogin.get());
			Optional<MdlUserDTO> userToAdd = mdlUserService.findOne(idMdlUser);
			Optional<WorkflowInstanceDTO> wfi = workflowInstanceService.findOne(idWFI);
			if(currentMdlUser.isPresent() && userToAdd.isPresent() && wfi.isPresent()) {
				// Check if the current user is the one added or the wf instance owner
				if( currentMdlUser.get().getId().equals(userToAdd.get().getId())
						|| currentMdlUser.get().getId().equals(wfi.get().getCreatorId()) ) {
					workflowInstanceService.addGuest(idWFI, idMdlUser);
					return ResponseEntity.ok(workflowInstanceService.findOne(idWFI).get());
				} else {
					log.error("Unauthorized attempt to join a workflow from "+currentMdlUser.get().getUserId());
					return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/workflow-instances/{idWFI}/leave/{idMdlUser}")
	public ResponseEntity<WorkflowInstanceDTO> leaveWorkflowInstance(@PathVariable Long idWFI, @PathVariable Long idMdlUser) {
		// Only the user of the workflow owner are allowed to perform this action
		
		Optional<String> currentUserLogin = SecurityUtils.getCurrentUserLogin();
		if( currentUserLogin.isPresent() ) {
			Optional<MdlUserDTO> currentMdlUser = mdlUserService.convert(currentUserLogin.get());
			Optional<MdlUserDTO> userToAdd = mdlUserService.findOne(idMdlUser);
			Optional<WorkflowInstanceDTO> wfi = workflowInstanceService.findOne(idWFI);
			if(currentMdlUser.isPresent() && userToAdd.isPresent() && wfi.isPresent()) {
				// Check if the current user is the one removed or the wf instance owner
				if( currentMdlUser.get().getId().equals(userToAdd.get().getId())
						|| currentMdlUser.get().getId().equals(wfi.get().getCreatorId()) ) {
					workflowInstanceService.removeGuest(idWFI, idMdlUser);
					return ResponseEntity.ok(workflowInstanceService.findOne(idWFI).get());
				} else {
					log.error("Unauthorized attempt to leave a workflow from "+currentMdlUser.get().getUserId());
					return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
}
