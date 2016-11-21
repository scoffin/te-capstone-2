package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Campground;

public class JdbcCampgroundDAO implements CampgroundDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campground> listAllCampgrounds() {
		// TODO Auto-generated method stub
		List<Campground> campgroundList = new ArrayList<>();
		
		String sqlSelectAllCampgrounds = "SELECT * FROM campground;";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectAllCampgrounds);
		
		while(rows.next()) {
			Campground campground = new Campground();
			campground.setCampgroundId(rows.getLong("campground_id"));
			campground.setCampgroundName(rows.getString("name"));
			campgroundList.add(campground);
		}
		
		return campgroundList;
	}

}
