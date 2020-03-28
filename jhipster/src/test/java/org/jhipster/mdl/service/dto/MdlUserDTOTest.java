package org.jhipster.mdl.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhipster.mdl.web.rest.TestUtil;

public class MdlUserDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MdlUserDTO.class);
        MdlUserDTO mdlUserDTO1 = new MdlUserDTO();
        mdlUserDTO1.setId(1L);
        MdlUserDTO mdlUserDTO2 = new MdlUserDTO();
        assertThat(mdlUserDTO1).isNotEqualTo(mdlUserDTO2);
        mdlUserDTO2.setId(mdlUserDTO1.getId());
        assertThat(mdlUserDTO1).isEqualTo(mdlUserDTO2);
        mdlUserDTO2.setId(2L);
        assertThat(mdlUserDTO1).isNotEqualTo(mdlUserDTO2);
        mdlUserDTO1.setId(null);
        assertThat(mdlUserDTO1).isNotEqualTo(mdlUserDTO2);
    }
}
