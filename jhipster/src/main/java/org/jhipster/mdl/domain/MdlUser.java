package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A MdlUser.
 */
@Entity
@Table(name = "mdl_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MdlUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToOne

    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "creator")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowInstance> creatorWfInstances = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowModel> workflows = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<CurrentStep> steps = new HashSet<>();

    @ManyToMany(mappedBy = "guests")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<WorkflowInstance> workflowInstances = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public MdlUser user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<WorkflowInstance> getCreatorWfInstances() {
        return creatorWfInstances;
    }

    public MdlUser creatorWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.creatorWfInstances = workflowInstances;
        return this;
    }

    public MdlUser addCreatorWfInstances(WorkflowInstance workflowInstance) {
        this.creatorWfInstances.add(workflowInstance);
        workflowInstance.setCreator(this);
        return this;
    }

    public MdlUser removeCreatorWfInstances(WorkflowInstance workflowInstance) {
        this.creatorWfInstances.remove(workflowInstance);
        workflowInstance.setCreator(null);
        return this;
    }

    public void setCreatorWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.creatorWfInstances = workflowInstances;
    }

    public Set<WorkflowModel> getWorkflows() {
        return workflows;
    }

    public MdlUser workflows(Set<WorkflowModel> workflowModels) {
        this.workflows = workflowModels;
        return this;
    }

    public MdlUser addWorkflows(WorkflowModel workflowModel) {
        this.workflows.add(workflowModel);
        workflowModel.setCreator(this);
        return this;
    }

    public MdlUser removeWorkflows(WorkflowModel workflowModel) {
        this.workflows.remove(workflowModel);
        workflowModel.setCreator(null);
        return this;
    }

    public void setWorkflows(Set<WorkflowModel> workflowModels) {
        this.workflows = workflowModels;
    }

    public Set<CurrentStep> getSteps() {
        return steps;
    }

    public MdlUser steps(Set<CurrentStep> currentSteps) {
        this.steps = currentSteps;
        return this;
    }

    public MdlUser addSteps(CurrentStep currentStep) {
        this.steps.add(currentStep);
        currentStep.getUsers().add(this);
        return this;
    }

    public MdlUser removeSteps(CurrentStep currentStep) {
        this.steps.remove(currentStep);
        currentStep.getUsers().remove(this);
        return this;
    }

    public void setSteps(Set<CurrentStep> currentSteps) {
        this.steps = currentSteps;
    }

    public Set<WorkflowInstance> getWorkflowInstances() {
        return workflowInstances;
    }

    public MdlUser workflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
        return this;
    }

    public MdlUser addWorkflowInstances(WorkflowInstance workflowInstance) {
        this.workflowInstances.add(workflowInstance);
        workflowInstance.getGuests().add(this);
        return this;
    }

    public MdlUser removeWorkflowInstances(WorkflowInstance workflowInstance) {
        this.workflowInstances.remove(workflowInstance);
        workflowInstance.getGuests().remove(this);
        return this;
    }

    public void setWorkflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MdlUser)) {
            return false;
        }
        return id != null && id.equals(((MdlUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MdlUser{" +
            "id=" + getId() +
            "}";
    }
}
