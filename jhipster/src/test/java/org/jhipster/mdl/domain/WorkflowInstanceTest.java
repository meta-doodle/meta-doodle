package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowInstanceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowInstance.class);
        WorkflowInstance workflowInstance1 = new WorkflowInstance();
        workflowInstance1.setId(1L);
        WorkflowInstance workflowInstance2 = new WorkflowInstance();
        workflowInstance2.setId(workflowInstance1.getId());
        assertThat(workflowInstance1).isEqualTo(workflowInstance2);
        workflowInstance2.setId(2L);
        assertThat(workflowInstance1).isNotEqualTo(workflowInstance2);
        workflowInstance1.setId(null);
        assertThat(workflowInstance1).isNotEqualTo(workflowInstance2);
    }
}
