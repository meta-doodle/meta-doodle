package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A StepUserAnswerWfInstance.
 */
@Entity
@Table(name = "step_user_answer_wf_instance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StepUserAnswerWfInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private Step step;

    @OneToMany(mappedBy = "stepUserAnswer")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("stepUserAnswers")
    private MdlUser mdlUser;

    @ManyToOne
    @JsonIgnoreProperties("stepUserAnswers")
    private WorkflowInstance workflowInstance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Step getStep() {
        return step;
    }

    public StepUserAnswerWfInstance step(Step step) {
        this.step = step;
        return this;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public StepUserAnswerWfInstance answers(Set<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public StepUserAnswerWfInstance addAnswers(Answer answer) {
        this.answers.add(answer);
        answer.setStepUserAnswer(this);
        return this;
    }

    public StepUserAnswerWfInstance removeAnswers(Answer answer) {
        this.answers.remove(answer);
        answer.setStepUserAnswer(null);
        return this;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public MdlUser getMdlUser() {
        return mdlUser;
    }

    public StepUserAnswerWfInstance mdlUser(MdlUser mdlUser) {
        this.mdlUser = mdlUser;
        return this;
    }

    public void setMdlUser(MdlUser mdlUser) {
        this.mdlUser = mdlUser;
    }

    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }

    public StepUserAnswerWfInstance workflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
        return this;
    }

    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StepUserAnswerWfInstance)) {
            return false;
        }
        return id != null && id.equals(((StepUserAnswerWfInstance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StepUserAnswerWfInstance{" +
            "id=" + getId() +
            "}";
    }
}
