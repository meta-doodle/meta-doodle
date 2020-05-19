package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.Role}.
 */
public interface RoleService {

    /**
     * Save a role.
     *
     * @param roleDTO the entity to save.
     * @return the persisted entity.
     */
    RoleDTO save(RoleDTO roleDTO);

    /**
     * Get all the roles.
     *
     * @return the list of entities.
     */
    List<RoleDTO> findAll();


    /**
     * Get the "id" role.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RoleDTO> findOne(Long id);

    /**
     * Delete the "id" role.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Get the role of the "userId" user in the "wfId" workflow.
     * 
     * @param userId the id of the user.
     * @param wfId the id of the workflow.
     * @return the entity of the role.
     */
    Optional<RoleDTO> getUsersRoleInWorkflow(Long userId, Long wfId);
}
