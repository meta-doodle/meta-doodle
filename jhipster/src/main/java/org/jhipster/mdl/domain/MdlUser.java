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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "author")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowModel> workflows = new HashSet<>();

    @OneToMany(mappedBy = "mdlUser")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StepUserAnswerWfInstance> stepUserAnswers = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowInstance> workflowInstances = new HashSet<>();

    @ManyToMany(mappedBy = "guests")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<WorkflowInstance> participants = new HashSet<>();

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

    public Set<WorkflowModel> getWorkflows() {
        return workflows;
    }

    public MdlUser workflows(Set<WorkflowModel> workflowModels) {
        this.workflows = workflowModels;
        return this;
    }

    public MdlUser addWorkflows(WorkflowModel workflowModel) {
        this.workflows.add(workflowModel);
        workflowModel.setAuthor(this);
        return this;
    }

    public MdlUser removeWorkflows(WorkflowModel workflowModel) {
        this.workflows.remove(workflowModel);
        workflowModel.setAuthor(null);
        return this;
    }

    public void setWorkflows(Set<WorkflowModel> workflowModels) {
        this.workflows = workflowModels;
    }

    public Set<StepUserAnswerWfInstance> getStepUserAnswers() {
        return stepUserAnswers;
    }

    public MdlUser stepUserAnswers(Set<StepUserAnswerWfInstance> stepUserAnswerWfInstances) {
        this.stepUserAnswers = stepUserAnswerWfInstances;
        return this;
    }

    public MdlUser addStepUserAnswers(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswers.add(stepUserAnswerWfInstance);
        stepUserAnswerWfInstance.setMdlUser(this);
        return this;
    }

    public MdlUser removeStepUserAnswers(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswers.remove(stepUserAnswerWfInstance);
        stepUserAnswerWfInstance.setMdlUser(null);
        return this;
    }

    public void setStepUserAnswers(Set<StepUserAnswerWfInstance> stepUserAnswerWfInstances) {
        this.stepUserAnswers = stepUserAnswerWfInstances;
    }

    public Set<WorkflowInstance> getWorkflowInstances() {
        return workflowInstances;
    }

    public MdlUser workflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
        return this;
    }

    public MdlUser addWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.add(workflowInstance);
        workflowInstance.setCreator(this);
        return this;
    }

    public MdlUser removeWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.remove(workflowInstance);
        workflowInstance.setCreator(null);
        return this;
    }

    public void setWorkflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
    }

    public Set<WorkflowInstance> getParticipants() {
        return participants;
    }

    public MdlUser participants(Set<WorkflowInstance> workflowInstances) {
        this.participants = workflowInstances;
        return this;
    }

    public MdlUser addParticipants(WorkflowInstance workflowInstance) {
        this.participants.add(workflowInstance);
        workflowInstance.getGuests().add(this);
        return this;
    }

    public MdlUser removeParticipants(WorkflowInstance workflowInstance) {
        this.participants.remove(workflowInstance);
        workflowInstance.getGuests().remove(this);
        return this;
    }

    public void setParticipants(Set<WorkflowInstance> workflowInstances) {
        this.participants = workflowInstances;
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
