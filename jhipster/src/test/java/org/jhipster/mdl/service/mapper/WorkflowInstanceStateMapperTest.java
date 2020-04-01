package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkflowInstanceStateMapperTest {

    private WorkflowInstanceStateMapper workflowInstanceStateMapper;

    @BeforeEach
    public void setUp() {
        workflowInstanceStateMapper = new WorkflowInstanceStateMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(workflowInstanceStateMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(workflowInstanceStateMapper.fromId(null)).isNull();
    }
}
