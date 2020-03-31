package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.CurrentStep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the CurrentStep entity.
 */
@Repository
public interface CurrentStepRepository extends JpaRepository<CurrentStep, Long> {

    @Query(value = "select distinct currentStep from CurrentStep currentStep left join fetch currentStep.users",
        countQuery = "select count(distinct currentStep) from CurrentStep currentStep")
    Page<CurrentStep> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct currentStep from CurrentStep currentStep left join fetch currentStep.users")
    List<CurrentStep> findAllWithEagerRelationships();

    @Query("select currentStep from CurrentStep currentStep left join fetch currentStep.users where currentStep.id =:id")
    Optional<CurrentStep> findOneWithEagerRelationships(@Param("id") Long id);

}
