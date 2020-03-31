package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowInstanceStateTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowInstanceState.class);
        WorkflowInstanceState workflowInstanceState1 = new WorkflowInstanceState();
        workflowInstanceState1.setId(1L);
        WorkflowInstanceState workflowInstanceState2 = new WorkflowInstanceState();
        workflowInstanceState2.setId(workflowInstanceState1.getId());
        assertThat(workflowInstanceState1).isEqualTo(workflowInstanceState2);
        workflowInstanceState2.setId(2L);
        assertThat(workflowInstanceState1).isNotEqualTo(workflowInstanceState2);
        workflowInstanceState1.setId(null);
        assertThat(workflowInstanceState1).isNotEqualTo(workflowInstanceState2);
    }
}
