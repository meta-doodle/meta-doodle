package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WorkflowModelMapperTest {

    private WorkflowModelMapper workflowModelMapper;

    @BeforeEach
    public void setUp() {
        workflowModelMapper = new WorkflowModelMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(workflowModelMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(workflowModelMapper.fromId(null)).isNull();
    }
}
