package org.jhipster.mdl.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.WorkflowInstance} entity.
 */
public class WorkflowInstanceDTO implements Serializable {

    private Long id;

    private String description;


    private Long stateId;

    private Long wfModelId;

    private Set<MdlUserDTO> guests = new HashSet<>();

    private Long creatorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long workflowInstanceStateId) {
        this.stateId = workflowInstanceStateId;
    }

    public Long getWfModelId() {
        return wfModelId;
    }

    public void setWfModelId(Long workflowModelId) {
        this.wfModelId = workflowModelId;
    }

    public Set<MdlUserDTO> getGuests() {
        return guests;
    }

    public void setGuests(Set<MdlUserDTO> mdlUsers) {
        this.guests = mdlUsers;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long mdlUserId) {
        this.creatorId = mdlUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkflowInstanceDTO workflowInstanceDTO = (WorkflowInstanceDTO) o;
        if (workflowInstanceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), workflowInstanceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WorkflowInstanceDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", stateId=" + getStateId() +
            ", wfModelId=" + getWfModelId() +
            ", creatorId=" + getCreatorId() +
            "}";
    }
}
