package com.techelevator;

import java.time.LocalDate;

public class Reservation {
	
	// In the other exercises this week, the simply .java classes (i.e., classes without DAO or JDBC in them) 
	// ... contain the private member variables and their getter/setter methods
			 
			private Long reservationId; // PK reservationId == confirmation ID to return to customer 
			// FK siteId ---> Site.java PK siteId
			private String reservationTableSiteId;
			private String customerName;
			private String reservedFromDate; // equivalent to from_date in Reservation table
			private String reservedToDate; // equivalent to to_date in Reservation table
			private LocalDate reservationMadeOn; // equivalent to create_date in Reservation table
			private String reservationRange;
			
			public Long getReservationId() {
			
				return reservationId;
			}
			
			public void setReservationId(Long reservationId) {
				this.reservationId = reservationId;
			}
			
			public String getCustomerName() {
				return customerName;
			}

			public void setCustomerName(String familyName) {
				customerName = familyName + " Family Reservation";
			}
			
			public String getReservedFromDate() {
				return reservedFromDate;
			}
			
			public void setReservedFromDate(String reservedFromDate) {
				this.reservedFromDate = reservedFromDate;
			}
			
			public String getReservedToDate() {
				return reservedToDate;
			}
			
			public void setReservedToDate(String reservedToDate) {
				this.reservedToDate = reservedToDate;
			}
			
			public String getReservationRange() {
				reservationRange = reservedFromDate + " - " + reservedToDate;
				return reservationRange;
			}
			
			public void setReservationRange(String reservedFromDate, String reservedToDate) {
				this.reservedFromDate = reservedFromDate;
				this.reservedToDate = reservedToDate;
				reservationRange = reservedFromDate + " to " + reservedToDate;
			}
			// Maybe add total numbers of days booked to the confirmation message?
			
			public LocalDate getReservationMadeOn() {
				return reservationMadeOn;
			}
			
			public void setReservationMadeOn(LocalDate reservationMadeOn) {
				this.reservationMadeOn = reservationMadeOn;
			}

			public String getReservationTableSiteId() {
				return reservationTableSiteId;
			}

			public void setReservationTableSiteId(String reservationTableSite) {
				this.reservationTableSiteId = reservationTableSite;
			}

			public void setReservationRange(String reservationRange) {
				this.reservationRange = reservationRange;
			}

}
