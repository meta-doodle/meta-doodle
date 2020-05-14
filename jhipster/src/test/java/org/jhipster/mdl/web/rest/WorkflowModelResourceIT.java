package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.WorkflowModel;
import org.jhipster.mdl.repository.WorkflowModelRepository;
import org.jhipster.mdl.service.WorkflowModelService;
import org.jhipster.mdl.service.dto.WorkflowModelDTO;
import org.jhipster.mdl.service.mapper.WorkflowModelMapper;
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
import org.springframework.util.Base64Utils;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static org.jhipster.mdl.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link WorkflowModelResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class WorkflowModelResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_BODY = "AAAAAAAAAA";
    private static final String UPDATED_BODY = "BBBBBBBBBB";

    @Autowired
    private WorkflowModelRepository workflowModelRepository;

    @Autowired
    private WorkflowModelMapper workflowModelMapper;

    @Autowired
    private WorkflowModelService workflowModelService;

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

    private MockMvc restWorkflowModelMockMvc;

    private WorkflowModel workflowModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WorkflowModelResource workflowModelResource = new WorkflowModelResource(workflowModelService);
        this.restWorkflowModelMockMvc = MockMvcBuilders.standaloneSetup(workflowModelResource)
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
    public static WorkflowModel createEntity(EntityManager em) {
        WorkflowModel workflowModel = new WorkflowModel()
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION)
            .body(DEFAULT_BODY);
        return workflowModel;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static WorkflowModel createUpdatedEntity(EntityManager em) {
        WorkflowModel workflowModel = new WorkflowModel()
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .body(UPDATED_BODY);
        return workflowModel;
    }

    @BeforeEach
    public void initTest() {
        workflowModel = createEntity(em);
    }

    @Test
    @Transactional
    public void createWorkflowModel() throws Exception {
        int databaseSizeBeforeCreate = workflowModelRepository.findAll().size();

        // Create the WorkflowModel
        WorkflowModelDTO workflowModelDTO = workflowModelMapper.toDto(workflowModel);
        restWorkflowModelMockMvc.perform(post("/api/workflow-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workflowModelDTO)))
            .andExpect(status().isCreated());

        // Validate the WorkflowModel in the database
        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeCreate + 1);
        WorkflowModel testWorkflowModel = workflowModelList.get(workflowModelList.size() - 1);
        assertThat(testWorkflowModel.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testWorkflowModel.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testWorkflowModel.getBody()).isEqualTo(DEFAULT_BODY);
    }

    @Test
    @Transactional
    public void createWorkflowModelWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = workflowModelRepository.findAll().size();

        // Create the WorkflowModel with an existing ID
        workflowModel.setId(1L);
        WorkflowModelDTO workflowModelDTO = workflowModelMapper.toDto(workflowModel);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWorkflowModelMockMvc.perform(post("/api/workflow-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workflowModelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowModel in the database
        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = workflowModelRepository.findAll().size();
        // set the field null
        workflowModel.setTitle(null);

        // Create the WorkflowModel, which fails.
        WorkflowModelDTO workflowModelDTO = workflowModelMapper.toDto(workflowModel);

        restWorkflowModelMockMvc.perform(post("/api/workflow-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workflowModelDTO)))
            .andExpect(status().isBadRequest());

        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllWorkflowModels() throws Exception {
        // Initialize the database
        workflowModelRepository.saveAndFlush(workflowModel);

        // Get all the workflowModelList
        restWorkflowModelMockMvc.perform(get("/api/workflow-models?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(workflowModel.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].body").value(hasItem(DEFAULT_BODY.toString())));
    }
    
    @Test
    @Transactional
    public void getWorkflowModel() throws Exception {
        // Initialize the database
        workflowModelRepository.saveAndFlush(workflowModel);

        // Get the workflowModel
        restWorkflowModelMockMvc.perform(get("/api/workflow-models/{id}", workflowModel.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(workflowModel.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.body").value(DEFAULT_BODY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingWorkflowModel() throws Exception {
        // Get the workflowModel
        restWorkflowModelMockMvc.perform(get("/api/workflow-models/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWorkflowModel() throws Exception {
        // Initialize the database
        workflowModelRepository.saveAndFlush(workflowModel);

        int databaseSizeBeforeUpdate = workflowModelRepository.findAll().size();

        // Update the workflowModel
        WorkflowModel updatedWorkflowModel = workflowModelRepository.findById(workflowModel.getId()).get();
        // Disconnect from session so that the updates on updatedWorkflowModel are not directly saved in db
        em.detach(updatedWorkflowModel);
        updatedWorkflowModel
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .body(UPDATED_BODY);
        WorkflowModelDTO workflowModelDTO = workflowModelMapper.toDto(updatedWorkflowModel);

        restWorkflowModelMockMvc.perform(put("/api/workflow-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workflowModelDTO)))
            .andExpect(status().isOk());

        // Validate the WorkflowModel in the database
        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeUpdate);
        WorkflowModel testWorkflowModel = workflowModelList.get(workflowModelList.size() - 1);
        assertThat(testWorkflowModel.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testWorkflowModel.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testWorkflowModel.getBody()).isEqualTo(UPDATED_BODY);
    }

    @Test
    @Transactional
    public void updateNonExistingWorkflowModel() throws Exception {
        int databaseSizeBeforeUpdate = workflowModelRepository.findAll().size();

        // Create the WorkflowModel
        WorkflowModelDTO workflowModelDTO = workflowModelMapper.toDto(workflowModel);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWorkflowModelMockMvc.perform(put("/api/workflow-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(workflowModelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the WorkflowModel in the database
        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWorkflowModel() throws Exception {
        // Initialize the database
        workflowModelRepository.saveAndFlush(workflowModel);

        int databaseSizeBeforeDelete = workflowModelRepository.findAll().size();

        // Delete the workflowModel
        restWorkflowModelMockMvc.perform(delete("/api/workflow-models/{id}", workflowModel.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<WorkflowModel> workflowModelList = workflowModelRepository.findAll();
        assertThat(workflowModelList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
