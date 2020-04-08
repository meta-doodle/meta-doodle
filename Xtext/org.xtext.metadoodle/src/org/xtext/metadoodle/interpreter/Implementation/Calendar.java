package org.xtext.metadoodle.interpreter.Implementation;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class Calendar extends UserInteraction {

	private String startDate, endDate, granularity;

	public Calendar(
			ID id, 
			String comment, 
			InteractionType it, 
			String startDate, 
			String endDate, 
			String granularity) {
		super(id, comment, it);
		this.startDate = startDate;
		this.endDate = endDate;
		this.granularity = granularity;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public String getGranularity() {
		return this.granularity;
	}

	@Override
	protected String more() {
		// TODO Auto-generated method stub
		return null;
	}
}
