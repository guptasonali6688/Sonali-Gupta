package com.zycus.sonali;

public abstract class Card {
	private long cardNo, contact;
	private String holderName, PAN;
	private CardType cardtype;
	
	//Constructor
	public Card(CardType cardtype,long cardNo, long contact, String holderName, String PAN) {
		super();
		this.cardtype = cardtype;
		this.cardNo = cardNo;
		this.contact = contact;
		this.holderName = holderName;
		this.PAN = PAN;
	}
	//getter and setter methods
	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public CardType getCardtype() {
		return cardtype;
	}

	public void setCardtype(CardType cardtype) {
		this.cardtype = cardtype;
	}

	//toString() method
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", contact=" + contact + ", holderName=" + holderName + ", PAN=" + PAN
				+ ", cardtype=" + cardtype + "]";
	}
	
	
}
