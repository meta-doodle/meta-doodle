package org.jhipster.mdl.service.mapper;

import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.StepDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Step} and its DTO {@link StepDTO}.
 */
@Mapper(componentModel = "spring", uses = {WorkflowInstanceMapper.class})
public interface StepMapper extends EntityMapper<StepDTO, Step> {

    @Mapping(source = "wfInstance.id", target = "wfInstanceId")
    StepDTO toDto(Step step);

    @Mapping(target = "stepUserAnswer", ignore = true)
    @Mapping(source = "wfInstanceId", target = "wfInstance")
    Step toEntity(StepDTO stepDTO);

    default Step fromId(Long id) {
        if (id == null) {
            return null;
        }
        Step step = new Step();
        step.setId(id);
        return step;
    }
}
