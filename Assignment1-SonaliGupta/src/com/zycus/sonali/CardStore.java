package com.zycus.sonali;

import java.io.*;

public class CardStore {
	final static String DATA_PATH = "C:/CardData/cardData.dat";

    static Card[] cardList = new Card[100];
    static int counter = 0;

    // loadCard method
    public static void loadCard() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_PATH));
            Object obj = in.readObject();
            while (obj != null) {
                Card loadingCard = (Card) obj;
                if (loadingCard instanceof Debit) {
                    cardList[counter++] = (Debit) loadingCard;
                } else if (loadingCard instanceof Credit) {
                    cardList[counter++] = (Credit) loadingCard;
                }
                obj = in.readObject();
            }

        } catch (ClassNotFoundException ce) {
            System.out.println("No such file is found.");
        } catch (IOException e) {
        	//System.out.println("File is empty");
        }
    }

    // addCard to store new card into array
    public static void addCard(Card card) {
        cardList[counter++] = card;
        System.out.println("Card added successfully \n");

    }

    // store cards from file method
    public static void storeCard() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_PATH,false));
            for (Card c : cardList) {
                out.writeObject(c);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("No such file found.");
        }
    }

    // method to find card by number
    public static void findCardByNumber(long cardNum) {
    	for (Card c : cardList) {
		      if (c == null) {
		      //System.out.println("Card does not exist");
		            break;
		 }

		 if (cardNum == c.getCardNo())
		     System.out.println(c.toString());
		 }
       
    }

    // method to find card by holder name
    public static void findCardByName(String holderName) {

        for (Card c : cardList) {
            if (c == null) {
                //System.out.println("Card does not exist");
                break;
            }
            if (holderName.equalsIgnoreCase(c.getHolderName()))
                System.out.println(c.toString());
        }
    }
}
