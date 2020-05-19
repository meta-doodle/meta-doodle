package org.jhipster.mdl.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class RoleMapperTest {

    private RoleMapper roleMapper;

    @BeforeEach
    public void setUp() {
        roleMapper = new RoleMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(roleMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(roleMapper.fromId(null)).isNull();
    }
}
