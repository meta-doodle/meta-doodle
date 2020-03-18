package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class StepUserAnswerWfInstanceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StepUserAnswerWfInstance.class);
        StepUserAnswerWfInstance stepUserAnswerWfInstance1 = new StepUserAnswerWfInstance();
        stepUserAnswerWfInstance1.setId(1L);
        StepUserAnswerWfInstance stepUserAnswerWfInstance2 = new StepUserAnswerWfInstance();
        stepUserAnswerWfInstance2.setId(stepUserAnswerWfInstance1.getId());
        assertThat(stepUserAnswerWfInstance1).isEqualTo(stepUserAnswerWfInstance2);
        stepUserAnswerWfInstance2.setId(2L);
        assertThat(stepUserAnswerWfInstance1).isNotEqualTo(stepUserAnswerWfInstance2);
        stepUserAnswerWfInstance1.setId(null);
        assertThat(stepUserAnswerWfInstance1).isNotEqualTo(stepUserAnswerWfInstance2);
    }
}
