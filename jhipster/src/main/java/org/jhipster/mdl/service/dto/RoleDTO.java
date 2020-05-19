package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.Role} entity.
 */
public class RoleDTO implements Serializable {

    private Long id;

    private String role;


    private Long userId;

    private Long workflowInstanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

        RoleDTO roleDTO = (RoleDTO) o;
        if (roleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), roleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            ", userId=" + getUserId() +
            ", workflowInstanceId=" + getWorkflowInstanceId() +
            "}";
    }
}
