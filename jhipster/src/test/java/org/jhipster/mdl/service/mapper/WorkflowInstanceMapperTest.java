package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkflowInstanceMapperTest {

    private WorkflowInstanceMapper workflowInstanceMapper;

    @BeforeEach
    public void setUp() {
        workflowInstanceMapper = new WorkflowInstanceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(workflowInstanceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(workflowInstanceMapper.fromId(null)).isNull();
    }
}
