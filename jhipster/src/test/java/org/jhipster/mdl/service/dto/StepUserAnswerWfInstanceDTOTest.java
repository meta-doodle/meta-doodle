package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class StepUserAnswerWfInstanceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StepUserAnswerWfInstanceDTO.class);
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO1 = new StepUserAnswerWfInstanceDTO();
        stepUserAnswerWfInstanceDTO1.setId(1L);
        StepUserAnswerWfInstanceDTO stepUserAnswerWfInstanceDTO2 = new StepUserAnswerWfInstanceDTO();
        assertThat(stepUserAnswerWfInstanceDTO1).isNotEqualTo(stepUserAnswerWfInstanceDTO2);
        stepUserAnswerWfInstanceDTO2.setId(stepUserAnswerWfInstanceDTO1.getId());
        assertThat(stepUserAnswerWfInstanceDTO1).isEqualTo(stepUserAnswerWfInstanceDTO2);
        stepUserAnswerWfInstanceDTO2.setId(2L);
        assertThat(stepUserAnswerWfInstanceDTO1).isNotEqualTo(stepUserAnswerWfInstanceDTO2);
        stepUserAnswerWfInstanceDTO1.setId(null);
        assertThat(stepUserAnswerWfInstanceDTO1).isNotEqualTo(stepUserAnswerWfInstanceDTO2);
    }
}
