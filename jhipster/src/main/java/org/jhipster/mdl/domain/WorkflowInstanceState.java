package org.jhipster.mdl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * A WorkflowInstanceState.
 */
@Entity
@Table(name = "workflow_instance_state")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WorkflowInstanceState implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToMany(mappedBy = "workflowInstanceState")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CurrentStep> steps = new HashSet<>();

    @OneToOne(mappedBy = "state")
    @JsonIgnore
    private WorkflowInstance workflowInstance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CurrentStep> getSteps() {
        return steps;
    }

    public WorkflowInstanceState steps(Set<CurrentStep> currentSteps) {
        this.steps = currentSteps;
        return this;
    }

    public WorkflowInstanceState addSteps(CurrentStep currentStep) {
        this.steps.add(currentStep);
        currentStep.setWorkflowInstanceState(this);
        return this;
    }

    public WorkflowInstanceState removeSteps(CurrentStep currentStep) {
        this.steps.remove(currentStep);
        currentStep.setWorkflowInstanceState(null);
        return this;
    }

    public void setSteps(Set<CurrentStep> currentSteps) {
        this.steps = currentSteps;
    }

    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }

    public WorkflowInstanceState workflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
        return this;
    }

    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove
    
    public Optional<CurrentStep> findCurrentStepContainingMdlUser(MdlUser mdlUser){
    	for (CurrentStep currentStep : steps) {
			if(currentStep.getUsers().contains(mdlUser)) {
				return Optional.of(currentStep);
			}
		}
    	return Optional.empty();
    }
    
    public CurrentStep putMdlUserInRightCurrentStep(MdlUser mdlUser, String nextStep) {
    	for (CurrentStep currentStep : steps) {
			if(currentStep.getStepIdent().equals(nextStep)) {
				currentStep.addUsers(mdlUser);
				return currentStep;
			}
		}
    	CurrentStep newCurrentStep = new CurrentStep();
    	newCurrentStep.setStepIdent(nextStep);
    	newCurrentStep.addUsers(mdlUser);
    	addSteps(newCurrentStep);
    	return newCurrentStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkflowInstanceState)) {
            return false;
        }
        return id != null && id.equals(((WorkflowInstanceState) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WorkflowInstanceState{" +
            "id=" + getId() +
            "}";
    }
}
