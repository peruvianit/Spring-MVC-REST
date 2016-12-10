package it.peruvianit.dto;

import java.io.Serializable;

public class ExecuteTimeDTO implements Serializable{
	private static final long serialVersionUID = -3341966683533628375L;
	
	Long startTime;
	Long endTime;
	Long executeTime;
	
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(final Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(final Long endTime) {
		this.endTime = endTime;
	}
	public Long getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(final Long executeTime) {
		this.executeTime = executeTime;
	}
}
