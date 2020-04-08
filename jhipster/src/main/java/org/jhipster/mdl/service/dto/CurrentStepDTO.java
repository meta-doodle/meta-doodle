package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.CurrentStep} entity.
 */
public class CurrentStepDTO implements Serializable {

    private Long id;

    private String stepIdent;

    private Integer numberOfAnswer;


    private Set<MdlUserDTO> users = new HashSet<>();

    private Long workflowInstanceStateId;

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

    public Integer getNumberOfAnswer() {
        return numberOfAnswer;
    }

    public void setNumberOfAnswer(Integer numberOfAnswer) {
        this.numberOfAnswer = numberOfAnswer;
    }

    public Set<MdlUserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<MdlUserDTO> mdlUsers) {
        this.users = mdlUsers;
    }

    public Long getWorkflowInstanceStateId() {
        return workflowInstanceStateId;
    }

    public void setWorkflowInstanceStateId(Long workflowInstanceStateId) {
        this.workflowInstanceStateId = workflowInstanceStateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CurrentStepDTO currentStepDTO = (CurrentStepDTO) o;
        if (currentStepDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), currentStepDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CurrentStepDTO{" +
            "id=" + getId() +
            ", stepIdent='" + getStepIdent() + "'" +
            ", numberOfAnswer=" + getNumberOfAnswer() +
            ", workflowInstanceStateId=" + getWorkflowInstanceStateId() +
            "}";
    }
}
