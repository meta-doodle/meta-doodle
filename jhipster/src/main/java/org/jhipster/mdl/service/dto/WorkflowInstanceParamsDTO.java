package org.jhipster.mdl.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class WorkflowInstanceParamsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long wfModelId;
	
	private Long creatorId;
	
	private Set<String> guests;

	public Long getWfModelId() {
		return wfModelId;
	}

	public void setWfModelId(Long wfModelId) {
		this.wfModelId = wfModelId;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Set<String> getGuests() {
		return guests;
	}

	public void setGuests(Set<String> guests) {
		this.guests = guests;
	}
	
	@Override
    public String toString() {
        return "WorkflowInstanceParamsDTO{" +
            "wfModelId=" + getWfModelId() +
            ", creatorId=" + getCreatorId() +
            "}";
    }
	
}
