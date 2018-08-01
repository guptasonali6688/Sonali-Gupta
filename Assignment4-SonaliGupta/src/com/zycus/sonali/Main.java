package com.zycus.sonali;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement st = conn.createStatement();
			//st.execute("create table customer(id int primary key, firstname varchar(20), lastname varchar(20), email varchar(20))");
			//st.execute("create table card(id int primary key, expiry Date, customer_id int, balance float, creditLimit int, FOREIGN KEY(customer_id) REFERENCES customer(id))");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
			CustomerDAO customerdao=new CustomerDAO();
		/*
			//Creating new customer record
		
			customerdao.create(new Customer(1,"sonali","Gupta","sg@gmail.com"));
			customerdao.create( new Customer(2,"Rupali","Patil","rg@gmail.com"));
		*/

			//Displaying the first customer record using id 
			System.out.println("Displaying the first record of Customer");
			System.out.println(customerdao.findById(1).toString());
			
			//Displaying all the records of Customer 
			System.out.println("Displaying all records of Customer");
			List<Customer> list=customerdao.findAll();
			Iterator<Customer> it= list.iterator();
			while(it.hasNext()){
				System.out.println(it.next().toString());
			} 
			
			CardDAO carddao = new CardDAO();
			/*
			carddao.create(new Card(1, java.sql.Date.valueOf("2018-03-01"), 1, 20000.45f, 20));
			carddao.create(new Card(2, java.sql.Date.valueOf("2018-03-06"), 2, 20050.45f, 20));
			*/
			
			//Display second record of Card 
			System.out.println("Displaying the second record of Card");
			System.out.println(carddao.findById(2).toString());
			//Display all records of Card 
			System.out.println("Displaying the records of Card");
			List<Card> listc=carddao.findAll();
			Iterator<Card> itr= listc.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next().toString());
			} 

	}
}
