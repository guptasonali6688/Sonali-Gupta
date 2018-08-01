package com.zycus.sonali;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CardDAO implements DAO<Card> {

	private static final String INSERT_CARD = "INSERT INTO Card(id, expiry, customer_id, balance, creditLimit) values(?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_ID_CARD = "select * from card where id = ?";
	private static final String SEL_CARD = "select * from card";
	@Override
	public void create(Card object) {
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(INSERT_CARD);
			ps.setInt(1, object.getId());
			ps.setDate(2, object.getExpiry());
			ps.setInt(3, object.getCustomer_id());
			ps.setFloat(4,object.getBalance());
			ps.setInt(5, object.getCreditLimit());
			ps.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Card> findAll() {
		List<Card> cardList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SEL_CARD);
			while(rs.next()) {
				Card card = convertResult(rs);
				cardList.add(card);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}		
		return cardList;		
	}

	private static Card convertResult(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		Date expiry = rs.getDate(2);
		int customer_id = rs.getInt(3);
		float balance = rs.getFloat(4);
		int creditbalance = rs.getInt(5);
		
		return new Card(id, expiry, customer_id, balance, creditbalance);
		
		
	}

	@Override
	public Card findById(int id) {
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID_CARD);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Card c = new Card();
			if(rs.next()) {
				c.setId(rs.getInt(1));
				c.setExpiry(rs.getDate(2));
				c.setCustomer_id(rs.getInt(3));
				c.setBalance(rs.getFloat(4));
				c.setCreditLimit(rs.getInt(5));
			}

			return c;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
