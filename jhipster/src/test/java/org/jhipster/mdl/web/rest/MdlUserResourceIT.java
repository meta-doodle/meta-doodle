package org.jhipster.mdl.web.rest;

import org.jhipster.mdl.MdlApp;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.User;
import org.jhipster.mdl.repository.MdlUserRepository;
import org.jhipster.mdl.service.MdlUserService;
import org.jhipster.mdl.service.dto.MdlUserDTO;
import org.jhipster.mdl.service.mapper.MdlUserMapper;
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
 * Integration tests for the {@link MdlUserResource} REST controller.
 */
@SpringBootTest(classes = MdlApp.class)
public class MdlUserResourceIT {

    @Autowired
    private MdlUserRepository mdlUserRepository;

    @Autowired
    private MdlUserMapper mdlUserMapper;

    @Autowired
    private MdlUserService mdlUserService;

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

    private MockMvc restMdlUserMockMvc;

    private MdlUser mdlUser;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MdlUserResource mdlUserResource = new MdlUserResource(mdlUserService);
        this.restMdlUserMockMvc = MockMvcBuilders.standaloneSetup(mdlUserResource)
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
    public static MdlUser createEntity(EntityManager em) {
        MdlUser mdlUser = new MdlUser();
        // Add required entity
        User user = UserResourceIT.createEntity(em);
        em.persist(user);
        em.flush();
        mdlUser.setUser(user);
        return mdlUser;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MdlUser createUpdatedEntity(EntityManager em) {
        MdlUser mdlUser = new MdlUser();
        // Add required entity
        User user = UserResourceIT.createEntity(em);
        em.persist(user);
        em.flush();
        mdlUser.setUser(user);
        return mdlUser;
    }

    @BeforeEach
    public void initTest() {
        mdlUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createMdlUser() throws Exception {
        int databaseSizeBeforeCreate = mdlUserRepository.findAll().size();

        // Create the MdlUser
        MdlUserDTO mdlUserDTO = mdlUserMapper.toDto(mdlUser);
        restMdlUserMockMvc.perform(post("/api/mdl-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mdlUserDTO)))
            .andExpect(status().isCreated());

        // Validate the MdlUser in the database
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeCreate + 1);
        MdlUser testMdlUser = mdlUserList.get(mdlUserList.size() - 1);

        // Validate the id for MapsId, the ids must be same
        assertThat(testMdlUser.getId()).isEqualTo(testMdlUser.getUser().getId());
    }

    @Test
    @Transactional
    public void createMdlUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mdlUserRepository.findAll().size();

        // Create the MdlUser with an existing ID
        mdlUser.setId(1L);
        MdlUserDTO mdlUserDTO = mdlUserMapper.toDto(mdlUser);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMdlUserMockMvc.perform(post("/api/mdl-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mdlUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MdlUser in the database
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void updateMdlUserMapsIdAssociationWithNewId() throws Exception {
        // Initialize the database
        mdlUserRepository.saveAndFlush(mdlUser);
        int databaseSizeBeforeCreate = mdlUserRepository.findAll().size();

        // Add a new parent entity
        User user = UserResourceIT.createEntity(em);
        em.persist(user);
        em.flush();

        // Load the mdlUser
        MdlUser updatedMdlUser = mdlUserRepository.findById(mdlUser.getId()).get();
        // Disconnect from session so that the updates on updatedMdlUser are not directly saved in db
        em.detach(updatedMdlUser);

        // Update the User with new association value
        updatedMdlUser.setUser(user);
        MdlUserDTO updatedMdlUserDTO = mdlUserMapper.toDto(updatedMdlUser);

        // Update the entity
        restMdlUserMockMvc.perform(put("/api/mdl-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedMdlUserDTO)))
            .andExpect(status().isOk());

        // Validate the MdlUser in the database
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeCreate);
        MdlUser testMdlUser = mdlUserList.get(mdlUserList.size() - 1);

        // Validate the id for MapsId, the ids must be same
        // Uncomment the following line for assertion. However, please note that there is a known issue and uncommenting will fail the test.
        // Please look at https://github.com/jhipster/generator-jhipster/issues/9100. You can modify this test as necessary.
        // assertThat(testMdlUser.getId()).isEqualTo(testMdlUser.getUser().getId());
    }

    @Test
    @Transactional
    public void getAllMdlUsers() throws Exception {
        // Initialize the database
        mdlUserRepository.saveAndFlush(mdlUser);

        // Get all the mdlUserList
        restMdlUserMockMvc.perform(get("/api/mdl-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mdlUser.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getMdlUser() throws Exception {
        // Initialize the database
        mdlUserRepository.saveAndFlush(mdlUser);

        // Get the mdlUser
        restMdlUserMockMvc.perform(get("/api/mdl-users/{id}", mdlUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(mdlUser.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingMdlUser() throws Exception {
        // Get the mdlUser
        restMdlUserMockMvc.perform(get("/api/mdl-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMdlUser() throws Exception {
        // Initialize the database
        mdlUserRepository.saveAndFlush(mdlUser);

        int databaseSizeBeforeUpdate = mdlUserRepository.findAll().size();

        // Update the mdlUser
        MdlUser updatedMdlUser = mdlUserRepository.findById(mdlUser.getId()).get();
        // Disconnect from session so that the updates on updatedMdlUser are not directly saved in db
        em.detach(updatedMdlUser);
        MdlUserDTO mdlUserDTO = mdlUserMapper.toDto(updatedMdlUser);

        restMdlUserMockMvc.perform(put("/api/mdl-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mdlUserDTO)))
            .andExpect(status().isOk());

        // Validate the MdlUser in the database
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeUpdate);
        MdlUser testMdlUser = mdlUserList.get(mdlUserList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingMdlUser() throws Exception {
        int databaseSizeBeforeUpdate = mdlUserRepository.findAll().size();

        // Create the MdlUser
        MdlUserDTO mdlUserDTO = mdlUserMapper.toDto(mdlUser);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMdlUserMockMvc.perform(put("/api/mdl-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mdlUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MdlUser in the database
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMdlUser() throws Exception {
        // Initialize the database
        mdlUserRepository.saveAndFlush(mdlUser);

        int databaseSizeBeforeDelete = mdlUserRepository.findAll().size();

        // Delete the mdlUser
        restMdlUserMockMvc.perform(delete("/api/mdl-users/{id}", mdlUser.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MdlUser> mdlUserList = mdlUserRepository.findAll();
        assertThat(mdlUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
