package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.WorkflowInstanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkflowInstance} and its DTO {@link WorkflowInstanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {MdlUserMapper.class, WorkflowModelMapper.class})
public interface WorkflowInstanceMapper extends EntityMapper<WorkflowInstanceDTO, WorkflowInstance> {

    @Mapping(source = "wfModel.id", target = "wfModelId")
    @Mapping(source = "creator.id", target = "creatorId")
    WorkflowInstanceDTO toDto(WorkflowInstance workflowInstance);

    @Mapping(target = "stepUserAnswers", ignore = true)
    @Mapping(target = "removeStepUserAnswers", ignore = true)
    @Mapping(target = "steps", ignore = true)
    @Mapping(target = "removeSteps", ignore = true)
    @Mapping(target = "removeGuests", ignore = true)
    @Mapping(source = "wfModelId", target = "wfModel")
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
