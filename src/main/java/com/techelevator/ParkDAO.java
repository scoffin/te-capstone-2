package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public interface ParkDAO {
	
	public List<Park> listAllParks();

	public void getParkInfo(List<Park> parks);

	public List<Park> searchParksByName(String parkNameSearch);

	public List<Campground> listCampgroundsInPark(String parkName);
	
	// BONUS: return all reservations park-wide
	
	// Add create & update methods, etc. later

}
