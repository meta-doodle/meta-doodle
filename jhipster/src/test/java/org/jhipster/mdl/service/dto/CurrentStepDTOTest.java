package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class CurrentStepDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CurrentStepDTO.class);
        CurrentStepDTO currentStepDTO1 = new CurrentStepDTO();
        currentStepDTO1.setId(1L);
        CurrentStepDTO currentStepDTO2 = new CurrentStepDTO();
        assertThat(currentStepDTO1).isNotEqualTo(currentStepDTO2);
        currentStepDTO2.setId(currentStepDTO1.getId());
        assertThat(currentStepDTO1).isEqualTo(currentStepDTO2);
        currentStepDTO2.setId(2L);
        assertThat(currentStepDTO1).isNotEqualTo(currentStepDTO2);
        currentStepDTO1.setId(null);
        assertThat(currentStepDTO1).isNotEqualTo(currentStepDTO2);
    }
}
