package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.MdlUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MdlUser} and its DTO {@link MdlUserDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MdlUserMapper extends EntityMapper<MdlUserDTO, MdlUser> {

    @Mapping(source = "user.id", target = "userId")
    MdlUserDTO toDto(MdlUser mdlUser);

    @Mapping(source = "userId", target = "user")
    @Mapping(target = "creatorWfInstances", ignore = true)
    @Mapping(target = "removeCreatorWfInstances", ignore = true)
    @Mapping(target = "workflows", ignore = true)
    @Mapping(target = "removeWorkflows", ignore = true)
    @Mapping(target = "steps", ignore = true)
    @Mapping(target = "removeSteps", ignore = true)
    @Mapping(target = "workflowInstances", ignore = true)
    @Mapping(target = "removeWorkflowInstances", ignore = true)
    MdlUser toEntity(MdlUserDTO mdlUserDTO);

    default MdlUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        MdlUser mdlUser = new MdlUser();
        mdlUser.setId(id);
        return mdlUser;
    }
}