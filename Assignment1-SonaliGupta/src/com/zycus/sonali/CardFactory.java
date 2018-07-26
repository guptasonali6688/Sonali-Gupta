package com.zycus.sonali;

import java.util.Scanner;

public class CardFactory {
    static long actNum;

    public static Card issueNewCard(CardType CARDTYPE) {
        // all input variables that have be to be given by customer
        String name, PAN;
        long phoneNum;
        float interestRate, creditLimit, maxWtihdrawal;
        int pointsEarned, accLinked;
        // generating unique car number
        actNum = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        // taking input from the customer for card type=credit
        if (CARDTYPE == CardType.CREDIT) {
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("PAN number: ");
            PAN = sc.nextLine();
            System.out.println("Phone Number ");
            phoneNum = sc.nextLong();
            System.out.println("Enter Interest Rate");
            interestRate = sc.nextFloat();
            System.out.println("Enter Credit Limit");
            creditLimit = sc.nextFloat();
            System.out.println("EnterPoints Earned");
            pointsEarned = sc.nextInt();         
            // returning a card object of type credit Card
            return new Credit(CARDTYPE, actNum, PAN, name, phoneNum, interestRate, creditLimit, pointsEarned);
        } // end of if function
        else if (CARDTYPE == CardType.DEBIT) {
        	//taking input from customer card debit
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("PAN number: ");
            PAN = sc.nextLine();
            System.out.println("Phone Number ");
            phoneNum = sc.nextLong();
            System.out.println("Enter Maximum withdrawal amount:");
            maxWtihdrawal = sc.nextFloat();
            System.out.println("Enter number of account linked");
            accLinked = sc.nextInt();
            //returning card object referring debit Card
            return new Debit(CARDTYPE, actNum, PAN, name, phoneNum, maxWtihdrawal, accLinked);
        }
        // end of if else loop,return null if both conditions are false
        return null;

    }

}