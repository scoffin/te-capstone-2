package com.techelevator;

public class Park {

	// In the other exercises this week, the simply .java classes (i.e., classes without DAO or JDBC in them) 
	// ... contain the private member variables and their getter/setter methods
	
	private Long parkId; //PK parkId <--- Campground.java parkId FK
	private String parkName;
	private String parkLocation;
	private String establishedDate;
	private String surfaceArea;
	private String parkVisitors;
	private String parkDescription;

	public Long getParkId() {
		return parkId;
	}
	
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkLocation() {
		return parkLocation;
	}
	
	public void setParkLocation(String parkLocation) {
		this.parkLocation = parkLocation;
	}
	
	public String getSurfaceArea() {
		return surfaceArea;
	}
	
	public void setSurfaceArea(String surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	public String getParkVisitors() {
		return parkVisitors;
	}
	
	public void setParkVisitors(String parkVisitors) {
		this.parkVisitors = parkVisitors;
	}
	
	public String getParkDescription() { 
		return parkDescription;
	}
	
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}

	public String getEstablishedDate() {
		return establishedDate;
	}
	
	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}
	
}