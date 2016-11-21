package com.techelevator;

import java.util.List;

import com.techelevator.Campground;

public interface CampgroundDAO {
	
	// In the exercises from last week,the DAO interfaces were extended by JDCB classes
	// They use the object type of the class (non-DAO) that they share their name with
	// They contained a handful of public methods and nothing else (mostly CRUD operations)
	
		public List<Campground> listAllCampgrounds();
		
		//		public void updateDailyFee();
		
		// We can write create and update methods later
		
}
