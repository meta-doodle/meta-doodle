package org.jhipster.mdl.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.Step} entity.
 */
public class StepDTO implements Serializable {

    private Long id;

    private Integer mandatory;

    @NotNull
    private Integer answered;

    @NotNull
    private LocalDate deadline;

    private Long nextStep;


    private Long wfInstanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMandatory() {
        return mandatory;
    }

    public void setMandatory(Integer mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getAnswered() {
        return answered;
    }

    public void setAnswered(Integer answered) {
        this.answered = answered;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Long getNextStep() {
        return nextStep;
    }

    public void setNextStep(Long nextStep) {
        this.nextStep = nextStep;
    }

    public Long getWfInstanceId() {
        return wfInstanceId;
    }

    public void setWfInstanceId(Long workflowInstanceId) {
        this.wfInstanceId = workflowInstanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StepDTO stepDTO = (StepDTO) o;
        if (stepDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stepDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StepDTO{" +
            "id=" + getId() +
            ", mandatory=" + getMandatory() +
            ", answered=" + getAnswered() +
            ", deadline='" + getDeadline() + "'" +
            ", nextStep=" + getNextStep() +
            ", wfInstanceId=" + getWfInstanceId() +
            "}";
    }
}
