package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.jhipster.mdl.repository.WorkflowInstanceStateRepository;
import org.jhipster.mdl.service.WorkflowInstanceStateService;
import org.jhipster.mdl.service.dto.WorkflowInstanceStateDTO;
import org.jhipster.mdl.service.mapper.WorkflowInstanceStateMapper;
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
 * Integration tests for the {@link WorkflowInstanceStateResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class WorkflowInstanceStateResourceIT {

    @Autowired
    private WorkflowInstanceStateRepository workflowInstanceStateRepository;

    @Autowired
    private WorkflowInstanceStateMapper workflowInstanceStateMapper;

    @Autowired
    private WorkflowInstanceStateService workflowInstanceStateService;

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

    private MockMvc restWorkflowInstanceStateMockMvc;

    private WorkflowInstanceState workflowInstanceState;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WorkflowInstanceStateResource workflowInstanceStateResource = new WorkflowInstanceStateResource(workflowInstanceStateService);
        this.restWorkflowInstanceStateMockMvc = MockMvcBuilders.standaloneSetup(workflowInstanceStateResource)
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
    public static WorkflowInstanceState createEntity(EntityManager em) {
        WorkflowInstanceState workflowInstanceState = new WorkflowInstanceState();
        return workflowInstanceState;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static WorkflowInstanceState createUpdatedEntity(EntityManager em) {
        WorkflowInstanceState workflowInstanceState = new WorkflowInstanceState();
        return workflowInstanceState;
    }

    @BeforeEach
    public void initTest() {
        workflowInstanceState = createEntity(em);
    }

    @Test
    @Transactional
    public void createWorkflowInstanceState() throws Exception {
        int databaseSizeBeforeCreate = workflowInstanceStateRepository.findAll().size();

        // Create the WorkflowInstanceState
        WorkflowInstanceStateDTO workflowInstanceStateDTO = workflowInstanceStateMapper.toDto(workflowInstanceState);
        restWorkflowInstanceStateMockMvc.perform(post("/api/workflow-instance-states")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceStateDTO)))
            .andExpect(status().isCreated());

        // Validate the WorkflowInstanceState in the database
        List<WorkflowInstanceState> workflowInstanceStateList = workflowInstanceStateRepository.findAll();
        assertThat(workflowInstanceStateList).hasSize(databaseSizeBeforeCreate + 1);
        WorkflowInstanceState testWorkflowInstanceState = workflowInstanceStateList.get(workflowInstanceStateList.size() - 1);
    }

    @Test
    @Transactional
    public void createWorkflowInstanceStateWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = workflowInstanceStateRepository.findAll().size();

        // Create the WorkflowInstanceState with an existing ID
        workflowInstanceState.setId(1L);
        WorkflowInstanceStateDTO workflowInstanceStateDTO = workflowInstanceStateMapper.toDto(workflowInstanceState);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWorkflowInstanceStateMockMvc.perform(post("/api/workflow-instance-states")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceStateDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowInstanceState in the database
        List<WorkflowInstanceState> workflowInstanceStateList = workflowInstanceStateRepository.findAll();
        assertThat(workflowInstanceStateList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllWorkflowInstanceStates() throws Exception {
        // Initialize the database
        workflowInstanceStateRepository.saveAndFlush(workflowInstanceState);

        // Get all the workflowInstanceStateList
        restWorkflowInstanceStateMockMvc.perform(get("/api/workflow-instance-states?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(workflowInstanceState.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getWorkflowInstanceState() throws Exception {
        // Initialize the database
        workflowInstanceStateRepository.saveAndFlush(workflowInstanceState);

        // Get the workflowInstanceState
        restWorkflowInstanceStateMockMvc.perform(get("/api/workflow-instance-states/{id}", workflowInstanceState.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(workflowInstanceState.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingWorkflowInstanceState() throws Exception {
        // Get the workflowInstanceState
        restWorkflowInstanceStateMockMvc.perform(get("/api/workflow-instance-states/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWorkflowInstanceState() throws Exception {
        // Initialize the database
        workflowInstanceStateRepository.saveAndFlush(workflowInstanceState);

        int databaseSizeBeforeUpdate = workflowInstanceStateRepository.findAll().size();

        // Update the workflowInstanceState
        WorkflowInstanceState updatedWorkflowInstanceState = workflowInstanceStateRepository.findById(workflowInstanceState.getId()).get();
        // Disconnect from session so that the updates on updatedWorkflowInstanceState are not directly saved in db
        em.detach(updatedWorkflowInstanceState);
        WorkflowInstanceStateDTO workflowInstanceStateDTO = workflowInstanceStateMapper.toDto(updatedWorkflowInstanceState);

        restWorkflowInstanceStateMockMvc.perform(put("/api/workflow-instance-states")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceStateDTO)))
            .andExpect(status().isOk());

        // Validate the WorkflowInstanceState in the database
        List<WorkflowInstanceState> workflowInstanceStateList = workflowInstanceStateRepository.findAll();
        assertThat(workflowInstanceStateList).hasSize(databaseSizeBeforeUpdate);
        WorkflowInstanceState testWorkflowInstanceState = workflowInstanceStateList.get(workflowInstanceStateList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingWorkflowInstanceState() throws Exception {
        int databaseSizeBeforeUpdate = workflowInstanceStateRepository.findAll().size();

        // Create the WorkflowInstanceState
        WorkflowInstanceStateDTO workflowInstanceStateDTO = workflowInstanceStateMapper.toDto(workflowInstanceState);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWorkflowInstanceStateMockMvc.perform(put("/api/workflow-instance-states")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceStateDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowInstanceState in the database
        List<WorkflowInstanceState> workflowInstanceStateList = workflowInstanceStateRepository.findAll();
        assertThat(workflowInstanceStateList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWorkflowInstanceState() throws Exception {
        // Initialize the database
        workflowInstanceStateRepository.saveAndFlush(workflowInstanceState);

        int databaseSizeBeforeDelete = workflowInstanceStateRepository.findAll().size();

        // Delete the workflowInstanceState
        restWorkflowInstanceStateMockMvc.perform(delete("/api/workflow-instance-states/{id}", workflowInstanceState.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<WorkflowInstanceState> workflowInstanceStateList = workflowInstanceStateRepository.findAll();
        assertThat(workflowInstanceStateList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
