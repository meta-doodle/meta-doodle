package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A WorkflowInstance.
 */
@Entity
@Table(name = "workflow_instance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WorkflowInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToMany(mappedBy = "workflowInstance")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StepUserAnswerWfInstance> stepUserAnswers = new HashSet<>();

    @OneToMany(mappedBy = "wfInstance")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Step> steps = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "workflow_instance_guests",
               joinColumns = @JoinColumn(name = "workflow_instance_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "guests_id", referencedColumnName = "id"))
    private Set<MdlUser> guests = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("wfsinstances")
    private WorkflowModel wfModel;

    @ManyToOne
    @JsonIgnoreProperties("workflowInstances")
    private MdlUser creator;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StepUserAnswerWfInstance> getStepUserAnswers() {
        return stepUserAnswers;
    }

    public WorkflowInstance stepUserAnswers(Set<StepUserAnswerWfInstance> stepUserAnswerWfInstances) {
        this.stepUserAnswers = stepUserAnswerWfInstances;
        return this;
    }

    public WorkflowInstance addStepUserAnswers(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswers.add(stepUserAnswerWfInstance);
        stepUserAnswerWfInstance.setWorkflowInstance(this);
        return this;
    }

    public WorkflowInstance removeStepUserAnswers(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswers.remove(stepUserAnswerWfInstance);
        stepUserAnswerWfInstance.setWorkflowInstance(null);
        return this;
    }

    public void setStepUserAnswers(Set<StepUserAnswerWfInstance> stepUserAnswerWfInstances) {
        this.stepUserAnswers = stepUserAnswerWfInstances;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public WorkflowInstance steps(Set<Step> steps) {
        this.steps = steps;
        return this;
    }

    public WorkflowInstance addSteps(Step step) {
        this.steps.add(step);
        step.setWfInstance(this);
        return this;
    }

    public WorkflowInstance removeSteps(Step step) {
        this.steps.remove(step);
        step.setWfInstance(null);
        return this;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public Set<MdlUser> getGuests() {
        return guests;
    }

    public WorkflowInstance guests(Set<MdlUser> mdlUsers) {
        this.guests = mdlUsers;
        return this;
    }

    public WorkflowInstance addGuests(MdlUser mdlUser) {
        this.guests.add(mdlUser);
        mdlUser.getParticipants().add(this);
        return this;
    }

    public WorkflowInstance removeGuests(MdlUser mdlUser) {
        this.guests.remove(mdlUser);
        mdlUser.getParticipants().remove(this);
        return this;
    }

    public void setGuests(Set<MdlUser> mdlUsers) {
        this.guests = mdlUsers;
    }

    public WorkflowModel getWfModel() {
        return wfModel;
    }

    public WorkflowInstance wfModel(WorkflowModel workflowModel) {
        this.wfModel = workflowModel;
        return this;
    }

    public void setWfModel(WorkflowModel workflowModel) {
        this.wfModel = workflowModel;
    }

    public MdlUser getCreator() {
        return creator;
    }

    public WorkflowInstance creator(MdlUser mdlUser) {
        this.creator = mdlUser;
        return this;
    }

    public void setCreator(MdlUser mdlUser) {
        this.creator = mdlUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkflowInstance)) {
            return false;
        }
        return id != null && id.equals(((WorkflowInstance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WorkflowInstance{" +
            "id=" + getId() +
            "}";
    }
}
