package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import org.jhipster.mdl.domain.enumeration.AvailableTypes;

/**
 * A Answer.
 */
@Entity
@Table(name = "answer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "step_ident")
    private String stepIdent;

    @Column(name = "question_ident")
    private String questionIdent;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AvailableTypes type;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JsonIgnoreProperties("answers")
    private MdlUser user;

    @ManyToOne
    @JsonIgnoreProperties("answers")
    private WorkflowInstance workflowInstance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStepIdent() {
        return stepIdent;
    }

    public Answer stepIdent(String stepIdent) {
        this.stepIdent = stepIdent;
        return this;
    }

    public void setStepIdent(String stepIdent) {
        this.stepIdent = stepIdent;
    }

    public String getQuestionIdent() {
        return questionIdent;
    }

    public Answer questionIdent(String questionIdent) {
        this.questionIdent = questionIdent;
        return this;
    }

    public void setQuestionIdent(String questionIdent) {
        this.questionIdent = questionIdent;
    }

    public AvailableTypes getType() {
        return type;
    }

    public Answer type(AvailableTypes type) {
        this.type = type;
        return this;
    }

    public void setType(AvailableTypes type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public Answer answer(String answer) {
        this.answer = answer;
        return this;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public MdlUser getUser() {
        return user;
    }

    public Answer user(MdlUser mdlUser) {
        this.user = mdlUser;
        return this;
    }

    public void setUser(MdlUser mdlUser) {
        this.user = mdlUser;
    }

    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }

    public Answer workflowInstance(WorkflowInstance workflowInstance) {
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
        if (!(o instanceof Answer)) {
            return false;
        }
        return id != null && id.equals(((Answer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Answer{" +
            "id=" + getId() +
            ", stepIdent='" + getStepIdent() + "'" +
            ", questionIdent='" + getQuestionIdent() + "'" +
            ", type='" + getType() + "'" +
            ", answer='" + getAnswer() + "'" +
            "}";
    }
}
