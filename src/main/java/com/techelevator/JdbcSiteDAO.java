package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcSiteDAO implements SiteDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> listAvailableSites() {
		// TODO Auto-generated method stub
		List<Site> siteList = new ArrayList<>();
		
		String sqlSelectAllCampgrounds = "SELECT * FROM park;";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlSelectAllCampgrounds);
		
		while(rows.next()) {
			Site site = new Site();
			site.setSiteId(rows.getLong("site_id"));
			site.setSiteNumber(rows.getString("site_number"));
			siteList.add(site);
		}
		
		return siteList;
	}

}
