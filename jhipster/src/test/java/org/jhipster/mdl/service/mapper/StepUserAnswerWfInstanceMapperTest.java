package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class StepUserAnswerWfInstanceMapperTest {

    private StepUserAnswerWfInstanceMapper stepUserAnswerWfInstanceMapper;

    @BeforeEach
    public void setUp() {
        stepUserAnswerWfInstanceMapper = new StepUserAnswerWfInstanceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(stepUserAnswerWfInstanceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(stepUserAnswerWfInstanceMapper.fromId(null)).isNull();
    }
}
