package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.repository.WorkflowInstanceRepository;
import org.jhipster.mdl.service.WorkflowInstanceService;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.service.mapper.WorkflowInstanceMapper;
import org.jhipster.mdl.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.jhipster.mdl.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link WorkflowInstanceResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class WorkflowInstanceResourceIT {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private WorkflowInstanceRepository workflowInstanceRepository;

    @Mock
    private WorkflowInstanceRepository workflowInstanceRepositoryMock;

    @Autowired
    private WorkflowInstanceMapper workflowInstanceMapper;

    @Mock
    private WorkflowInstanceService workflowInstanceServiceMock;

    @Autowired
    private WorkflowInstanceService workflowInstanceService;

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

    private MockMvc restWorkflowInstanceMockMvc;

    private WorkflowInstance workflowInstance;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WorkflowInstanceResource workflowInstanceResource = new WorkflowInstanceResource(workflowInstanceService);
        this.restWorkflowInstanceMockMvc = MockMvcBuilders.standaloneSetup(workflowInstanceResource)
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
    public static WorkflowInstance createEntity(EntityManager em) {
        WorkflowInstance workflowInstance = new WorkflowInstance()
            .description(DEFAULT_DESCRIPTION);
        return workflowInstance;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static WorkflowInstance createUpdatedEntity(EntityManager em) {
        WorkflowInstance workflowInstance = new WorkflowInstance()
            .description(UPDATED_DESCRIPTION);
        return workflowInstance;
    }

    @BeforeEach
    public void initTest() {
        workflowInstance = createEntity(em);
    }

    @Test
    @Transactional
    public void createWorkflowInstance() throws Exception {
        int databaseSizeBeforeCreate = workflowInstanceRepository.findAll().size();

        // Create the WorkflowInstance
        WorkflowInstanceDTO workflowInstanceDTO = workflowInstanceMapper.toDto(workflowInstance);
        restWorkflowInstanceMockMvc.perform(post("/api/workflow-instances")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceDTO)))
            .andExpect(status().isCreated());

        // Validate the WorkflowInstance in the database
        List<WorkflowInstance> workflowInstanceList = workflowInstanceRepository.findAll();
        assertThat(workflowInstanceList).hasSize(databaseSizeBeforeCreate + 1);
        WorkflowInstance testWorkflowInstance = workflowInstanceList.get(workflowInstanceList.size() - 1);
        assertThat(testWorkflowInstance.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void createWorkflowInstanceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = workflowInstanceRepository.findAll().size();

        // Create the WorkflowInstance with an existing ID
        workflowInstance.setId(1L);
        WorkflowInstanceDTO workflowInstanceDTO = workflowInstanceMapper.toDto(workflowInstance);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWorkflowInstanceMockMvc.perform(post("/api/workflow-instances")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowInstance in the database
        List<WorkflowInstance> workflowInstanceList = workflowInstanceRepository.findAll();
        assertThat(workflowInstanceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllWorkflowInstances() throws Exception {
        // Initialize the database
        workflowInstanceRepository.saveAndFlush(workflowInstance);

        // Get all the workflowInstanceList
        restWorkflowInstanceMockMvc.perform(get("/api/workflow-instances?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(workflowInstance.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllWorkflowInstancesWithEagerRelationshipsIsEnabled() throws Exception {
        WorkflowInstanceResource workflowInstanceResource = new WorkflowInstanceResource(workflowInstanceServiceMock);
        when(workflowInstanceServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        MockMvc restWorkflowInstanceMockMvc = MockMvcBuilders.standaloneSetup(workflowInstanceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();

        restWorkflowInstanceMockMvc.perform(get("/api/workflow-instances?eagerload=true"))
        .andExpect(status().isOk());

        verify(workflowInstanceServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllWorkflowInstancesWithEagerRelationshipsIsNotEnabled() throws Exception {
        WorkflowInstanceResource workflowInstanceResource = new WorkflowInstanceResource(workflowInstanceServiceMock);
            when(workflowInstanceServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));
            MockMvc restWorkflowInstanceMockMvc = MockMvcBuilders.standaloneSetup(workflowInstanceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();

        restWorkflowInstanceMockMvc.perform(get("/api/workflow-instances?eagerload=true"))
        .andExpect(status().isOk());

            verify(workflowInstanceServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getWorkflowInstance() throws Exception {
        // Initialize the database
        workflowInstanceRepository.saveAndFlush(workflowInstance);

        // Get the workflowInstance
        restWorkflowInstanceMockMvc.perform(get("/api/workflow-instances/{id}", workflowInstance.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(workflowInstance.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION));
    }

    @Test
    @Transactional
    public void getNonExistingWorkflowInstance() throws Exception {
        // Get the workflowInstance
        restWorkflowInstanceMockMvc.perform(get("/api/workflow-instances/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWorkflowInstance() throws Exception {
        // Initialize the database
        workflowInstanceRepository.saveAndFlush(workflowInstance);

        int databaseSizeBeforeUpdate = workflowInstanceRepository.findAll().size();

        // Update the workflowInstance
        WorkflowInstance updatedWorkflowInstance = workflowInstanceRepository.findById(workflowInstance.getId()).get();
        // Disconnect from session so that the updates on updatedWorkflowInstance are not directly saved in db
        em.detach(updatedWorkflowInstance);
        updatedWorkflowInstance
            .description(UPDATED_DESCRIPTION);
        WorkflowInstanceDTO workflowInstanceDTO = workflowInstanceMapper.toDto(updatedWorkflowInstance);

        restWorkflowInstanceMockMvc.perform(put("/api/workflow-instances")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceDTO)))
            .andExpect(status().isOk());

        // Validate the WorkflowInstance in the database
        List<WorkflowInstance> workflowInstanceList = workflowInstanceRepository.findAll();
        assertThat(workflowInstanceList).hasSize(databaseSizeBeforeUpdate);
        WorkflowInstance testWorkflowInstance = workflowInstanceList.get(workflowInstanceList.size() - 1);
        assertThat(testWorkflowInstance.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    public void updateNonExistingWorkflowInstance() throws Exception {
        int databaseSizeBeforeUpdate = workflowInstanceRepository.findAll().size();

        // Create the WorkflowInstance
        WorkflowInstanceDTO workflowInstanceDTO = workflowInstanceMapper.toDto(workflowInstance);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWorkflowInstanceMockMvc.perform(put("/api/workflow-instances")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(workflowInstanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowInstance in the database
        List<WorkflowInstance> workflowInstanceList = workflowInstanceRepository.findAll();
        assertThat(workflowInstanceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWorkflowInstance() throws Exception {
        // Initialize the database
        workflowInstanceRepository.saveAndFlush(workflowInstance);

        int databaseSizeBeforeDelete = workflowInstanceRepository.findAll().size();

        // Delete the workflowInstance
        restWorkflowInstanceMockMvc.perform(delete("/api/workflow-instances/{id}", workflowInstance.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<WorkflowInstance> workflowInstanceList = workflowInstanceRepository.findAll();
        assertThat(workflowInstanceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
