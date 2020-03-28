package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.WorkflowInstanceStateService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.WorkflowInstanceStateDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link org.jhipster.mdl.domain.WorkflowInstanceState}.
 */
@RestController
@RequestMapping("/api")
public class WorkflowInstanceStateResource {

    private final Logger log = LoggerFactory.getLogger(WorkflowInstanceStateResource.class);

    private static final String ENTITY_NAME = "workflowInstanceState";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkflowInstanceStateService workflowInstanceStateService;

    public WorkflowInstanceStateResource(WorkflowInstanceStateService workflowInstanceStateService) {
        this.workflowInstanceStateService = workflowInstanceStateService;
    }

    /**
     * {@code POST  /workflow-instance-states} : Create a new workflowInstanceState.
     *
     * @param workflowInstanceStateDTO the workflowInstanceStateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workflowInstanceStateDTO, or with status {@code 400 (Bad Request)} if the workflowInstanceState has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/workflow-instance-states")
    public ResponseEntity<WorkflowInstanceStateDTO> createWorkflowInstanceState(@RequestBody WorkflowInstanceStateDTO workflowInstanceStateDTO) throws URISyntaxException {
        log.debug("REST request to save WorkflowInstanceState : {}", workflowInstanceStateDTO);
        if (workflowInstanceStateDTO.getId() != null) {
            throw new BadRequestAlertException("A new workflowInstanceState cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkflowInstanceStateDTO result = workflowInstanceStateService.save(workflowInstanceStateDTO);
        return ResponseEntity.created(new URI("/api/workflow-instance-states/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /workflow-instance-states} : Updates an existing workflowInstanceState.
     *
     * @param workflowInstanceStateDTO the workflowInstanceStateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workflowInstanceStateDTO,
     * or with status {@code 400 (Bad Request)} if the workflowInstanceStateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workflowInstanceStateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/workflow-instance-states")
    public ResponseEntity<WorkflowInstanceStateDTO> updateWorkflowInstanceState(@RequestBody WorkflowInstanceStateDTO workflowInstanceStateDTO) throws URISyntaxException {
        log.debug("REST request to update WorkflowInstanceState : {}", workflowInstanceStateDTO);
        if (workflowInstanceStateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkflowInstanceStateDTO result = workflowInstanceStateService.save(workflowInstanceStateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workflowInstanceStateDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /workflow-instance-states} : get all the workflowInstanceStates.
     *
     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workflowInstanceStates in body.
     */
    @GetMapping("/workflow-instance-states")
    public List<WorkflowInstanceStateDTO> getAllWorkflowInstanceStates(@RequestParam(required = false) String filter) {
        if ("workflowinstance-is-null".equals(filter)) {
            log.debug("REST request to get all WorkflowInstanceStates where workflowInstance is null");
            return workflowInstanceStateService.findAllWhereWorkflowInstanceIsNull();
        }
        log.debug("REST request to get all WorkflowInstanceStates");
        return workflowInstanceStateService.findAll();
    }

    /**
     * {@code GET  /workflow-instance-states/:id} : get the "id" workflowInstanceState.
     *
     * @param id the id of the workflowInstanceStateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workflowInstanceStateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/workflow-instance-states/{id}")
    public ResponseEntity<WorkflowInstanceStateDTO> getWorkflowInstanceState(@PathVariable Long id) {
        log.debug("REST request to get WorkflowInstanceState : {}", id);
        Optional<WorkflowInstanceStateDTO> workflowInstanceStateDTO = workflowInstanceStateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workflowInstanceStateDTO);
    }

    /**
     * {@code DELETE  /workflow-instance-states/:id} : delete the "id" workflowInstanceState.
     *
     * @param id the id of the workflowInstanceStateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/workflow-instance-states/{id}")
    public ResponseEntity<Void> deleteWorkflowInstanceState(@PathVariable Long id) {
        log.debug("REST request to delete WorkflowInstanceState : {}", id);
        workflowInstanceStateService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
