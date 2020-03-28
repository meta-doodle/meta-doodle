package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.CurrentStepService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.CurrentStepDTO;

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
 * REST controller for managing {@link org.jhipster.mdl.domain.CurrentStep}.
 */
@RestController
@RequestMapping("/api")
public class CurrentStepResource {

    private final Logger log = LoggerFactory.getLogger(CurrentStepResource.class);

    private static final String ENTITY_NAME = "currentStep";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CurrentStepService currentStepService;

    public CurrentStepResource(CurrentStepService currentStepService) {
        this.currentStepService = currentStepService;
    }

    /**
     * {@code POST  /current-steps} : Create a new currentStep.
     *
     * @param currentStepDTO the currentStepDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new currentStepDTO, or with status {@code 400 (Bad Request)} if the currentStep has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/current-steps")
    public ResponseEntity<CurrentStepDTO> createCurrentStep(@RequestBody CurrentStepDTO currentStepDTO) throws URISyntaxException {
        log.debug("REST request to save CurrentStep : {}", currentStepDTO);
        if (currentStepDTO.getId() != null) {
            throw new BadRequestAlertException("A new currentStep cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CurrentStepDTO result = currentStepService.save(currentStepDTO);
        return ResponseEntity.created(new URI("/api/current-steps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /current-steps} : Updates an existing currentStep.
     *
     * @param currentStepDTO the currentStepDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated currentStepDTO,
     * or with status {@code 400 (Bad Request)} if the currentStepDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the currentStepDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/current-steps")
    public ResponseEntity<CurrentStepDTO> updateCurrentStep(@RequestBody CurrentStepDTO currentStepDTO) throws URISyntaxException {
        log.debug("REST request to update CurrentStep : {}", currentStepDTO);
        if (currentStepDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CurrentStepDTO result = currentStepService.save(currentStepDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, currentStepDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /current-steps} : get all the currentSteps.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of currentSteps in body.
     */
    @GetMapping("/current-steps")
    public List<CurrentStepDTO> getAllCurrentSteps() {
        log.debug("REST request to get all CurrentSteps");
        return currentStepService.findAll();
    }

    /**
     * {@code GET  /current-steps/:id} : get the "id" currentStep.
     *
     * @param id the id of the currentStepDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the currentStepDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/current-steps/{id}")
    public ResponseEntity<CurrentStepDTO> getCurrentStep(@PathVariable Long id) {
        log.debug("REST request to get CurrentStep : {}", id);
        Optional<CurrentStepDTO> currentStepDTO = currentStepService.findOne(id);
        return ResponseUtil.wrapOrNotFound(currentStepDTO);
    }

    /**
     * {@code DELETE  /current-steps/:id} : delete the "id" currentStep.
     *
     * @param id the id of the currentStepDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/current-steps/{id}")
    public ResponseEntity<Void> deleteCurrentStep(@PathVariable Long id) {
        log.debug("REST request to delete CurrentStep : {}", id);
        currentStepService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
