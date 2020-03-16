package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.WorkflowModelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkflowModel} and its DTO {@link WorkflowModelDTO}.
 */
@Mapper(componentModel = "spring", uses = {MdlUserMapper.class})
public interface WorkflowModelMapper extends EntityMapper<WorkflowModelDTO, WorkflowModel> {

    @Mapping(source = "author.id", target = "authorId")
    WorkflowModelDTO toDto(WorkflowModel workflowModel);

    @Mapping(target = "wfsinstances", ignore = true)
    @Mapping(target = "removeWfsinstance", ignore = true)
    @Mapping(source = "authorId", target = "author")
    WorkflowModel toEntity(WorkflowModelDTO workflowModelDTO);

    default WorkflowModel fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkflowModel workflowModel = new WorkflowModel();
        workflowModel.setId(id);
        return workflowModel;
    }
}
