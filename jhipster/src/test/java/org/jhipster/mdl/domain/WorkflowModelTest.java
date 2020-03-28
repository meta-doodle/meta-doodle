package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class WorkflowModelTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkflowModel.class);
        WorkflowModel workflowModel1 = new WorkflowModel();
        workflowModel1.setId(1L);
        WorkflowModel workflowModel2 = new WorkflowModel();
        workflowModel2.setId(workflowModel1.getId());
        assertThat(workflowModel1).isEqualTo(workflowModel2);
        workflowModel2.setId(2L);
        assertThat(workflowModel1).isNotEqualTo(workflowModel2);
        workflowModel1.setId(null);
        assertThat(workflowModel1).isNotEqualTo(workflowModel2);
    }
}
