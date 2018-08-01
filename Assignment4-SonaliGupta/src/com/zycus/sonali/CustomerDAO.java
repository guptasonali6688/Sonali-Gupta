package com.zycus.sonali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CustomerDAO implements DAO<Customer> {
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from customer where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO customer(id, firstname, lastname, email) values(?, ?, ?, ?)";
	private static final String SEL_CUST = "select * from customer";
	
	@Override
	public void create(Customer object) {
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			ps.setInt(1, object.getId());
			ps.setString(2, object.getFirstName());
			ps.setString(3, object.getLastName());
			ps.setString(4, object.getEmail());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SEL_CUST);
			while(rs.next()) {
				Customer customer = convertResult(rs);
				customerList.add(customer);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}		
		return customerList;
	}

	@Override
	public Customer findById(int id) {		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID_CUSTOMER);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Customer c = new Customer();
			if(rs.next()) {
				c.setId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmail(rs.getString(4));
			}

			return c;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	private static Customer convertResult(ResultSet rs) throws SQLException{
		int id = rs.getInt(1);
		String firstname = rs.getString(2);
		String lastname = rs.getString(3);
		String email = rs.getString(4);
		
		return new Customer(id, firstname, lastname, email);
	}

}
