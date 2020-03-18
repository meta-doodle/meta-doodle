package org.jhipster.mdl.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

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

    @Column(name = "resp")
    private String resp;

    @ManyToOne
    @JsonIgnoreProperties("answers")
    private StepUserAnswerWfInstance stepUserAnswer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResp() {
        return resp;
    }

    public Answer resp(String resp) {
        this.resp = resp;
        return this;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public StepUserAnswerWfInstance getStepUserAnswer() {
        return stepUserAnswer;
    }

    public Answer stepUserAnswer(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswer = stepUserAnswerWfInstance;
        return this;
    }

    public void setStepUserAnswer(StepUserAnswerWfInstance stepUserAnswerWfInstance) {
        this.stepUserAnswer = stepUserAnswerWfInstance;
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
            ", resp='" + getResp() + "'" +
            "}";
    }
}
