package org.jhipster.mdl.service.mapper;


import org.jhipster.mdl.domain.*;
import org.jhipster.mdl.service.dto.AnswerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Answer} and its DTO {@link AnswerDTO}.
 */
@Mapper(componentModel = "spring", uses = {MdlUserMapper.class, WorkflowInstanceMapper.class})
public interface AnswerMapper extends EntityMapper<AnswerDTO, Answer> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "workflowInstance.id", target = "workflowInstanceId")
    AnswerDTO toDto(Answer answer);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "workflowInstanceId", target = "workflowInstance")
    Answer toEntity(AnswerDTO answerDTO);

    default Answer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setId(id);
        return answer;
    }
}
