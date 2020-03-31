package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class CurrentStepTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CurrentStep.class);
        CurrentStep currentStep1 = new CurrentStep();
        currentStep1.setId(1L);
        CurrentStep currentStep2 = new CurrentStep();
        currentStep2.setId(currentStep1.getId());
        assertThat(currentStep1).isEqualTo(currentStep2);
        currentStep2.setId(2L);
        assertThat(currentStep1).isNotEqualTo(currentStep2);
        currentStep1.setId(null);
        assertThat(currentStep1).isNotEqualTo(currentStep2);
    }
}
