package com.zycus.sonali;

import java.sql.Date;

public class Customer {
	private int id;
	private String title, firstname, lastname;
	private int age;
	private Date date;
	

	public Customer() {
		super();
	}
	
	public Customer(String title, String firstname, String lastname, int age, Date date) {
		super();
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.date = date;
	}


	public Customer(int id, String title, String firstname, String lastname, int age, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", title=" + title + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", date=" + date + "]";
	}
	
	
	
	
}
