package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.service.MdlUserService;
import org.jhipster.mdl.service.UserService;
import org.jhipster.mdl.web.rest.errors.BadRequestAlertException;
import org.jhipster.mdl.service.dto.MdlUserDTO;
import org.jhipster.mdl.service.dto.UserDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;

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
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * REST controller for managing {@link org.jhipster.mdl.domain.MdlUser}.
 */
@RestController
@RequestMapping("/api")
public class MdlUserResource {

    private final Logger log = LoggerFactory.getLogger(MdlUserResource.class);

    private static final String ENTITY_NAME = "mdlUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdlUserService mdlUserService;

    public MdlUserResource(MdlUserService mdlUserService) {
        this.mdlUserService = mdlUserService;
    }

    /**
     * {@code POST  /mdl-users} : Create a new mdlUser.
     *
     * @param mdlUserDTO the mdlUserDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdlUserDTO, or with status {@code 400 (Bad Request)} if the mdlUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdl-users")
    public ResponseEntity<MdlUserDTO> createMdlUser(@RequestBody MdlUserDTO mdlUserDTO) throws URISyntaxException {
        log.debug("REST request to save MdlUser : {}", mdlUserDTO);
        if (mdlUserDTO.getId() != null) {
            throw new BadRequestAlertException("A new mdlUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if (Objects.isNull(mdlUserDTO.getUserId())) {
            throw new BadRequestAlertException("Invalid association value provided", ENTITY_NAME, "null");
        }
        MdlUserDTO result = mdlUserService.save(mdlUserDTO);
        return ResponseEntity.created(new URI("/api/mdl-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdl-users} : Updates an existing mdlUser.
     *
     * @param mdlUserDTO the mdlUserDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdlUserDTO,
     * or with status {@code 400 (Bad Request)} if the mdlUserDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdlUserDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdl-users")
    public ResponseEntity<MdlUserDTO> updateMdlUser(@RequestBody MdlUserDTO mdlUserDTO) throws URISyntaxException {
        log.debug("REST request to update MdlUser : {}", mdlUserDTO);
        if (mdlUserDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdlUserDTO result = mdlUserService.save(mdlUserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mdlUserDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdl-users} : get all the mdlUsers.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdlUsers in body.
     */
    @GetMapping("/mdl-users")
    public List<MdlUserDTO> getAllMdlUsers() {
        log.debug("REST request to get all MdlUsers");
        return mdlUserService.findAll();
    }

    /**
     * {@code GET  /mdl-users/:id} : get the "id" mdlUser.
     *
     * @param id the id of the mdlUserDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdlUserDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdl-users/{id}")
    public ResponseEntity<MdlUserDTO> getMdlUser(@PathVariable Long id) {
        log.debug("REST request to get MdlUser : {}", id);
        Optional<MdlUserDTO> mdlUserDTO = mdlUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mdlUserDTO);
    }

    /**
     * {@code DELETE  /mdl-users/:id} : delete the "id" mdlUser.
     *
     * @param id the id of the mdlUserDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdl-users/{id}")
    public ResponseEntity<Void> deleteMdlUser(@PathVariable Long id) {
        log.debug("REST request to delete MdlUser : {}", id);
        mdlUserService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
	
	@GetMapping("/mdl-users/convert/{login}")
    public ResponseEntity<MdlUserDTO> convertJUserToMdlUser(@PathVariable String login) {
        log.debug("REST request to convert JUser to MdlUser : {}", login);
        Optional<MdlUserDTO> mdlUserDTO = mdlUserService.convert(login);
        return ResponseUtil.wrapOrNotFound(mdlUserDTO);
    }
	
	/**
     * {@code GET  /mdl-users/:id/workflows} : get active workflows for a mdlUser "id".
     *
     * @param id the id of the mdlUserDTO.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the set of WorkflowInstanceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdl-users/{id}/workflows")
    public ResponseEntity<Set<WorkflowInstanceDTO>> getMdlUserWorkflows(@PathVariable Long id) {
        log.debug("REST request to get MdlUser's workflows : {}", id);
        return ResponseEntity.ok(mdlUserService.getWorkflows(id));
    }

    /**
     * Get the JUser of a given MdlUser
     * @param id
     * @return
     */
	@GetMapping("/mdl-users/{id}/get-user")
    public ResponseEntity<UserDTO> getJUser(@PathVariable long id) {
        log.debug("REST request to get JUser from MdlUser : {}", id);
        return ResponseUtil.wrapOrNotFound(mdlUserService.getUser(id));
    }
}
