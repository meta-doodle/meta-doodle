package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class AnswerTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Answer.class);
        Answer answer1 = new Answer();
        answer1.setId(1L);
        Answer answer2 = new Answer();
        answer2.setId(answer1.getId());
        assertThat(answer1).isEqualTo(answer2);
        answer2.setId(2L);
        assertThat(answer1).isNotEqualTo(answer2);
        answer1.setId(null);
        assertThat(answer1).isNotEqualTo(answer2);
    }
}
