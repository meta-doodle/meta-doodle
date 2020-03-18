package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.StepService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.StepDTO;

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
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link org.jhipster.mdl.domain.Step}.
 */
@RestController
@RequestMapping("/api")
public class StepResource {

    private final Logger log = LoggerFactory.getLogger(StepResource.class);

    private static final String ENTITY_NAME = "step";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StepService stepService;

    public StepResource(StepService stepService) {
        this.stepService = stepService;
    }

    /**
     * {@code POST  /steps} : Create a new step.
     *
     * @param stepDTO the stepDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stepDTO, or with status {@code 400 (Bad Request)} if the step has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/steps")
    public ResponseEntity<StepDTO> createStep(@Valid @RequestBody StepDTO stepDTO) throws URISyntaxException {
        log.debug("REST request to save Step : {}", stepDTO);
        if (stepDTO.getId() != null) {
            throw new BadRequestAlertException("A new step cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StepDTO result = stepService.save(stepDTO);
        return ResponseEntity.created(new URI("/api/steps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /steps} : Updates an existing step.
     *
     * @param stepDTO the stepDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stepDTO,
     * or with status {@code 400 (Bad Request)} if the stepDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stepDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/steps")
    public ResponseEntity<StepDTO> updateStep(@Valid @RequestBody StepDTO stepDTO) throws URISyntaxException {
        log.debug("REST request to update Step : {}", stepDTO);
        if (stepDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StepDTO result = stepService.save(stepDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, stepDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /steps} : get all the steps.
     *

     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of steps in body.
     */
    @GetMapping("/steps")
    public List<StepDTO> getAllSteps(@RequestParam(required = false) String filter) {
        if ("stepuseranswer-is-null".equals(filter)) {
            log.debug("REST request to get all Steps where stepUserAnswer is null");
            return stepService.findAllWhereStepUserAnswerIsNull();
        }
        log.debug("REST request to get all Steps");
        return stepService.findAll();
    }

    /**
     * {@code GET  /steps/:id} : get the "id" step.
     *
     * @param id the id of the stepDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stepDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/steps/{id}")
    public ResponseEntity<StepDTO> getStep(@PathVariable Long id) {
        log.debug("REST request to get Step : {}", id);
        Optional<StepDTO> stepDTO = stepService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stepDTO);
    }

    /**
     * {@code DELETE  /steps/:id} : delete the "id" step.
     *
     * @param id the id of the stepDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/steps/{id}")
    public ResponseEntity<Void> deleteStep(@PathVariable Long id) {
        log.debug("REST request to delete Step : {}", id);
        stepService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
