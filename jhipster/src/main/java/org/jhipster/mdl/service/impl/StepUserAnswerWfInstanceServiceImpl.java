package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.StepUserAnswerWfInstanceService;
import org.jhipster.mdl.domain.StepUserAnswerWfInstance;
import org.jhipster.mdl.repository.StepUserAnswerWfInstanceRepository;
import org.jhipster.mdl.service.dto.StepUserAnswerWfInstanceDTO;
import org.jhipster.mdl.service.mapper.StepUserAnswerWfInstanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link StepUserAnswerWfInstance}.
 */
@Service
@Transactional
public class StepUserAnswerWfInstanceServiceImpl implements StepUserAnswerWfInstanceService {

    private final Logger log = LoggerFactory.getLogger(StepUserAnswerWfInstanceServiceImpl.class);

    private final StepUserAnswerWfInstanceRepository stepUserAnswerWfInstanceRepository;

    private final StepUserAnswerWfInstanceMapper stepUserAnswerWfInstanceMapper;

    public StepUserAnswerWfInstanceServiceImpl(StepUserAnswerWfInstanceRepository stepUserAnswerWfInstanceRepository, StepUserAnswerWfInstanceMapper stepUserAnswerWfInstanceMapper) {
        this.stepUserAnswerWfInstanceRepository = stepUserAnswerWfInstanceRepository;
        this.stepUserAnswerWfInstanceMapper = stepUserAnswerWfInstanceMapper;
    }

    /**
     * Save a stepUserAnswerWfInstance.
     *
     * @param stepUserAnswerWfInstanceDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StepUserAnswerWfInstanceDTO save(StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO) {
        log.debug("Request to save StepUserAnswerWfInstance : {}", stepUserAnswerWfInstanceDTO);
        StepUserAnswerWfInstance stepUserAnswerWfInstance = stepUserAnswerWfInstanceMapper.toEntity(stepUserAnswerWfInstanceDTO);
        stepUserAnswerWfInstance = stepUserAnswerWfInstanceRepository.save(stepUserAnswerWfInstance);
        return stepUserAnswerWfInstanceMapper.toDto(stepUserAnswerWfInstance);
    }

    /**
     * Get all the stepUserAnswerWfInstances.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<StepUserAnswerWfInstanceDTO> findAll() {
        log.debug("Request to get all StepUserAnswerWfInstances");
        return stepUserAnswerWfInstanceRepository.findAll().stream()
            .map(stepUserAnswerWfInstanceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one stepUserAnswerWfInstance by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StepUserAnswerWfInstanceDTO> findOne(Long id) {
        log.debug("Request to get StepUserAnswerWfInstance : {}", id);
        return stepUserAnswerWfInstanceRepository.findById(id)
            .map(stepUserAnswerWfInstanceMapper::toDto);
    }

    /**
     * Delete the stepUserAnswerWfInstance by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StepUserAnswerWfInstance : {}", id);
        stepUserAnswerWfInstanceRepository.deleteById(id);
    }
}
