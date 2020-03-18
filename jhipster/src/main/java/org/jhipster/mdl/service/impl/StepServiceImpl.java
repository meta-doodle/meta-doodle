package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.StepService;
import org.jhipster.mdl.domain.Step;
import org.jhipster.mdl.repository.StepRepository;
import org.jhipster.mdl.service.dto.StepDTO;
import org.jhipster.mdl.service.mapper.StepMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link Step}.
 */
@Service
@Transactional
public class StepServiceImpl implements StepService {

    private final Logger log = LoggerFactory.getLogger(StepServiceImpl.class);

    private final StepRepository stepRepository;

    private final StepMapper stepMapper;

    public StepServiceImpl(StepRepository stepRepository, StepMapper stepMapper) {
        this.stepRepository = stepRepository;
        this.stepMapper = stepMapper;
    }

    /**
     * Save a step.
     *
     * @param stepDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StepDTO save(StepDTO stepDTO) {
        log.debug("Request to save Step : {}", stepDTO);
        Step step = stepMapper.toEntity(stepDTO);
        step = stepRepository.save(step);
        return stepMapper.toDto(step);
    }

    /**
     * Get all the steps.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<StepDTO> findAll() {
        log.debug("Request to get all Steps");
        return stepRepository.findAll().stream()
            .map(stepMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
    *  Get all the steps where StepUserAnswer is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<StepDTO> findAllWhereStepUserAnswerIsNull() {
        log.debug("Request to get all steps where StepUserAnswer is null");
        return StreamSupport
            .stream(stepRepository.findAll().spliterator(), false)
            .filter(step -> step.getStepUserAnswer() == null)
            .map(stepMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one step by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StepDTO> findOne(Long id) {
        log.debug("Request to get Step : {}", id);
        return stepRepository.findById(id)
            .map(stepMapper::toDto);
    }

    /**
     * Delete the step by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Step : {}", id);
        stepRepository.deleteById(id);
    }
}
