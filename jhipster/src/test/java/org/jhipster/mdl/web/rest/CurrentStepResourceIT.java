package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.service.CurrentStepService;
import org.jhipster.mdl.service.dto.CurrentStepDTO;
import org.jhipster.mdl.service.mapper.CurrentStepMapper;
import org.jhipster.mdl.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static org.jhipster.mdl.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CurrentStepResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class CurrentStepResourceIT {

    private static final Integer DEFAULT_STEP_IDENT = 1;
    private static final Integer UPDATED_STEP_IDENT = 2;

    private static final Integer DEFAULT_NUMBER_OF_ANSWER = 1;
    private static final Integer UPDATED_NUMBER_OF_ANSWER = 2;

    @Autowired
    private CurrentStepRepository currentStepRepository;

    @Autowired
    private CurrentStepMapper currentStepMapper;

    @Autowired
    private CurrentStepService currentStepService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restCurrentStepMockMvc;

    private CurrentStep currentStep;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CurrentStepResource currentStepResource = new CurrentStepResource(currentStepService);
        this.restCurrentStepMockMvc = MockMvcBuilders.standaloneSetup(currentStepResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CurrentStep createEntity(EntityManager em) {
        CurrentStep currentStep = new CurrentStep()
            .stepIdent(DEFAULT_STEP_IDENT)
            .numberOfAnswer(DEFAULT_NUMBER_OF_ANSWER);
        return currentStep;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CurrentStep createUpdatedEntity(EntityManager em) {
        CurrentStep currentStep = new CurrentStep()
            .stepIdent(UPDATED_STEP_IDENT)
            .numberOfAnswer(UPDATED_NUMBER_OF_ANSWER);
        return currentStep;
    }

    @BeforeEach
    public void initTest() {
        currentStep = createEntity(em);
    }

    @Test
    @Transactional
    public void createCurrentStep() throws Exception {
        int databaseSizeBeforeCreate = currentStepRepository.findAll().size();

        // Create the CurrentStep
        CurrentStepDTO currentStepDTO = currentStepMapper.toDto(currentStep);
        restCurrentStepMockMvc.perform(post("/api/current-steps")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(currentStepDTO)))
            .andExpect(status().isCreated());

        // Validate the CurrentStep in the database
        List<CurrentStep> currentStepList = currentStepRepository.findAll();
        assertThat(currentStepList).hasSize(databaseSizeBeforeCreate + 1);
        CurrentStep testCurrentStep = currentStepList.get(currentStepList.size() - 1);
        assertThat(testCurrentStep.getStepIdent()).isEqualTo(DEFAULT_STEP_IDENT);
        assertThat(testCurrentStep.getNumberOfAnswer()).isEqualTo(DEFAULT_NUMBER_OF_ANSWER);
    }

    @Test
    @Transactional
    public void createCurrentStepWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = currentStepRepository.findAll().size();

        // Create the CurrentStep with an existing ID
        currentStep.setId(1L);
        CurrentStepDTO currentStepDTO = currentStepMapper.toDto(currentStep);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCurrentStepMockMvc.perform(post("/api/current-steps")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(currentStepDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CurrentStep in the database
        List<CurrentStep> currentStepList = currentStepRepository.findAll();
        assertThat(currentStepList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCurrentSteps() throws Exception {
        // Initialize the database
        currentStepRepository.saveAndFlush(currentStep);

        // Get all the currentStepList
        restCurrentStepMockMvc.perform(get("/api/current-steps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(currentStep.getId().intValue())))
            .andExpect(jsonPath("$.[*].stepIdent").value(hasItem(DEFAULT_STEP_IDENT)))
            .andExpect(jsonPath("$.[*].numberOfAnswer").value(hasItem(DEFAULT_NUMBER_OF_ANSWER)));
    }
    
    @Test
    @Transactional
    public void getCurrentStep() throws Exception {
        // Initialize the database
        currentStepRepository.saveAndFlush(currentStep);

        // Get the currentStep
        restCurrentStepMockMvc.perform(get("/api/current-steps/{id}", currentStep.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(currentStep.getId().intValue()))
            .andExpect(jsonPath("$.stepIdent").value(DEFAULT_STEP_IDENT))
            .andExpect(jsonPath("$.numberOfAnswer").value(DEFAULT_NUMBER_OF_ANSWER));
    }

    @Test
    @Transactional
    public void getNonExistingCurrentStep() throws Exception {
        // Get the currentStep
        restCurrentStepMockMvc.perform(get("/api/current-steps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCurrentStep() throws Exception {
        // Initialize the database
        currentStepRepository.saveAndFlush(currentStep);

        int databaseSizeBeforeUpdate = currentStepRepository.findAll().size();

        // Update the currentStep
        CurrentStep updatedCurrentStep = currentStepRepository.findById(currentStep.getId()).get();
        // Disconnect from session so that the updates on updatedCurrentStep are not directly saved in db
        em.detach(updatedCurrentStep);
        updatedCurrentStep
            .stepIdent(UPDATED_STEP_IDENT)
            .numberOfAnswer(UPDATED_NUMBER_OF_ANSWER);
        CurrentStepDTO currentStepDTO = currentStepMapper.toDto(updatedCurrentStep);

        restCurrentStepMockMvc.perform(put("/api/current-steps")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(currentStepDTO)))
            .andExpect(status().isOk());

        // Validate the CurrentStep in the database
        List<CurrentStep> currentStepList = currentStepRepository.findAll();
        assertThat(currentStepList).hasSize(databaseSizeBeforeUpdate);
        CurrentStep testCurrentStep = currentStepList.get(currentStepList.size() - 1);
        assertThat(testCurrentStep.getStepIdent()).isEqualTo(UPDATED_STEP_IDENT);
        assertThat(testCurrentStep.getNumberOfAnswer()).isEqualTo(UPDATED_NUMBER_OF_ANSWER);
    }

    @Test
    @Transactional
    public void updateNonExistingCurrentStep() throws Exception {
        int databaseSizeBeforeUpdate = currentStepRepository.findAll().size();

        // Create the CurrentStep
        CurrentStepDTO currentStepDTO = currentStepMapper.toDto(currentStep);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCurrentStepMockMvc.perform(put("/api/current-steps")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(currentStepDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CurrentStep in the database
        List<CurrentStep> currentStepList = currentStepRepository.findAll();
        assertThat(currentStepList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCurrentStep() throws Exception {
        // Initialize the database
        currentStepRepository.saveAndFlush(currentStep);

        int databaseSizeBeforeDelete = currentStepRepository.findAll().size();

        // Delete the currentStep
        restCurrentStepMockMvc.perform(delete("/api/current-steps/{id}", currentStep.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CurrentStep> currentStepList = currentStepRepository.findAll();
        assertThat(currentStepList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
