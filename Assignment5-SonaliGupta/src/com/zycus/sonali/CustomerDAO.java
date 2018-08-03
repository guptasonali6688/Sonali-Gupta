package com.zycus.sonali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CustomerDAO implements DAO<Customer> {
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from customerbank where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO customerbank (title, firstname, lastname, age, Date) values(?, ?, ?, ?,?)";
	private static final String SEL_CUST = "select * from customerbank";
	
	@Override
	public void create(Customer object) {
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			ps.setString(1, object.getTitle());
			ps.setString(2, object.getFirstname());
			ps.setString(3, object.getLastname());
			ps.setInt(4, object.getAge());
			ps.setDate(5, object.getDate());
			System.out.println("Success:" +ps.executeUpdate());
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
				c.setFirstname(rs.getString(2));
				c.setLastname(rs.getString(3));
				c.setAge(rs.getInt(4));
				c.setDate(rs.getDate(5));
			}

			return c;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	private static Customer convertResult(ResultSet rs) throws SQLException{
		int id = rs.getInt(1);
		String title = rs.getString(2);
		String firstname = rs.getString(3);
		String lastname = rs.getString(4);
		int age = rs.getInt(5);
		Date date = rs.getDate(6);
		
		return new Customer(id, title, firstname, lastname, age, (java.sql.Date) date);
	}

}

