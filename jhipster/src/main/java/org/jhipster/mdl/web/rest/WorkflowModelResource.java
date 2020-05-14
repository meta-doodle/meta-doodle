package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.WorkflowModelService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.WorkflowModelDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link org.jhipster.mdl.domain.WorkflowModel}.
 */
@RestController
@RequestMapping("/api")
public class WorkflowModelResource {

    private final Logger log = LoggerFactory.getLogger(WorkflowModelResource.class);

    private static final String ENTITY_NAME = "workflowModel";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkflowModelService workflowModelService;

    public WorkflowModelResource(WorkflowModelService workflowModelService) {
        this.workflowModelService = workflowModelService;
    }

    /**
     * {@code POST  /workflow-models} : Create a new workflowModel.
     *
     * @param workflowModelDTO the workflowModelDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workflowModelDTO, or with status {@code 400 (Bad Request)} if the workflowModel has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/workflow-models")
    public ResponseEntity<WorkflowModelDTO> createWorkflowModel(@Valid @RequestBody WorkflowModelDTO workflowModelDTO) throws URISyntaxException {
        log.debug("REST request to save WorkflowModel : {}", workflowModelDTO);
        if (workflowModelDTO.getId() != null) {
            throw new BadRequestAlertException("A new workflowModel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkflowModelDTO result = workflowModelService.save(workflowModelDTO);
        return ResponseEntity.created(new URI("/api/workflow-models/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /workflow-models} : Updates an existing workflowModel.
     *
     * @param workflowModelDTO the workflowModelDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workflowModelDTO,
     * or with status {@code 400 (Bad Request)} if the workflowModelDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workflowModelDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/workflow-models")
    public ResponseEntity<WorkflowModelDTO> updateWorkflowModel(@Valid @RequestBody WorkflowModelDTO workflowModelDTO) throws URISyntaxException {
        log.debug("REST request to update WorkflowModel : {}", workflowModelDTO);
        if (workflowModelDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkflowModelDTO result = workflowModelService.save(workflowModelDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workflowModelDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /workflow-models} : get all the workflowModels.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workflowModels in body.
     */
    @GetMapping("/workflow-models")
    public List<WorkflowModelDTO> getAllWorkflowModels() {
        log.debug("REST request to get all WorkflowModels");
        return workflowModelService.findAll();
    }

    /**
     * {@code GET  /workflow-models/:id} : get the "id" workflowModel.
     *
     * @param id the id of the workflowModelDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workflowModelDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/workflow-models/{id}")
    public ResponseEntity<WorkflowModelDTO> getWorkflowModel(@PathVariable Long id) {
        log.debug("REST request to get WorkflowModel : {}", id);
        Optional<WorkflowModelDTO> workflowModelDTO = workflowModelService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workflowModelDTO);
    }

    /**
     * {@code DELETE  /workflow-models/:id} : delete the "id" workflowModel.
     *
     * @param id the id of the workflowModelDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/workflow-models/{id}")
    public ResponseEntity<Void> deleteWorkflowModel(@PathVariable Long id) {
        log.debug("REST request to delete WorkflowModel : {}", id);
        workflowModelService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
