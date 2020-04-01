package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CurrentStepMapperTest {

    private CurrentStepMapper currentStepMapper;

    @BeforeEach
    public void setUp() {
        currentStepMapper = new CurrentStepMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(currentStepMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(currentStepMapper.fromId(null)).isNull();
    }
}
