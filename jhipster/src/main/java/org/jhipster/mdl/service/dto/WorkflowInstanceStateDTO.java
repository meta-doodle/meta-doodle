package org.jhipster.mdl.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.WorkflowInstanceState} entity.
 */
public class WorkflowInstanceStateDTO implements Serializable {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkflowInstanceStateDTO workflowInstanceStateDTO = (WorkflowInstanceStateDTO) o;
        if (workflowInstanceStateDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), workflowInstanceStateDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WorkflowInstanceStateDTO{" +
            "id=" + getId() +
            "}";
    }
}
