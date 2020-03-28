package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MdlUserMapperTest {

    private MdlUserMapper mdlUserMapper;

    @BeforeEach
    public void setUp() {
        mdlUserMapper = new MdlUserMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(mdlUserMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(mdlUserMapper.fromId(null)).isNull();
    }
}
