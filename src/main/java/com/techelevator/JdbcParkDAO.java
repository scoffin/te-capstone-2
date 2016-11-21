package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.ParkDAO;

public class JdbcParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcParkDAO() {
		
	}

	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> listAllParks() {
		// TODO Auto-generated method stub
		
	List<Park> allParksList = new ArrayList<>();
		
		String sqlSelectAllParks = "SELECT * FROM park;";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while(rows.next()) {
			Park park = new Park();
			park.setParkId(rows.getLong("park_id"));
			park.setParkName(rows.getString("name"));
			allParksList.add(park);
		}
		
		return allParksList;
	}
	
	@Override
	public void getParkInfo(List<Park> parks) {
		System.out.println();
		if (parks.size() > 0) {
			for (Park park : parks) {
				System.out.println("✯ ✯ ✯ " + park.getParkName().toUpperCase() + " NATIONAL PARK ✯ ✯ ✯ \n");
				System.out.println("❂ U.S. LOCATION: "+park.getParkLocation());
				String estMonth = park.getEstablishedDate().substring(5, 7);
				String estDay = park.getEstablishedDate().substring(8, park.getEstablishedDate().length());
				String estYear = park.getEstablishedDate().substring(0,  4);
				System.out.println("❂ DATE ESTABLISHED: " + estMonth + "/" + estDay + "/" + estYear);
				System.out.println("❂ TERRITORY: "+park.getSurfaceArea() + " sq. miles");
				System.out.println("❂ VISITORSHIP: "+park.getParkVisitors() + " visitors to date this season");
				System.out.println("❂ DESCRIPTION: "+park.getParkDescription());
				}
			} else {
				System.out.println("\nNO RESULTS");
			}
	}

	@Override
	public List<Park> searchParksByName(String parkNameSearch) {
			List<Park> parks = new ArrayList<>();

			String sqlSelectParkById = "SELECT * FROM park WHERE upper(name) LIKE ? OR lower(name) LIKE ? OR name LIKE ?"
										+ "ORDER BY name";
			SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectParkById, "%" + parkNameSearch + "%", "%" + parkNameSearch + "%","%" + parkNameSearch + "%");

			while(rows.next()){
			    Park park = new Park();
			    park.setParkName(rows.getString("name"));
			    park.setParkLocation(rows.getString("location"));
			    park.setEstablishedDate(rows.getString("establish_date"));
			    park.setSurfaceArea(rows.getString("area"));
			    park.setParkVisitors(rows.getString("visitors"));
			    park.setParkDescription(rows.getString("description"));
			    parks.add(park);
			}
			return parks;
			}

	@Override
	public List<Campground> listCampgroundsInPark(String parkName) {
		// TODO Auto-generated method stub
		List<Campground> parkCampgroundList = new ArrayList<>();
	
		String sqlSelectParkCampgrounds = "SELECT campground.name, campground.campground_id, campground.open_from_mm, campground.open_to_mm, campground.daily_fee"
										+ "FROM park"
										+ "JOIN campground ON park.park_id = campground.park_id"
										+ "WHERE park.name = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectParkCampgrounds, parkName);
	
		while(rows.next()) {
			Campground campground = new Campground();
			campground.setCampgroundName(rows.getString("name"));
			campground.setCampgroundId(rows.getLong("campground_id"));
			campground.setOpenFrom(rows.getString("open_from_mm"));
			campground.setOpenTo(rows.getString("open_to_mm"));
			campground.setDailyFee(rows.getDouble("daily_fee"));
			parkCampgroundList.add(campground);
		}
		
		return parkCampgroundList;
	}
}
	
//	public Park getAcadiaInfo(){ 
//		Park AcadiaParksInfo = new Park();
//		String sqlSelectAllParkInfo = "SELECT * FROM park WHERE name = Acadia;";
//		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectAllParkInfo);
//	
//	
//	while(rows.next()) {
//		Park newPark = new Park();
//		newPark.setParkName("name");
//		newPark.setParkLocation("location");
//		newPark.setEstablishDate("establish_date");
//		newPark.setSurfaceArea("area");
//		newPark.setParkVisitors("visitors");
//		newPark.setParkDescription("description");
