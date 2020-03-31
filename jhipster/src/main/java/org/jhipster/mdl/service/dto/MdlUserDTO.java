package org.jhipster.mdl.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.mdl.domain.MdlUser} entity.
 */
public class MdlUserDTO implements Serializable {

    private Long id;


    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MdlUserDTO mdlUserDTO = (MdlUserDTO) o;
        if (mdlUserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mdlUserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MdlUserDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            "}";
    }
}
