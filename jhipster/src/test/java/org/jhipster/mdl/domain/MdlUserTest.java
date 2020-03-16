package org.jhipster.mdl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class MdlUserTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdlUser.class);
        MdlUser mdlUser1 = new MdlUser();
        mdlUser1.setId(1L);
        MdlUser mdlUser2 = new MdlUser();
        mdlUser2.setId(mdlUser1.getId());
        assertThat(mdlUser1).isEqualTo(mdlUser2);
        mdlUser2.setId(2L);
        assertThat(mdlUser1).isNotEqualTo(mdlUser2);
        mdlUser1.setId(null);
        assertThat(mdlUser1).isNotEqualTo(mdlUser2);
    }
}
