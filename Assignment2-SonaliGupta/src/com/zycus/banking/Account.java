//Account
package com.zycus.banking;

public class Account{
    private int accNum;
    private int branchCode;
    private String accHolderName;
    private AccountType acctype;
    private float balance;
    Status status;
    //Constructor must be default (No Access Specifier)
    Account(int accNum, String accHolderName, AccountType acctype, float balance2, Status status) {
        super();
        this.accNum = accNum;
        this.accHolderName = accHolderName;
        this.acctype = acctype;
        this.balance = balance2;
        this.status = status;
    }
    //Getter must be public
    public long getAccNum() {
        return accNum;
    }
    public int getBranchCode() {
        return branchCode;
    }
    public String getAccHolderName() {
        return accHolderName;
    }
    public AccountType getAcctype() {
        return acctype;
    }
    public float getBalance() {
        return balance;
    }
    public Status getStatus() {
        return status;
    }
    
    //Setter must be default (No Access Specifier)
    void setAccNum(int accNum) {
        this.accNum = accNum;
    }
    void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }
    void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    void setAcctype(AccountType acctype) {
        this.acctype = acctype;
    }
    void setBalance(float balance) {
        this.balance = balance;
    }
    void setStatus(Status status){
        this.status = status;
    }
    @Override
    public String toString() {
        return "Account [accNum=" + accNum + ", branchCode=" + branchCode + ", accHolderName=" + accHolderName
                + ", acctype=" + acctype + ", balance=" + balance + ", status=" + status + "]";
    }
            
}