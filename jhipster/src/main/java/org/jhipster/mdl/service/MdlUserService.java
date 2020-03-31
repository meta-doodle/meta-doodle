package org.jhipster.mdl.service;

import org.jhipster.mdl.service.dto.MdlUserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link org.jhipster.mdl.domain.MdlUser}.
 */
public interface MdlUserService {

    /**
     * Save a mdlUser.
     *
     * @param mdlUserDTO the entity to save.
     * @return the persisted entity.
     */
    MdlUserDTO save(MdlUserDTO mdlUserDTO);

    /**
     * Get all the mdlUsers.
     *
     * @return the list of entities.
     */
    List<MdlUserDTO> findAll();

    /**
     * Get the "id" mdlUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MdlUserDTO> findOne(Long id);

    /**
     * Delete the "id" mdlUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    Optional<MdlUserDTO> convert(String login);
}
