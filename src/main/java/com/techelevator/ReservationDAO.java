package com.techelevator;

// import java.util.List;

public interface ReservationDAO {
	
	public Reservation createNewReservation(String customerName);
	
	public Reservation displayExistingReservation(Long reservationId); // CREATED BASED ON JBDCDepartmentDAO "getDepartmentById(Long id)" for testing purposes 

}
