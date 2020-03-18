package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.StepUserAnswerWfInstanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StepUserAnswerWfInstance} and its DTO {@link StepUserAnswerWfInstanceDTO}.
 */
@Mapper(componentModel = "spring", uses = {StepMapper.class, MdlUserMapper.class, WorkflowInstanceMapper.class})
public interface StepUserAnswerWfInstanceMapper extends EntityMapper<StepUserAnswerWfInstanceDTO, StepUserAnswerWfInstance> {

    @Mapping(source = "step.id", target = "stepId")
    @Mapping(source = "mdlUser.id", target = "mdlUserId")
    @Mapping(source = "workflowInstance.id", target = "workflowInstanceId")
    StepUserAnswerWfInstanceDTO toDto(StepUserAnswerWfInstance stepUserAnswerWfInstance);

    @Mapping(source = "stepId", target = "step")
    @Mapping(target = "answers", ignore = true)
    @Mapping(target = "removeAnswers", ignore = true)
    @Mapping(source = "mdlUserId", target = "mdlUser")
    @Mapping(source = "workflowInstanceId", target = "workflowInstance")
    StepUserAnswerWfInstance toEntity(StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO);

    default StepUserAnswerWfInstance fromId(Long id) {
        if (id == null) {
            return null;
        }
        StepUserAnswerWfInstance stepUserAnswerWfInstance = new StepUserAnswerWfInstance();
        stepUserAnswerWfInstance.setId(id);
        return stepUserAnswerWfInstance;
    }
}
