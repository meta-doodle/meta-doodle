package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowModelDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowModelDTO.class);
        WorkflowModelDTO workflowModelDTO1 = new WorkflowModelDTO();
        workflowModelDTO1.setId(1L);
        WorkflowModelDTO workflowModelDTO2 = new WorkflowModelDTO();
        assertThat(workflowModelDTO1).isNotEqualTo(workflowModelDTO2);
        workflowModelDTO2.setId(workflowModelDTO1.getId());
        assertThat(workflowModelDTO1).isEqualTo(workflowModelDTO2);
        workflowModelDTO2.setId(2L);
        assertThat(workflowModelDTO1).isNotEqualTo(workflowModelDTO2);
        workflowModelDTO1.setId(null);
        assertThat(workflowModelDTO1).isNotEqualTo(workflowModelDTO2);
    }
}
