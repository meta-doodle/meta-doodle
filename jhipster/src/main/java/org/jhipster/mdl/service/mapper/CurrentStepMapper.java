package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.CurrentStepDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CurrentStep} and its DTO {@link CurrentStepDTO}.
 */
@Mapper(componentModel = "spring", uses = {MdlUserMapper.class, WorkflowInstanceStateMapper.class})
public interface CurrentStepMapper extends EntityMapper<CurrentStepDTO, CurrentStep> {

    @Mapping(source = "workflowInstanceState.id", target = "workflowInstanceStateId")
    CurrentStepDTO toDto(CurrentStep currentStep);

    @Mapping(target = "removeUsers", ignore = true)
    @Mapping(source = "workflowInstanceStateId", target = "workflowInstanceState")
    CurrentStep toEntity(CurrentStepDTO currentStepDTO);

    default CurrentStep fromId(Long id) {
        if (id == null) {
            return null;
        }
        CurrentStep currentStep = new CurrentStep();
        currentStep.setId(id);
        return currentStep;
    }
}
