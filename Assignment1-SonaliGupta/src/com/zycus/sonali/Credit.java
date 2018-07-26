package com.zycus.sonali;

public class Credit extends Card{

	private float creditLimit;
	private int pointsEarned;
	public Credit(CardType cardtype, long actNum, String PAN, String name, long phoneNum, float interestRate,
			float creditLimit, int pointsEarned) {
		super(cardtype, actNum,phoneNum, name, PAN);
		this.creditLimit = creditLimit;
		this.pointsEarned = pointsEarned;
		
	}

}
