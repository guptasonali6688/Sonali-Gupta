package com.zycus.banking;

import java.util.*;

public class App {
    int accNum;
    float amt;
    Transaction transaction;
    
    Scanner sc = new Scanner(System.in);
    
    //Taking User Inputs Account Number and Amount
    void user_input(){    
        System.out.println("Enter your Account Number :");
        this.accNum = sc.nextInt();
        System.out.println("Enter amount :");
        this.amt = sc.nextFloat();        
    }
    //withDrawCall
    void checkWithDraw(Branch b){
        user_input();
        transaction = new Transaction(b);
        if(transaction.withDraw(this.accNum, this.amt))
            System.out.println("WithDrawal is successful\n");
        else
            System.out.println("WithDrawal is failed\n");            
    }
    //DepositCall
    void checkDeposit(Branch b){
        user_input();
        transaction = new Transaction(b);
        if(transaction.deposit(this.accNum, this.amt))
            System.out.println("Deposit is successful\n");
        else
            System.out.println("Deposit is failed\n");            
    }
    //TransferCall
    void checkTransfer(Branch b) {
        int sourceAcc,desAcc;
        float amt;
        transaction = new Transaction(b);
        System.out.println("Enter source account number :");
        sourceAcc = sc.nextInt();
        System.out.println("Enter destination  account number :");
        desAcc = sc.nextInt();
        System.out.println("Enter amount :");
        amt = sc.nextFloat();
        if(transaction.transfer(sourceAcc, desAcc, amt))
            System.out.println("Transfer is successful");
        else
            System.out.println("Transfer failed");
    }
    //Display results
    void display(List<Account> account){
        Iterator it = account.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    } 
    //Sort By Balance 1-->ASC 2-->DESC
    void sortBalance(List<Account> account, int type) {
        if(type == 1){
            Comparator<Account> compareBalance = (p1, p2)->(int)(p1.getBalance()-p2.getBalance());
            Collections.sort(account, compareBalance);
        }else{
            Comparator<Account> compareBalance = (p1, p2)->(int)(p2.getBalance()-p1.getBalance());
            Collections.sort(account, compareBalance);
        }
        display(account);
    }
    //Sort by Account Number 1-->ASC 2-->DESC
    void sortAccNum(List<Account> account, int type) {
        if(type == 1){
            Comparator<Account> compareBalance = (p1, p2)->(int)(p1.getAccNum()-p2.getAccNum());
            Collections.sort(account, compareBalance);
        }else{
            Comparator<Account> compareBalance = (p1, p2)->(int)(p2.getAccNum()-p1.getAccNum());
            Collections.sort(account, compareBalance);
        }
        display(account);
    }
    
    //filter 
    void filterActiveAcc(Set<Account> account){
        Iterator<Account> it = account.iterator();
        while(it.hasNext())
            System.out.println(it.next().toString());
    }
    //Sort By Account Holder Name
    void sortByAccHolderName(List<Account> account){
        Comparator<Account> compareAccHolderName = (p1, p2)->p1.getAccHolderName().compareTo(p2.getAccHolderName());
        Collections.sort(account, compareAccHolderName);
        display(account);
    }
    
    public static void main(String args[]){
        
        App app = new App();
        Branch branch = new Branch();
        int input;
        Scanner sc = new Scanner(System.in);
        //Passing parameter to openNewAccount method 
        /*
        branch.openNewAccount(AccountType.CURRENT, 10000.77f, "Sonali", Status.ACTIVE);
        branch.openNewAccount(AccountType.CURRENT, 70000.77f, "Sonali", Status.ACTIVE);
        branch.openNewAccount(AccountType.CURRENT, 100.77f, "Sonali", Status.CLOSED);
        branch.openNewAccount(AccountType.CURRENT, 10000.77f, "Sonali", Status.ACTIVE);
        branch.openNewAccount(AccountType.CURRENT, 90000.77f, "Sonali", Status.ACTIVE);
        branch.openNewAccount(AccountType.CURRENT, 60000.77f, "Sonali", Status.CLOSED);
        branch.openNewAccount(AccountType.CURRENT, 40000.77f, "Sonali", Status.ACTIVE);
        */
        
        //Passing account object to openNewAccount
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"Sonali", AccountType.CURRENT, 10000.77f , Status.ACTIVE));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"Sona", AccountType.CURRENT, 1000.77f , Status.ACTIVE));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"Parth", AccountType.SAVINGS, 900.77f , Status.CLOSED));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"jakesh", AccountType.CURRENT, 10000.77f , Status.ACTIVE));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"rupali", AccountType.CURRENT, 70000.77f , Status.ACTIVE));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"ramesh", AccountType.SAVINGS, 90000.77f , Status.CLOSED));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"Ali", AccountType.CURRENT, 50000.77f , Status.ACTIVE));
        branch.openNewAccount(new Account(Branch.ACC_NO_GENERATOR,"suresh", AccountType.SAVINGS, 30000.77f , Status.ACTIVE));
        
        Transaction transaction = new Transaction(branch);
        
        //WithDraw
        System.out.println("\n----WITHDRAW-----\n");
        app.checkWithDraw(branch);
        System.out.println("\n----WITHDRAW-----\n");
        app.checkWithDraw(branch);
                    
        //Deposit
        System.out.println("\n----DEPOSIT-----\n");
        app.checkDeposit(branch);
        System.out.println("\n----DEPOSIT-----\n");    
        app.checkDeposit(branch);
        
        //transfer
        System.out.println("\n----TRANSFER-----\n");
        app.checkTransfer(branch);
        System.out.println("\n----TRANSFER-----\n");
        app.checkTransfer(branch);
        
        //Displaying the All Account List
        System.out.println("\n\n--Displaying all Account Details---\n");
        List<Account> account = new LinkedList<Account>();
        account = branch.getAllAccount();
        app.display(account);
        
        //Displaying the Sorted List of Accounts based on balance in Ascending order
        System.out.println("\n\n--Displaying the Sorted List of Accounts based on balance in Ascending order---\n");
        app.sortBalance(account,1);
                
        //Displaying the Sorted List of Accounts based on balance in Descending order
        System.out.println("\n\n--Displaying the Sorted List of Accounts based on balance in Descending order---\n");
        app.sortBalance(account,2);
        
        //Displaying the Sorted List of Accounts based on Account Number in Ascending order
        System.out.println("\n\n--Displaying the Sorted List of Accounts based on balance in Ascending order---\n");
        app.sortAccNum(account,1);
        
        //Displaying the Sorted List of Accounts based on balance in Descending order
        System.out.println("\n\n--Displaying the Sorted List of Accounts based on balance in Descending order---\n");
        app.sortAccNum(account,2);
        
        //Displaying Active Account
        System.out.println("\n\n--Displaying the ACTIVE Accounts ---\n");
        Set<Account> accSet = branch.findByStatus(Status.ACTIVE);
        app.filterActiveAcc(accSet);
        
        //Displaying Closed Account
        System.out.println("\n\n--Displaying the CLOSED Accounts ---\n");
        Set<Account> accSetc = branch.findByStatus(Status.CLOSED);
        app.filterActiveAcc(accSetc);
        
        //Filter all CLOSED account with balance > 5000
        System.out.println("\n\n--Displaying the CLOSED Accounts with balance > 5000---\n");
        Set<Account> accSetcl = branch.findByStatusGreaterthan5000(Status.CLOSED);
        app.filterActiveAcc(accSetcl);
        
        //Displaying the Sorted List of Accounts based on account holder Name
        System.out.println("\n\n--Displaying the Sorted List of Accounts based on Account Holder Name---\n");
        app.sortByAccHolderName(account);
    
    }
}