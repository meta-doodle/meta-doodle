package org.jhipster.mdl.service.mapper;


import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.WorkflowInstanceStateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkflowInstanceState} and its DTO {@link WorkflowInstanceStateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WorkflowInstanceStateMapper extends EntityMapper<WorkflowInstanceStateDTO, WorkflowInstanceState> {


    @Mapping(target = "steps", ignore = true)
    @Mapping(target = "removeSteps", ignore = true)
    @Mapping(target = "workflowInstance", ignore = true)
    WorkflowInstanceState toEntity(WorkflowInstanceStateDTO workflowInstanceStateDTO);

    default WorkflowInstanceState fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkflowInstanceState workflowInstanceState = new WorkflowInstanceState();
        workflowInstanceState.setId(id);
        return workflowInstanceState;
    }
}
