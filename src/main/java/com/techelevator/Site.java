package com.techelevator;

public class Site {

	// In the other exercises this week, the simply .java classes (i.e., classes without DAO or JDBC in them) 
	// ... contain the private member variables and their getter/setter methods
		
		private Long siteId; // PK with FK in reservation.java // siteId = siteNumber + campgroundId ? 
		// FK campgroundId ---> Campground.java PK camgroundId
		private String siteNumber;
		private boolean isSiteAvailable;
		// BONUS: private int maxOccupancy;
		// BONUS: private boolean isHandiAccessible;
		// BONUS: private int maxRvLength;
		// BONUS: private boolean hasUtilities;

		public Long getSiteId() {
			return siteId;
		}
		
		public void setSiteId(Long siteId) {
			this.siteId = siteId;
		}
		
		public String getSiteNumber() {
			return siteNumber;
		}

		public void setSiteNumber(String siteNumber) {
			this.siteNumber = siteNumber;
		}
		
		public boolean getIsSiteAvailable() {
			return isSiteAvailable;
		}
		
//		public int getMaxOccupancy() {
//			return maxOccupancy;
//		}
//		
//		public void setMaxOccupancy(int maxOccupancy) {
//			this.maxOccupancy = maxOccupancy;
//		}
//		
//		public boolean getIsHandiAccessible() {
//			return isHandiAccessible;
//		}
//		
//		public void setIsHandiAccessible(boolean isHandiAccessible) {
//			this.handiAccessible = isHandiAccessible ;
//		}
//		
//		public boolean getMaxRvLength() {
//			return maxRvLength;
//		}
//		
//		public void setMaxRvLength(int maxRvLength) {
//			this.maxRvLength = maxRvLength;
//		}
//		
//		public boolean getHasUtilities() {
//			return hasUtilities;
//		}
//		
//		public void setHasUtilities(boolean hasUtilities) {
//			this.hasUtilities = hasUtilities;
//		}
	
}
