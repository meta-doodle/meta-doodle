package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.WorkflowInstanceState;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WorkflowInstanceState entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkflowInstanceStateRepository extends JpaRepository<WorkflowInstanceState, Long> {

}
