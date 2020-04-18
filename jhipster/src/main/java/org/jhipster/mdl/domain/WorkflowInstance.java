package org.jhipster.mdl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * A WorkflowInstance.
 */
@Entity
@Table(name = "workflow_instance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WorkflowInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(unique = true)
    private WorkflowInstanceState state;

    @OneToMany(mappedBy = "workflowInstance")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("workflowInstances")
    private WorkflowModel wfModel;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "workflow_instance_guests",
               joinColumns = @JoinColumn(name = "workflow_instance_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "guests_id", referencedColumnName = "id"))
    private Set<MdlUser> guests = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("creatorWfInstances")
    private MdlUser creator;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public WorkflowInstance description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkflowInstanceState getState() {
        return state;
    }

    public WorkflowInstance state(WorkflowInstanceState workflowInstanceState) {
        this.state = workflowInstanceState;
        return this;
    }

    public void setState(WorkflowInstanceState workflowInstanceState) {
        this.state = workflowInstanceState;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public WorkflowInstance answers(Set<Answer> answers) {
        this.answers = answers;
        return this;
    }

    public WorkflowInstance addAnswers(Answer answer) {
        this.answers.add(answer);
        answer.setWorkflowInstance(this);
        return this;
    }

    public WorkflowInstance removeAnswers(Answer answer) {
        this.answers.remove(answer);
        answer.setWorkflowInstance(null);
        return this;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public WorkflowModel getWfModel() {
        return wfModel;
    }

    public WorkflowInstance wfModel(WorkflowModel workflowModel) {
        this.wfModel = workflowModel;
        return this;
    }

    public void setWfModel(WorkflowModel workflowModel) {
        this.wfModel = workflowModel;
    }

    public Set<MdlUser> getGuests() {
        return guests;
    }

    public WorkflowInstance guests(Set<MdlUser> mdlUsers) {
        this.guests = mdlUsers;
        return this;
    }

    public WorkflowInstance addGuests(MdlUser mdlUser) {
        this.guests.add(mdlUser);
        mdlUser.getWorkflowInstances().add(this);
        return this;
    }

    public WorkflowInstance removeGuests(MdlUser mdlUser) {
        this.guests.remove(mdlUser);
        mdlUser.getWorkflowInstances().remove(this);
        return this;
    }

    public void setGuests(Set<MdlUser> mdlUsers) {
        this.guests = mdlUsers;
    }

    public MdlUser getCreator() {
        return creator;
    }

    public WorkflowInstance creator(MdlUser mdlUser) {
        this.creator = mdlUser;
        return this;
    }

    public void setCreator(MdlUser mdlUser) {
        this.creator = mdlUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove
    
    public Optional<MdlUser> findMdlUserByLogin(String login){
    	for (MdlUser mdlUser : guests) {
    		User user = mdlUser.getUser();
			if(user != null && user.getLogin().equalsIgnoreCase(login)) {
				return Optional.of(mdlUser);
			}
		}
    	return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkflowInstance)) {
            return false;
        }
        return id != null && id.equals(((WorkflowInstance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "WorkflowInstance{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
