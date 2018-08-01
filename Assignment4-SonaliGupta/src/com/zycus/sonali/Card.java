package com.zycus.sonali;

import java.sql.Date;

public class Card {
	private int id;
	private Date expiry;
	private int customer_id;
	private float balance;
	private int creditLimit;
	public Card() {
		super();
	}
	public Card(int id, Date expiry, int customer_id, float balance, int creditLimit) {
		super();
		this.id = id;
		this.expiry = expiry;
		this.customer_id = customer_id;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", expiry=" + expiry + ", customer_id=" + customer_id + ", balance=" + balance
				+ ", creditLimit=" + creditLimit + "]";
	}
	
	
	
	
}
