package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Step.
 */
@Entity
@Table(name = "step")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Step implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "mandatory")
    private Integer mandatory;

    @NotNull
    @Column(name = "answered", nullable = false)
    private Integer answered;

    @NotNull
    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "next_step")
    private Long nextStep;

    @OneToOne(mappedBy = "step")
    @JsonIgnore
    private StepUserAnswerWfInstance stepUserAnswer;

    @ManyToOne
    @JsonIgnoreProperties("steps")
    private WorkflowInstance wfInstance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMandatory() {
        return mandatory;
    }

    public Step mandatory(Integer mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public void setMandatory(Integer mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getAnswered() {
        return answered;
    }

    public Step answered(Integer answered) {
        this.answered = answered;
        return this;
    }

    public void setAnswered(Integer answered) {
        this.answered = answered;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Step deadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Long getNextStep() {
        return nextStep;
    }

    public Step nextStep(Long nextStep) {
        this.nextStep = nextStep;
        return this;
    }

    public void setNextStep(Long nextStep) {
        this.nextStep = nextStep;
    }

    public StepUserAnswerWfInstance getStepUserAnswer() {
        return stepUserAnswer;
    }

    public Step stepUserAnswer(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswer = stepUserAnswerWfInstance;
        return this;
    }

    public void setStepUserAnswer(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswer = stepUserAnswerWfInstance;
    }

    public WorkflowInstance getWfInstance() {
        return wfInstance;
    }

    public Step wfInstance(WorkflowInstance workflowInstance) {
        this.wfInstance = workflowInstance;
        return this;
    }

    public void setWfInstance(WorkflowInstance workflowInstance) {
        this.wfInstance = workflowInstance;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Step)) {
            return false;
        }
        return id != null && id.equals(((Step) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Step{" +
            "id=" + getId() +
            ", mandatory=" + getMandatory() +
            ", answered=" + getAnswered() +
            ", deadline='" + getDeadline() + "'" +
            ", nextStep=" + getNextStep() +
            "}";
    }
}
