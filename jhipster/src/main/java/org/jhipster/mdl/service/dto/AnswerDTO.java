package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.Answer} entity.
 */
public class AnswerDTO implements Serializable {

    private Long id;

    private String resp;


    private Long stepUserAnswerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public Long getStepUserAnswerId() {
        return stepUserAnswerId;
    }

    public void setStepUserAnswerId(Long stepUserAnswerWfInstanceId) {
        this.stepUserAnswerId = stepUserAnswerWfInstanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnswerDTO answerDTO = (AnswerDTO) o;
        if (answerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
            "id=" + getId() +
            ", resp='" + getResp() + "'" +
            ", stepUserAnswerId=" + getStepUserAnswerId() +
            "}";
    }
}
