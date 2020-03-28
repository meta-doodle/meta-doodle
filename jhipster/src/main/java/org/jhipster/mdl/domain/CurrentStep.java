package org.jhipster.mdl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A CurrentStep.
 */
@Entity
@Table(name = "current_step")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CurrentStep implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "step_ident")
    private Integer stepIdent;

    @Column(name = "number_of_answer")
    private Integer numberOfAnswer;

    @OneToMany(mappedBy = "currentStep")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MdlUser> users = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("steps")
    private WorkflowInstanceState workflowInstanceState;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStepIdent() {
        return stepIdent;
    }

    public CurrentStep stepIdent(Integer stepIdent) {
        this.stepIdent = stepIdent;
        return this;
    }

    public void setStepIdent(Integer stepIdent) {
        this.stepIdent = stepIdent;
    }

    public Integer getNumberOfAnswer() {
        return numberOfAnswer;
    }

    public CurrentStep numberOfAnswer(Integer numberOfAnswer) {
        this.numberOfAnswer = numberOfAnswer;
        return this;
    }

    public void setNumberOfAnswer(Integer numberOfAnswer) {
        this.numberOfAnswer = numberOfAnswer;
    }

    public Set<MdlUser> getUsers() {
        return users;
    }

    public CurrentStep users(Set<MdlUser> mdlUsers) {
        this.users = mdlUsers;
        return this;
    }

    public CurrentStep addUsers(MdlUser mdlUser) {
        this.users.add(mdlUser);
        mdlUser.setCurrentStep(this);
        return this;
    }

    public CurrentStep removeUsers(MdlUser mdlUser) {
        this.users.remove(mdlUser);
        mdlUser.setCurrentStep(null);
        return this;
    }

    public void setUsers(Set<MdlUser> mdlUsers) {
        this.users = mdlUsers;
    }

    public WorkflowInstanceState getWorkflowInstanceState() {
        return workflowInstanceState;
    }

    public CurrentStep workflowInstanceState(WorkflowInstanceState workflowInstanceState) {
        this.workflowInstanceState = workflowInstanceState;
        return this;
    }

    public void setWorkflowInstanceState(WorkflowInstanceState workflowInstanceState) {
        this.workflowInstanceState = workflowInstanceState;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CurrentStep)) {
            return false;
        }
        return id != null && id.equals(((CurrentStep) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CurrentStep{" +
            "id=" + getId() +
            ", stepIdent=" + getStepIdent() +
            ", numberOfAnswer=" + getNumberOfAnswer() +
            "}";
    }
}
