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
    @Mapping(target = "createdWfModels", ignore = true)
    @Mapping(target = "removeCreatedWfModel", ignore = true)
    @Mapping(target = "stepUserAnswers", ignore = true)
    @Mapping(target = "removeStepUserAnswers", ignore = true)
    @Mapping(target = "createdWfInstances", ignore = true)
    @Mapping(target = "removeCreatedWfInstance", ignore = true)
    @Mapping(target = "memberWfInstances", ignore = true)
    @Mapping(target = "removeMemberWfInstance", ignore = true)
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
