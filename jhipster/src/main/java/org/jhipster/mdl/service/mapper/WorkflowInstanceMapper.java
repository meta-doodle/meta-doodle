package org.jhipster.mdl.service.mapper;


import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkflowInstance} and its DTO {@link WorkflowInstanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {WorkflowInstanceStateMapper.class, WorkflowModelMapper.class, MdlUserMapper.class})
public interface WorkflowInstanceMapper extends EntityMapper<WorkflowInstanceDTO, WorkflowInstance> {

    @Mapping(source = "state.id", target = "stateId")
    @Mapping(source = "wfModel.id", target = "wfModelId")
    @Mapping(source = "creator.id", target = "creatorId")
    WorkflowInstanceDTO toDto(WorkflowInstance workflowInstance);

    @Mapping(source = "stateId", target = "state")
    @Mapping(target = "answers", ignore = true)
    @Mapping(target = "removeAnswers", ignore = true)
    @Mapping(source = "wfModelId", target = "wfModel")
    @Mapping(target = "removeGuests", ignore = true)
    @Mapping(source = "creatorId", target = "creator")
    WorkflowInstance toEntity(WorkflowInstanceDTO workflowInstanceDTO);

    default WorkflowInstance fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkflowInstance workflowInstance = new WorkflowInstance();
        workflowInstance.setId(id);
        return workflowInstance;
    }
}
