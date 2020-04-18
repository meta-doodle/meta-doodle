package org.jhipster.mdl.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.WorkflowModel} entity.
 */
public class WorkflowModelDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 25)
    private String title;

    private String description;

    @NotNull
    private String body;


    private Long creatorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

        WorkflowModelDTO workflowModelDTO = (WorkflowModelDTO) o;
        if (workflowModelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), workflowModelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WorkflowModelDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", body='" + getBody() + "'" +
            ", creatorId=" + getCreatorId() +
            "}";
    }
}
