package com.zycus.banking;

import java.util.*;
import java.util.stream.Collectors;

public class Branch {
     static int ACC_NO_GENERATOR = 1;
     Map<Integer,Account> allAccounts = new HashMap<Integer,Account>(); 
     //With parameters initialization
     /*
     public void openNewAccount(AccountType acctype, float balance, String accHolderName, Status status) {
         allAccounts.put(ACC_NO_GENERATOR, new Account(ACC_NO_GENERATOR, accHolderName, acctype, balance, status));
         ++ACC_NO_GENERATOR;
     }
     */
     
     //With parameter considering Account object
     public void openNewAccount(Account account) {
         allAccounts.put(ACC_NO_GENERATOR, account);
         ++ACC_NO_GENERATOR;
     }
     
     //Getting allACcount details
     public Account getAccount(int accNum)
     {
         return allAccounts.get(accNum);         
     }
     
     //Close the account using account number
     public void closeAccount(int accNum){
         allAccounts.get(accNum).setStatus(Status.CLOSED);
         System.out.println("Your Account is successfully closed");
     }
     
     //Listing all the account details
     public List<Account> getAllAccount(){
         List<Account> listAccount= new LinkedList<Account>(allAccounts.values());
         return listAccount;
     }
     
     //Creating a set of account based on account holder name
     public Set<Account> findByHolderName(String accholderName) {
         return allAccounts.values().stream().filter((name)->name.getAccHolderName().equalsIgnoreCase(accholderName.trim())).collect(Collectors.toSet());
     }
     //Creating a set of account based on Status of account i.e Active/Closed
     public Set<Account> findByStatus(Status statusSet) {
         return allAccounts.values().stream().filter((status)->status.getStatus() == (statusSet)).collect(Collectors.toSet());
     }
     
     //Creating a set of account based on Status of account with balance greater than 5000
     public Set<Account> findByStatusGreaterthan5000(Status statusSet) {
         return allAccounts.values().stream().filter((status)->status.getStatus() == (statusSet)).filter((bal)->bal.getBalance() > 5000).collect(Collectors.toSet());
     }
     
}