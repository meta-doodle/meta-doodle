package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.MdlUserService;
import org.jhipster.mdl.domain.User;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.repository.MdlUserRepository;
import org.jhipster.mdl.repository.UserRepository;
import org.jhipster.mdl.service.dto.MdlUserDTO;
import org.jhipster.mdl.service.dto.UserDTO;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;
import org.jhipster.mdl.service.mapper.MdlUserMapper;
import org.jhipster.mdl.service.mapper.WorkflowInstanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link MdlUser}.
 */
@Service
@Transactional
public class MdlUserServiceImpl implements MdlUserService {

    private final Logger log = LoggerFactory.getLogger(MdlUserServiceImpl.class);

    private final MdlUserRepository mdlUserRepository;

    private final MdlUserMapper mdlUserMapper;

    private final UserRepository userRepository;
    
    private final WorkflowInstanceMapper workflowInstanceMapper;

    public MdlUserServiceImpl(MdlUserRepository mdlUserRepository, MdlUserMapper mdlUserMapper, UserRepository userRepository, WorkflowInstanceMapper workflowInstanceMapper) {
        this.mdlUserRepository = mdlUserRepository;
        this.mdlUserMapper = mdlUserMapper;
        this.userRepository = userRepository;
        this.workflowInstanceMapper = workflowInstanceMapper;
    }

    /**
     * Save a mdlUser.
     *
     * @param mdlUserDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MdlUserDTO save(MdlUserDTO mdlUserDTO) {
        log.debug("Request to save MdlUser : {}", mdlUserDTO);
        MdlUser mdlUser = mdlUserMapper.toEntity(mdlUserDTO);
        long userId = mdlUserDTO.getUserId();
        userRepository.findById(userId).ifPresent(mdlUser::user);
        mdlUser = mdlUserRepository.save(mdlUser);
        return mdlUserMapper.toDto(mdlUser);
    }

    /**
     * Get all the mdlUsers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MdlUserDTO> findAll() {
        log.debug("Request to get all MdlUsers");
        return mdlUserRepository.findAll().stream()
            .map(mdlUserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one mdlUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MdlUserDTO> findOne(Long id) {
        log.debug("Request to get MdlUser : {}", id);
        return mdlUserRepository.findById(id)
            .map(mdlUserMapper::toDto);
    }

    /**
     * Delete the mdlUser by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MdlUser : {}", id);
        mdlUserRepository.deleteById(id);
    }
	
	@Override
	public Optional<MdlUserDTO> convert(String login) {
		List<MdlUser> mdlUsers = mdlUserRepository.findAll();
		for (MdlUser mdlUser : mdlUsers) {
			User user = mdlUser.getUser();
			if(user != null && user.getLogin().equalsIgnoreCase(login)) {
				MdlUserDTO mdlUserDTO = mdlUserMapper.toDto(mdlUser);
				return Optional.of(mdlUserDTO);
			}
		}
		return Optional.empty();
	}

	@Override
	public Set<WorkflowInstanceDTO> getWorkflows(Long id) {
		log.debug("Request workflows of MdlUser with id : {}", id);
		Optional<MdlUser> optMdlUser = mdlUserRepository.findById(id);
		if(optMdlUser.isPresent()) {
			log.debug("MdlUser with id : {} found", id);
			MdlUser user = optMdlUser.get();
			return user.getWorkflowInstances().parallelStream().
					map(workflowInstanceMapper::toDto).
					collect(Collectors.toSet());
		} else {
			log.debug("MdlUser with id : {} not found", id);
			return new HashSet<>();
		}
	}
}
