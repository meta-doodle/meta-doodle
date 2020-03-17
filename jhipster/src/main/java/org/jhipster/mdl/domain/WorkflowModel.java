package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A WorkflowModel.
 */
@Entity
@Table(name = "workflow_model")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WorkflowModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 3, max = 25)
    @Column(name = "title", length = 25, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "body", nullable = false)
    private String body;

    @OneToMany(mappedBy = "wfModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowInstance> workflowInstances = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("createdWfModels")
    private MdlUser author;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public WorkflowModel title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public WorkflowModel description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public WorkflowModel body(String body) {
        this.body = body;
        return this;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<WorkflowInstance> getWorkflowInstances() {
        return workflowInstances;
    }

    public WorkflowModel workflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
        return this;
    }

    public WorkflowModel addWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.add(workflowInstance);
        workflowInstance.setWfModel(this);
        return this;
    }

    public WorkflowModel removeWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.remove(workflowInstance);
        workflowInstance.setWfModel(null);
        return this;
    }

    public void setWorkflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
    }

    public MdlUser getAuthor() {
        return author;
    }

    public WorkflowModel author(MdlUser mdlUser) {
        this.author = mdlUser;
        return this;
    }

    public void setAuthor(MdlUser mdlUser) {
        this.author = mdlUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkflowModel)) {
            return false;
        }
        return id != null && id.equals(((WorkflowModel) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WorkflowModel{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", body='" + getBody() + "'" +
            "}";
    }
}
