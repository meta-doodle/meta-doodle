package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowInstanceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowInstanceDTO.class);
        WorkflowInstanceDTO workflowInstanceDTO1 = new WorkflowInstanceDTO();
        workflowInstanceDTO1.setId(1L);
        WorkflowInstanceDTO workflowInstanceDTO2 = new WorkflowInstanceDTO();
        assertThat(workflowInstanceDTO1).isNotEqualTo(workflowInstanceDTO2);
        workflowInstanceDTO2.setId(workflowInstanceDTO1.getId());
        assertThat(workflowInstanceDTO1).isEqualTo(workflowInstanceDTO2);
        workflowInstanceDTO2.setId(2L);
        assertThat(workflowInstanceDTO1).isNotEqualTo(workflowInstanceDTO2);
        workflowInstanceDTO1.setId(null);
        assertThat(workflowInstanceDTO1).isNotEqualTo(workflowInstanceDTO2);
    }
}
