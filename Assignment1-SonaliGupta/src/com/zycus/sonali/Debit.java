package com.zycus.sonali;

public class Debit extends Card{

	private float maxWithdrawal;
	private int accLinked;
	public Debit(CardType cardtype, long actNum, String PAN, String name, long phoneNum, float maxWtihdrawal,
			int accLinked) {
		super(cardtype, actNum, phoneNum, name, PAN);
		this.maxWithdrawal = maxWithdrawal;
		this.accLinked = accLinked;
	}

}
