package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import com.techelevator.Menu;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Reservation createNewReservation(String customerName) {
		
		Scanner scanner = new Scanner(System.in);
		PrintWriter output = new PrintWriter(System.out);
		

		//InputStream input = new InputStream(scanner);
		
		//OutputStream output = new OutputStream();
		
		//Menu makeReservationMenu = new Menu(input, output);

//		InputStream input = new InputStream(scanner);
//		
//		OutputStream output = new OutputStream();
		
//		Menu makeReservationMenu = new Menu(input, output);

		
		String reservationFromDate;
		
		String reservationToDate;
		
		String nextIdSequenceValue = "SELECT nextVal ('reservation_reservation_id_seq')";
		
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(nextIdSequenceValue);
		
		rowset.next();
		
		long reservationId = rowset.getInt(1);
		
		String sqlCreateNewReservation = "INSERT INTO reservation(reservation_id, name) VALUES (?, ?)";
		
		jdbcTemplate.update(sqlCreateNewReservation, customerName);
		
		Reservation newReservation = new Reservation();
	 
		newReservation.setCustomerName(customerName);
		
		newReservation.setReservationId(reservationId);
		

		//newReservation.setReservedFromDate(reservationFromDate);
		
		//newReservation.setReservedToDate(reservationToDate);

//		newReservation.setReservedFromDate(reservationFromDate);
//		
//		newReservation.setReservedToDate(reservationToDate);

		
		return newReservation;
		
	}
	
	
	@Override //CREATED BASED ON JBDCDepartmentDAO "getDepartmentById(Long id)" for testing purposes 
	public Reservation displayExistingReservation (Long reservation_id) {
		
		String sqlGetReservationById = "SELECT reservation_id, name, site_id, from_date, to_date FROM reservation WHERE id = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetReservationById, reservation_id);
		
		Reservation res = null;
		
		if(result.next()) {
			
			res = new Reservation();
			
			res.setReservationId(result.getLong("reservation_id"));
			res.setCustomerName(result.getString("name"));
			res.setReservationTableSiteId(result.getString("site_id"));
			res.setReservedFromDate(result.getString("from_date"));
			res.setReservedToDate(result.getString("to_date"));
			
			return res;
			
		} else {
	
		return null;
		}
	}
	
}





