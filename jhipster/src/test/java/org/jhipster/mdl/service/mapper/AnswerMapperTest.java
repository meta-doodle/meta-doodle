package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AnswerMapperTest {

    private AnswerMapper answerMapper;

    @BeforeEach
    public void setUp() {
        answerMapper = new AnswerMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(answerMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(answerMapper.fromId(null)).isNull();
    }
}
