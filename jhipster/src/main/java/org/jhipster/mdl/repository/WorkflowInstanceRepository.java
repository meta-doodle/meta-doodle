package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.WorkflowInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the WorkflowInstance entity.
 */
@Repository
public interface WorkflowInstanceRepository extends JpaRepository<WorkflowInstance, Long> {

    @Query(value = "select distinct workflowInstance from WorkflowInstance workflowInstance left join fetch workflowInstance.guests",
        countQuery = "select count(distinct workflowInstance) from WorkflowInstance workflowInstance")
    Page<WorkflowInstance> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct workflowInstance from WorkflowInstance workflowInstance left join fetch workflowInstance.guests")
    List<WorkflowInstance> findAllWithEagerRelationships();

    @Query("select workflowInstance from WorkflowInstance workflowInstance left join fetch workflowInstance.guests where workflowInstance.id =:id")
    Optional<WorkflowInstance> findOneWithEagerRelationships(@Param("id") Long id);

}
