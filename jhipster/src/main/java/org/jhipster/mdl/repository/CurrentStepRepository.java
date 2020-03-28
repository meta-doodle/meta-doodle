package org.jhipster.mdl.repository;

import org.jhipster.mdl.domain.CurrentStep;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CurrentStep entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CurrentStepRepository extends JpaRepository<CurrentStep, Long> {

}
