package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.Role;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Role entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT DISTINCT role FROM Role r WHERE r.user = userId and r.workflowInstance = wfId")
	Optional<Role> findUsersRoleInWorkflow(@Param("userId") Long userId, @Param("wfId") Long wfId);

}
