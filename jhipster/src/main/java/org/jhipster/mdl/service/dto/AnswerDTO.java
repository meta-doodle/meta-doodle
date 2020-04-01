package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.Objects;
import org.jhipster.mdl.domain.enumeration.AvailableTypes;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.Answer} entity.
 */
public class AnswerDTO implements Serializable {

    private Long id;

    private String stepIdent;

    private String questionIdent;

    private AvailableTypes type;

    private String answer;


    private Long userId;

    private Long workflowInstanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStepIdent() {
        return stepIdent;
    }

    public void setStepIdent(String stepIdent) {
        this.stepIdent = stepIdent;
    }

    public String getQuestionIdent() {
        return questionIdent;
    }

    public void setQuestionIdent(String questionIdent) {
        this.questionIdent = questionIdent;
    }

    public AvailableTypes getType() {
        return type;
    }

    public void setType(AvailableTypes type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long mdlUserId) {
        this.userId = mdlUserId;
    }

    public Long getWorkflowInstanceId() {
        return workflowInstanceId;
    }

    public void setWorkflowInstanceId(Long workflowInstanceId) {
        this.workflowInstanceId = workflowInstanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnswerDTO answerDTO = (AnswerDTO) o;
        if (answerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
            "id=" + getId() +
            ", stepIdent='" + getStepIdent() + "'" +
            ", questionIdent='" + getQuestionIdent() + "'" +
            ", type='" + getType() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", userId=" + getUserId() +
            ", workflowInstanceId=" + getWorkflowInstanceId() +
            "}";
    }
}
