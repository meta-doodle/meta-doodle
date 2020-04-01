package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.CurrentStepService;
import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.service.dto.CurrentStepDTO;
import org.jhipster.mdl.service.mapper.CurrentStepMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CurrentStep}.
 */
@Service
@Transactional
public class CurrentStepServiceImpl implements CurrentStepService {

    private final Logger log = LoggerFactory.getLogger(CurrentStepServiceImpl.class);

    private final CurrentStepRepository currentStepRepository;

    private final CurrentStepMapper currentStepMapper;

    public CurrentStepServiceImpl(CurrentStepRepository currentStepRepository, CurrentStepMapper currentStepMapper) {
        this.currentStepRepository = currentStepRepository;
        this.currentStepMapper = currentStepMapper;
    }

    /**
     * Save a currentStep.
     *
     * @param currentStepDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CurrentStepDTO save(CurrentStepDTO currentStepDTO) {
        log.debug("Request to save CurrentStep : {}", currentStepDTO);
        CurrentStep currentStep = currentStepMapper.toEntity(currentStepDTO);
        currentStep = currentStepRepository.save(currentStep);
        return currentStepMapper.toDto(currentStep);
    }

    /**
     * Get all the currentSteps.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CurrentStepDTO> findAll() {
        log.debug("Request to get all CurrentSteps");
        return currentStepRepository.findAllWithEagerRelationships().stream()
            .map(currentStepMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all the currentSteps with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<CurrentStepDTO> findAllWithEagerRelationships(Pageable pageable) {
        return currentStepRepository.findAllWithEagerRelationships(pageable).map(currentStepMapper::toDto);
    }
    

    /**
     * Get one currentStep by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CurrentStepDTO> findOne(Long id) {
        log.debug("Request to get CurrentStep : {}", id);
        return currentStepRepository.findOneWithEagerRelationships(id)
            .map(currentStepMapper::toDto);
    }

    /**
     * Delete the currentStep by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CurrentStep : {}", id);
        currentStepRepository.deleteById(id);
    }
}
