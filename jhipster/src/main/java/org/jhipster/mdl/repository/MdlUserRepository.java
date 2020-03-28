package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.MdlUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdlUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdlUserRepository extends JpaRepository<MdlUser, Long> {

}
