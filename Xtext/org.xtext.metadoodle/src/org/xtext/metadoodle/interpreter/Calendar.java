package org.xtext.metadoodle.interpreter;

public class Calendar extends UserInteraction {

	private ID id;
	private InteractionType it;
	private String startDate, endDate, granularity;

	public Calendar(
			ID id, 
			InteractionType it, 
			String startDate, 
			String endDate, 
			String granularity) {
		this.id = id;
		this.it = it;
		this.startDate = startDate;
		this.endDate = endDate;
		this.granularity = granularity;
	}
	
	@Override
	public ID getStepID() {
		return this.id;
	}

	@Override
	public InteractionType getType() {
		return this.it;
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
}
