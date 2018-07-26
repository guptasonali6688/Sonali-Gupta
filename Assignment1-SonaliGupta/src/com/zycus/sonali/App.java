package com.zycus.sonali;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

        System.out.println("---------------Welcome user----------------\n");
        /**
         * main method calls loadCard() method of CardStore class at the beginning, which loads all
         * data present in the text file into an Card Object array
         */
        CardStore.loadCard();
        /**
         * After loading, menu() method is called .
         */
        menu();
    }

    public static void menu() {
        int cardType;
        long cardNumber;
        String holderName;
        int choice;

        /**
         * Display menu for user at least once using do while loop
         */
        do {
            System.out.println("Select an option \n " + "1.Add/Generate a new card \n "
                    + "2.Find card by number \n" + " 3.Find card by holder name \n" + " 4.quit application");
            System.out.println("Enter option number ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            if (choice == 1) {
                /**
                 * asks user if they want a credit or debit card and passes the
                 * value back to function
                 */
                sc.nextLine();
                System.out.println("Please enter the following details:\n");
                System.out.println("Type of card:1.Credit or 2.debit ");
                cardType = sc.nextInt();
                switch (cardType) {
                case 1:
                    CardStore.addCard(CardFactory.issueNewCard(CardType.CREDIT));
                    break;
                case 2:
                    CardStore.addCard(CardFactory.issueNewCard(CardType.DEBIT));
                    break;

                default:
                    System.out.println("invalid choice");
                }// end of switch
            } // end of choice 1

            /**
             * This option is used for finding cards by their Card number,it take 
             * value from user and passes the value back to function
             * findCardByNumber in CardStore class
             */
            else if (choice == 2) {
                System.out.println("Enter card number");
                cardNumber = sc.nextLong();
                CardStore.findCardByNumber(cardNumber);
            }
            /**
             * This option is used for finding cards by their name,it take value
             * from user and passes the value back to function findCardByName in
             * CardStore class
             */
            else if (choice == 3) {
                System.out.println("Enter Holder Name:");
                sc.nextLine();
                holderName = sc.nextLine();
                CardStore.findCardByName(holderName);

            }
            /**
             * To quit the application, after which the store
             * function is called(outside the do-while loop) which stores all
             * the data from the cardList Card object array into the text file
             * 
             */
            else if (choice == 4)
                System.out.println("you have quit the application");

            else
                System.out.println("Invalid Input.");

        } while (choice != 4);
        /**
         * storeCard() method stores all card data from Card object array into cardData.dat file in binary
         * format
         */
        CardStore.storeCard();
    }

}
