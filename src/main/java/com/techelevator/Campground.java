package com.techelevator;

public class Campground {

	// In the other exercises this week, the simply .java classes (i.e., classes without DAO or JDBC in them) 
	// ... contain the private member variables and their getter/setter methods
	// They also didn't extend or implement anything
		
		private Long campgroundId; // PK with FK in site.java
		// NOTE: FK parkId ---> Park.java PK parkId
		private String campgroundName;
		 private String openFromMM;
		 private String openToMM;
		private double dailyFee;
		
		public Long getCampgroundId() {
			return campgroundId;
		}
		
		public void setCampgroundId(Long campgroundId) {
			this.campgroundId = campgroundId;
		}
	
		
		public String getCampgroundName() {
			return campgroundName;
		}

		public void setCampgroundName(String campgroundName) {
			this.campgroundName = campgroundName;
		}

		public String getOpenFrom() {
			return openFromMM;
		}
		
		public void setOpenFrom(String openFrom) {
			this.openFromMM = openFrom;
		}
		
		public String getToFrom() {
			return openToMM;
		}
		
		public void setOpenTo(String openTo) {
			this.openToMM = openTo;
		}
		
		public double getDailyFee() {
			return dailyFee;
		}
		
		public void setDailyFee(double dailyFee) {
			this.dailyFee = dailyFee;
		}
}
