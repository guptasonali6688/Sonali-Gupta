package com.zycus.banking;

public class Transaction {
    Branch branch;
    private static final float MIN_BALANCE = 1000;
    public Transaction(Branch branch) {
        super();
        this.branch = branch;
    }
    
    public boolean withDraw(int accNum, float amt){
        try{
            Account account = branch.getAccount(accNum);
            float balance = account.getBalance() - amt;
            if(checkAccountStatus(account) && balance > MIN_BALANCE){
                account.setBalance(balance);
                //System.out.println("Withdrawal is successful");
                return true;
            }
        }catch(NullPointerException ne){
            System.out.println("No such Account is found");
        }
        return false;
    }
    public boolean deposit(int accNum, float amt){
        try{
            Account account = branch.getAccount(accNum);
            float balance = account.getBalance() + amt;
            if(checkAccountStatus(account)){
                account.setBalance(balance);
                //System.out.println("Deposit is successful");
                return true;
            }
        }catch(NullPointerException ne){
            System.out.println("No such Account is found");
        }
        return false;
    }
    private boolean checkAccountStatus(Account account){
        if(account != null) {
            if(account.getStatus() == Status.ACTIVE)
                return true;
            else
                return false;
        }else {
            //System.out.println("No Account Exists");
            return false;
        }
    }
    
    public boolean transfer(int sourceAccountNumber, int destinationAccountNumber, float amt){
        try {
            if(withDraw(sourceAccountNumber, amt)){
                if(deposit(destinationAccountNumber, amt)) {
                    //System.out.println("Transfer is successful");
                    return true;
                }else
                {
                    //System.out.println("Error in Transfer");
                    deposit(sourceAccountNumber, amt);
                }
            }else
            {
                //System.out.println("Error in Transaction");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
