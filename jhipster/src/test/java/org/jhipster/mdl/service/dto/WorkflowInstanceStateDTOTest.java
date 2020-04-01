package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowInstanceStateDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowInstanceStateDTO.class);
        WorkflowInstanceStateDTO workflowInstanceStateDTO1 = new WorkflowInstanceStateDTO();
        workflowInstanceStateDTO1.setId(1L);
        WorkflowInstanceStateDTO workflowInstanceStateDTO2 = new WorkflowInstanceStateDTO();
        assertThat(workflowInstanceStateDTO1).isNotEqualTo(workflowInstanceStateDTO2);
        workflowInstanceStateDTO2.setId(workflowInstanceStateDTO1.getId());
        assertThat(workflowInstanceStateDTO1).isEqualTo(workflowInstanceStateDTO2);
        workflowInstanceStateDTO2.setId(2L);
        assertThat(workflowInstanceStateDTO1).isNotEqualTo(workflowInstanceStateDTO2);
        workflowInstanceStateDTO1.setId(null);
        assertThat(workflowInstanceStateDTO1).isNotEqualTo(workflowInstanceStateDTO2);
    }
}
