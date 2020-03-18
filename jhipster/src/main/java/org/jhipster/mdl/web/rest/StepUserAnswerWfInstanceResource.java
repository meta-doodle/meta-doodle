package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.StepUserAnswerWfInstanceService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.StepUserAnswerWfInstanceDTO;

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

/**
 * REST controller for managing {@link org.jhipster.mdl.domain.StepUserAnswerWfInstance}.
 */
@RestController
@RequestMapping("/api")
public class StepUserAnswerWfInstanceResource {

    private final Logger log = LoggerFactory.getLogger(StepUserAnswerWfInstanceResource.class);

    private static final String ENTITY_NAME = "stepUserAnswerWfInstance";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StepUserAnswerWfInstanceService stepUserAnswerWfInstanceService;

    public StepUserAnswerWfInstanceResource(StepUserAnswerWfInstanceService stepUserAnswerWfInstanceService) {
        this.stepUserAnswerWfInstanceService = stepUserAnswerWfInstanceService;
    }

    /**
     * {@code POST  /step-user-answer-wf-instances} : Create a new stepUserAnswerWfInstance.
     *
     * @param stepUserAnswerWfInstanceDTO the stepUserAnswerWfInstanceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stepUserAnswerWfInstanceDTO, or with status {@code 400 (Bad Request)} if the stepUserAnswerWfInstance has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/step-user-answer-wf-instances")
    public ResponseEntity<StepUserAnswerWfInstanceDTO> createStepUserAnswerWfInstance(@RequestBody StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO) throws URISyntaxException {
        log.debug("REST request to save StepUserAnswerWfInstance : {}", stepUserAnswerWfInstanceDTO);
        if (stepUserAnswerWfInstanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new stepUserAnswerWfInstance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StepUserAnswerWfInstanceDTO result = stepUserAnswerWfInstanceService.save(stepUserAnswerWfInstanceDTO);
        return ResponseEntity.created(new URI("/api/step-user-answer-wf-instances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /step-user-answer-wf-instances} : Updates an existing stepUserAnswerWfInstance.
     *
     * @param stepUserAnswerWfInstanceDTO the stepUserAnswerWfInstanceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stepUserAnswerWfInstanceDTO,
     * or with status {@code 400 (Bad Request)} if the stepUserAnswerWfInstanceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stepUserAnswerWfInstanceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/step-user-answer-wf-instances")
    public ResponseEntity<StepUserAnswerWfInstanceDTO> updateStepUserAnswerWfInstance(@RequestBody StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO) throws URISyntaxException {
        log.debug("REST request to update StepUserAnswerWfInstance : {}", stepUserAnswerWfInstanceDTO);
        if (stepUserAnswerWfInstanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StepUserAnswerWfInstanceDTO result = stepUserAnswerWfInstanceService.save(stepUserAnswerWfInstanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, stepUserAnswerWfInstanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /step-user-answer-wf-instances} : get all the stepUserAnswerWfInstances.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stepUserAnswerWfInstances in body.
     */
    @GetMapping("/step-user-answer-wf-instances")
    public List<StepUserAnswerWfInstanceDTO> getAllStepUserAnswerWfInstances() {
        log.debug("REST request to get all StepUserAnswerWfInstances");
        return stepUserAnswerWfInstanceService.findAll();
    }

    /**
     * {@code GET  /step-user-answer-wf-instances/:id} : get the "id" stepUserAnswerWfInstance.
     *
     * @param id the id of the stepUserAnswerWfInstanceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stepUserAnswerWfInstanceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/step-user-answer-wf-instances/{id}")
    public ResponseEntity<StepUserAnswerWfInstanceDTO> getStepUserAnswerWfInstance(@PathVariable Long id) {
        log.debug("REST request to get StepUserAnswerWfInstance : {}", id);
        Optional<StepUserAnswerWfInstanceDTO> stepUserAnswerWfInstanceDTO = stepUserAnswerWfInstanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stepUserAnswerWfInstanceDTO);
    }

    /**
     * {@code DELETE  /step-user-answer-wf-instances/:id} : delete the "id" stepUserAnswerWfInstance.
     *
     * @param id the id of the stepUserAnswerWfInstanceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/step-user-answer-wf-instances/{id}")
    public ResponseEntity<Void> deleteStepUserAnswerWfInstance(@PathVariable Long id) {
        log.debug("REST request to delete StepUserAnswerWfInstance : {}", id);
        stepUserAnswerWfInstanceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
