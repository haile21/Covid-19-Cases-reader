package com.addistutor.covid19CaseRecord.model;

public class CaseLocation {
	private String state;
	private String country;
	private String latitude;
	//private String country;
	private int   recent_total_Case;
	private int  diff;
	
	public int getDiff() {
		return diff;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setDiff(int diff) {
		this.diff = diff;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getRecent_total_Case() {
		return recent_total_Case;
	}
	public void setRecent_total_Case(int recent_total_Case) {
		this.recent_total_Case = recent_total_Case;
	}
	@Override
	public String toString() {
		return "CaseLocation [state=" + state + ", country=" + country + ", recent_total_Case=" + recent_total_Case
				+ "]";
	}
}
