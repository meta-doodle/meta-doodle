package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.WorkflowModel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the WorkflowModel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkflowModelRepository extends JpaRepository<WorkflowModel, Long> {

}
