package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.RoleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Role} and its DTO {@link RoleDTO}.
 */
@Mapper(componentModel = "spring", uses = {MdlUserMapper.class, WorkflowInstanceMapper.class})
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "workflowInstance.id", target = "workflowInstanceId")
    RoleDTO toDto(Role role);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "workflowInstanceId", target = "workflowInstance")
    Role toEntity(RoleDTO roleDTO);

    default Role fromId(Long id) {
        if (id == null) {
            return null;
        }
        Role role = new Role();
        role.setId(id);
        return role;
    }
}
