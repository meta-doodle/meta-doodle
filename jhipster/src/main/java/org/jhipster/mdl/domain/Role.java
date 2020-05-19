package org.jhipster.mdl.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Role.
 */
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MdlUser> users = new HashSet<>();

    @OneToMany(mappedBy = "role")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WorkflowInstance> workflowInstances = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public Role role(String role) {
        this.role = role;
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<MdlUser> getUsers() {
        return users;
    }

    public Role users(Set<MdlUser> mdlUsers) {
        this.users = mdlUsers;
        return this;
    }

    public Role addUser(MdlUser mdlUser) {
        this.users.add(mdlUser);
        mdlUser.setRole(this);
        return this;
    }

    public Role removeUser(MdlUser mdlUser) {
        this.users.remove(mdlUser);
        mdlUser.setRole(null);
        return this;
    }

    public void setUsers(Set<MdlUser> mdlUsers) {
        this.users = mdlUsers;
    }

    public Set<WorkflowInstance> getWorkflowInstances() {
        return workflowInstances;
    }

    public Role workflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
        return this;
    }

    public Role addWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.add(workflowInstance);
        workflowInstance.setRole(this);
        return this;
    }

    public Role removeWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstances.remove(workflowInstance);
        workflowInstance.setRole(null);
        return this;
    }

    public void setWorkflowInstances(Set<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        return id != null && id.equals(((Role) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Role{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            "}";
    }
}
