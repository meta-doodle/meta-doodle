package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.StepUserAnswerWfInstance} entity.
 */
public class StepUserAnswerWfInstanceDTO implements Serializable {

    private Long id;


    private Long stepId;

    private Long mdlUserId;

    private Long workflowInstanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Long getMdlUserId() {
        return mdlUserId;
    }

    public void setMdlUserId(Long mdlUserId) {
        this.mdlUserId = mdlUserId;
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

        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO = (StepUserAnswerWfInstanceDTO) o;
        if (stepUserAnswerWfInstanceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stepUserAnswerWfInstanceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StepUserAnswerWfInstanceDTO{" +
            "id=" + getId() +
            ", stepId=" + getStepId() +
            ", mdlUserId=" + getMdlUserId() +
            ", workflowInstanceId=" + getWorkflowInstanceId() +
            "}";
    }
}
