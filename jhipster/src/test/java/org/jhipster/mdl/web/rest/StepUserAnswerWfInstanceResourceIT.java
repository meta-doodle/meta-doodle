package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.StepUserAnswerWfInstance;
import org.jhipster.mdl.repository.StepUserAnswerWfInstanceRepository;
import org.jhipster.mdl.service.StepUserAnswerWfInstanceService;
import org.jhipster.mdl.service.dto.StepUserAnswerWfInstanceDTO;
import org.jhipster.mdl.service.mapper.StepUserAnswerWfInstanceMapper;
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
 * Integration tests for the {@link StepUserAnswerWfInstanceResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class StepUserAnswerWfInstanceResourceIT {

    @Autowired
    private StepUserAnswerWfInstanceRepository stepUserAnswerWfInstanceRepository;

    @Autowired
    private StepUserAnswerWfInstanceMapper stepUserAnswerWfInstanceMapper;

    @Autowired
    private StepUserAnswerWfInstanceService stepUserAnswerWfInstanceService;

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

    private MockMvc restStepUserAnswerWfInstanceMockMvc;

    private StepUserAnswerWfInstance stepUserAnswerWfInstance;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StepUserAnswerWfInstanceResource stepUserAnswerWfInstanceResource = new StepUserAnswerWfInstanceResource(stepUserAnswerWfInstanceService);
        this.restStepUserAnswerWfInstanceMockMvc = MockMvcBuilders.standaloneSetup(stepUserAnswerWfInstanceResource)
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
    public static StepUserAnswerWfInstance createEntity(EntityManager em) {
        StepUserAnswerWfInstance stepUserAnswerWfInstance = new StepUserAnswerWfInstance();
        return stepUserAnswerWfInstance;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static StepUserAnswerWfInstance createUpdatedEntity(EntityManager em) {
        StepUserAnswerWfInstance stepUserAnswerWfInstance = new StepUserAnswerWfInstance();
        return stepUserAnswerWfInstance;
    }

    @BeforeEach
    public void initTest() {
        stepUserAnswerWfInstance = createEntity(em);
    }

    @Test
    @Transactional
    public void createStepUserAnswerWfInstance() throws Exception {
        int databaseSizeBeforeCreate = stepUserAnswerWfInstanceRepository.findAll().size();

        // Create the StepUserAnswerWfInstance
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO = stepUserAnswerWfInstanceMapper.toDto(stepUserAnswerWfInstance);
        restStepUserAnswerWfInstanceMockMvc.perform(post("/api/step-user-answer-wf-instances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stepUserAnswerWfInstanceDTO)))
            .andExpect(status().isCreated());

        // Validate the StepUserAnswerWfInstance in the database
        List<StepUserAnswerWfInstance> stepUserAnswerWfInstanceList = stepUserAnswerWfInstanceRepository.findAll();
        assertThat(stepUserAnswerWfInstanceList).hasSize(databaseSizeBeforeCreate + 1);
        StepUserAnswerWfInstance testStepUserAnswerWfInstance = stepUserAnswerWfInstanceList.get(stepUserAnswerWfInstanceList.size() - 1);
    }

    @Test
    @Transactional
    public void createStepUserAnswerWfInstanceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = stepUserAnswerWfInstanceRepository.findAll().size();

        // Create the StepUserAnswerWfInstance with an existing ID
        stepUserAnswerWfInstance.setId(1L);
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO = stepUserAnswerWfInstanceMapper.toDto(stepUserAnswerWfInstance);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStepUserAnswerWfInstanceMockMvc.perform(post("/api/step-user-answer-wf-instances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stepUserAnswerWfInstanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StepUserAnswerWfInstance in the database
        List<StepUserAnswerWfInstance> stepUserAnswerWfInstanceList = stepUserAnswerWfInstanceRepository.findAll();
        assertThat(stepUserAnswerWfInstanceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllStepUserAnswerWfInstances() throws Exception {
        // Initialize the database
        stepUserAnswerWfInstanceRepository.saveAndFlush(stepUserAnswerWfInstance);

        // Get all the stepUserAnswerWfInstanceList
        restStepUserAnswerWfInstanceMockMvc.perform(get("/api/step-user-answer-wf-instances?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(stepUserAnswerWfInstance.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getStepUserAnswerWfInstance() throws Exception {
        // Initialize the database
        stepUserAnswerWfInstanceRepository.saveAndFlush(stepUserAnswerWfInstance);

        // Get the stepUserAnswerWfInstance
        restStepUserAnswerWfInstanceMockMvc.perform(get("/api/step-user-answer-wf-instances/{id}", stepUserAnswerWfInstance.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(stepUserAnswerWfInstance.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingStepUserAnswerWfInstance() throws Exception {
        // Get the stepUserAnswerWfInstance
        restStepUserAnswerWfInstanceMockMvc.perform(get("/api/step-user-answer-wf-instances/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStepUserAnswerWfInstance() throws Exception {
        // Initialize the database
        stepUserAnswerWfInstanceRepository.saveAndFlush(stepUserAnswerWfInstance);

        int databaseSizeBeforeUpdate = stepUserAnswerWfInstanceRepository.findAll().size();

        // Update the stepUserAnswerWfInstance
        StepUserAnswerWfInstance updatedStepUserAnswerWfInstance = stepUserAnswerWfInstanceRepository.findById(stepUserAnswerWfInstance.getId()).get();
        // Disconnect from session so that the updates on updatedStepUserAnswerWfInstance are not directly saved in db
        em.detach(updatedStepUserAnswerWfInstance);
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO = stepUserAnswerWfInstanceMapper.toDto(updatedStepUserAnswerWfInstance);

        restStepUserAnswerWfInstanceMockMvc.perform(put("/api/step-user-answer-wf-instances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stepUserAnswerWfInstanceDTO)))
            .andExpect(status().isOk());

        // Validate the StepUserAnswerWfInstance in the database
        List<StepUserAnswerWfInstance> stepUserAnswerWfInstanceList = stepUserAnswerWfInstanceRepository.findAll();
        assertThat(stepUserAnswerWfInstanceList).hasSize(databaseSizeBeforeUpdate);
        StepUserAnswerWfInstance testStepUserAnswerWfInstance = stepUserAnswerWfInstanceList.get(stepUserAnswerWfInstanceList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingStepUserAnswerWfInstance() throws Exception {
        int databaseSizeBeforeUpdate = stepUserAnswerWfInstanceRepository.findAll().size();

        // Create the StepUserAnswerWfInstance
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO = stepUserAnswerWfInstanceMapper.toDto(stepUserAnswerWfInstance);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStepUserAnswerWfInstanceMockMvc.perform(put("/api/step-user-answer-wf-instances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stepUserAnswerWfInstanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StepUserAnswerWfInstance in the database
        List<StepUserAnswerWfInstance> stepUserAnswerWfInstanceList = stepUserAnswerWfInstanceRepository.findAll();
        assertThat(stepUserAnswerWfInstanceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteStepUserAnswerWfInstance() throws Exception {
        // Initialize the database
        stepUserAnswerWfInstanceRepository.saveAndFlush(stepUserAnswerWfInstance);

        int databaseSizeBeforeDelete = stepUserAnswerWfInstanceRepository.findAll().size();

        // Delete the stepUserAnswerWfInstance
        restStepUserAnswerWfInstanceMockMvc.perform(delete("/api/step-user-answer-wf-instances/{id}", stepUserAnswerWfInstance.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<StepUserAnswerWfInstance> stepUserAnswerWfInstanceList = stepUserAnswerWfInstanceRepository.findAll();
        assertThat(stepUserAnswerWfInstanceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
