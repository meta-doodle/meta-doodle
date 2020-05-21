package org.jhipster.mdl.repository;

import java.util.List;
import java.util.Optional;

import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.Role;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Role entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findDistinctRoleByWorkflowInstanceIdAndUserId(Long wfId, Long userId);
	
	List<Role> findRoleByWorkflowInstanceIdAndRole(Long wfId, String role);

}
