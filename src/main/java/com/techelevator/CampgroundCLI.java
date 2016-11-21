package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CampgroundCLI {
	
/* 1. DECLARING MENU OPTION CONSTANTS ABOVE MAIN METHOD ------------------------------------------------------------------ */
	
	private static final String MAIN_MENU_OPTION_VIEW_ALL_PARKS = "VIEW All Parks";
	private static final String MAIN_MENU_SEARCH_PARKS_BY_NAME = "SEARCH Parks By Name";
	private static final String MAIN_MENU_SEARCH_CAMPGROUNDS_BY_PARK_NAME = "SEARCH Campgrounds By Park";
	private static final String MAIN_MENU_OPTION_EXIT_PROGRAM = "EXIT The National Parks Service Application";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_VIEW_ALL_PARKS,
																	MAIN_MENU_SEARCH_PARKS_BY_NAME,
																	MAIN_MENU_SEARCH_CAMPGROUNDS_BY_PARK_NAME,
																	MAIN_MENU_OPTION_EXIT_PROGRAM };	
	
	private static final String SELECT_A_PARK_MENU_ACADIA = "Acadia National Park";
	private static final String SELECT_A_PARK_MENU_ARCHES = "Arches National Park";
	private static final String SELECT_A_PARK_MENU_CUYAHOGA_VALLEY = "Cuyahoga Valley National Park";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT The National Parks Service Application";
	private static final String[] SELECT_A_PARK_MENU_OPTONS = new String[] { SELECT_A_PARK_MENU_ACADIA ,
																			SELECT_A_PARK_MENU_ARCHES,
																			SELECT_A_PARK_MENU_CUYAHOGA_VALLEY,
																			MAIN_MENU_OPTION_EXIT };

/* 2. DECLARING PRIVATE VARIABLES BEFORE MAIN METHOD ------------------------------------------------------------------*/
	private Menu menu;
	private ParkDAO parkDAO;
	private CampgroundDAO campgroundDAO;
	private SiteDAO siteDAO;
	private ReservationDAO reservationDAO;
	
/* 3. MAIN METHOD ------------------------------------------------------------------ */
/* 4. CLI OBJECT "APPLICATION" WITH .RUN() METHOD ------------------------------------------------------------------ */
/* 5. CREATE COMMAND LINE INTERFACE (CLI) CONSTRUCTOR ------------------------------------------------------------------ */
/* 6. SET-UP DATABASE CONNECTION (DATASOURCE) ------------------------------------------------------------------ */
	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}
		
/* 7. CREATE DAO CLASS OBJECTS WITH DATASOURCE ARGUMENT ------------------------------------------------------------------ */
	public CampgroundCLI(DataSource dataSource) {
		parkDAO = new JdbcParkDAO(dataSource);
		campgroundDAO = new JdbcCampgroundDAO(dataSource);
		siteDAO = new JdbcSiteDAO(dataSource);
		reservationDAO = new JdbcReservationDAO(dataSource);
		this.menu = new Menu(System.in, System.out);
	}
	
// START MENU = Greeting and list_all_park
/* 8. DISPLAY BANNER AND MAIN MENU (OPTIONS DIRECT TO HANDLE METHODS) ------------------------------------------------------------------ */
	private void run() {
		displayApplicationBanner();	
		while(true) {
			printHeading("NATIONAL PARKS DIRECTORY");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_VIEW_ALL_PARKS)) {
				handleListAllParks();
			} else if(choice.equals(MAIN_MENU_SEARCH_PARKS_BY_NAME)) {
				handleSearchParksByName();
			} else if(choice.equals(MAIN_MENU_SEARCH_CAMPGROUNDS_BY_PARK_NAME)) {
				handleSearchCampgroundsByPark();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}
	
/* MAIN MENU LIST ALL PARKS (OPTION 1) METHODS ------------------------------------------------------------------ */

	private void parksList(List<Park> parks) {
		System.out.println();
		if(parks.size() > 0) {
			for(Park park : parks) {
				System.out.println(park.getParkName() + " National Park");
			}
		} else {
			System.out.println("\nERROR: Name not found.");
		}
	}
	
	private void handleListAllParks() {
		printHeading("NATIONAL PARKS");
		List<Park> allParks = parkDAO.listAllParks();
		parksList(allParks);
	}

/* MAIN MENU SEARCH PARKS BY NAME (OPTION 2) METHODS ------------------------------------------------------------------ */
	
	private void handleSearchParksByName() {
		printHeading("SEARCH PARKS BY NAME");
		String parkNameSearch = getUserInput("ENTER Park Name:");
		List<Park> parks = parkDAO.searchParksByName(parkNameSearch);
		parkDAO.getParkInfo(parks);
		}
	
/* MAIN MENU SEARCH FOR CAMPGROUNDS (OPTIONS 3) METHODS */
	
	private void handleSearchCampgroundsByPark() {
		// TODO Auto-generated method stub
		printHeading("SEARCH CAMPGROUNDS BY PARK");
		String parkName = getUserInput("ENTER Park Name:");
		parkDAO.listCampgroundsInPark(parkName);
	}

/* MAIN MENU SELECT A PARK (OPTION ?): UNIMPLEMENTED ------------------------------------------------------------------ */
	
//	private void handleSelectPark() {
//		while(true) {
//			printHeading("SELECT A PARK");
//			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//			if(choice.equals(MAIN_MENU_OPTION_VIEW_ALL_PARKS)) {
//				handleListAllParks();
//			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
//				System.exit(0);
//			}
//		}
//	}
	
/* 12. PRINT HEADING HELPER METHOD ------------------------------------------------------------------ */
	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
/* 13. GET USER INPUT PROMPT METHOD ------------------------------------------------------------------ */
	private String getUserInput(String prompt) {
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}

/* 14. DISPLAY APPLICATION BANNER METHOD ------------------------------------------------------------------ */
	private void displayApplicationBanner() {
		
		System.out.println("::::    :::     ::: ::::::::::: ::::::::::: ::::::::  ::::    :::     :::     :::             :::::::::     :::     :::::::::  :::    ::: ::::::::        ::::::::  :::::::::: :::::::::  :::     ::: ::::::::::: ::::::::  :::::::::: ");
		System.out.println(":+:+:   :+:   :+: :+:   :+:         :+:    :+:    :+: :+:+:   :+:   :+: :+:   :+:             :+:    :+:  :+: :+:   :+:    :+: :+:   :+: :+:    :+:      :+:    :+: :+:        :+:    :+: :+:     :+:     :+:    :+:    :+: :+:        ");    
		System.out.println(":+:+:+  +:+  +:+   +:+  +:+         +:+    +:+    +:+ :+:+:+  +:+  +:+   +:+  +:+             +:+    +:+ +:+   +:+  +:+    +:+ +:+  +:+  +:+             +:+        +:+        +:+    +:+ +:+     +:+     +:+    +:+        +:+        ");
		System.out.println("+#+ +:+ +#+ +#++:++#++: +#+         +#+    +#+    +:+ +#+ +:+ +#+ +#++:++#++: +#+             +#++:++#+ +#++:++#++: +#++:++#:  +#++:++   +#++:++#++      +#++:++#++ +#++:++#   +#++:++#:  +#+     +:+     +#+    +#+        +#++:++#   ");  
		System.out.println("+#+  +#+#+# +#+     +#+ +#+         +#+    +#+    +#+ +#+  +#+#+# +#+     +#+ +#+             +#+       +#+     +#+ +#+    +#+ +#+  +#+         +#+             +#+ +#+        +#+    +#+  +#+   +#+      +#+    +#+        +#+        ");
		System.out.println("#+#   #+#+# #+#     #+# #+#         #+#    #+#    #+# #+#   #+#+# #+#     #+# #+#             #+#       #+#     #+# #+#    #+# #+#   #+# #+#    #+#      #+#    #+# #+#        #+#    #+#   #+#+#+#       #+#    #+#    #+# #+#        ");
		System.out.println("###    #### ###     ### ###     ########### ########  ###    #### ###     ### ##########      ###       ###     ### ###    ### ###    ### ########        ########  ########## ###    ###     ###     ########### ########  ########## ");
		System.out.println("");
	}
}