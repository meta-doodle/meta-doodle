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
    private Set<WorkflowModel> createdWfModels = new HashSet<>();

    @OneToMany(mappedBy = "mdlUser")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StepUserAnswerWfInstance> stepUserAnswers = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowInstance> createdWfInstances = new HashSet<>();

    @ManyToMany(mappedBy = "guests")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<WorkflowInstance> memberWfInstances = new HashSet<>();

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

    public Set<WorkflowModel> getCreatedWfModels() {
        return createdWfModels;
    }

    public MdlUser createdWfModels(Set<WorkflowModel> workflowModels) {
        this.createdWfModels = workflowModels;
        return this;
    }

    public MdlUser addCreatedWfModel(WorkflowModel workflowModel) {
        this.createdWfModels.add(workflowModel);
        workflowModel.setAuthor(this);
        return this;
    }

    public MdlUser removeCreatedWfModel(WorkflowModel workflowModel) {
        this.createdWfModels.remove(workflowModel);
        workflowModel.setAuthor(null);
        return this;
    }

    public void setCreatedWfModels(Set<WorkflowModel> workflowModels) {
        this.createdWfModels = workflowModels;
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

    public Set<WorkflowInstance> getCreatedWfInstances() {
        return createdWfInstances;
    }

    public MdlUser createdWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.createdWfInstances = workflowInstances;
        return this;
    }

    public MdlUser addCreatedWfInstance(WorkflowInstance workflowInstance) {
        this.createdWfInstances.add(workflowInstance);
        workflowInstance.setCreator(this);
        return this;
    }

    public MdlUser removeCreatedWfInstance(WorkflowInstance workflowInstance) {
        this.createdWfInstances.remove(workflowInstance);
        workflowInstance.setCreator(null);
        return this;
    }

    public void setCreatedWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.createdWfInstances = workflowInstances;
    }

    public Set<WorkflowInstance> getMemberWfInstances() {
        return memberWfInstances;
    }

    public MdlUser memberWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.memberWfInstances = workflowInstances;
        return this;
    }

    public MdlUser addMemberWfInstance(WorkflowInstance workflowInstance) {
        this.memberWfInstances.add(workflowInstance);
        workflowInstance.getGuests().add(this);
        return this;
    }

    public MdlUser removeMemberWfInstance(WorkflowInstance workflowInstance) {
        this.memberWfInstances.remove(workflowInstance);
        workflowInstance.getGuests().remove(this);
        return this;
    }

    public void setMemberWfInstances(Set<WorkflowInstance> workflowInstances) {
        this.memberWfInstances = workflowInstances;
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
