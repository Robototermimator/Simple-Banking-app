package com.thorn.banking.model;


public class Account {
    private String accountNumber;
    private  String ownerName;
    private double balance;

    //Hashed PIN
    private String pinHash;
    private int failedAttempts;
    private boolean locked = false;
    
    // Create a new account
    public Account(String accountNumber, String ownerName, String pinHash, double balance, int failedAttempts, boolean locked) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.pinHash = pinHash;
        this.balance = balance;
        this.failedAttempts = failedAttempts;
        this.locked = locked;
    }
    
    // Getters and setters
    public String getAccountNumber() {
         return accountNumber;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance() {
        return balance;
    }

    public String getPinHash() {
        return pinHash;
    }

    public boolean isLocked(){
        return locked;
    }

    public int getFailedAttempts(){
        return failedAttempts;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setFailedAttempts(int failedAttempts){
        this.failedAttempts = failedAttempts;
    }
    public void setLocked(boolean locked){
        this.locked = locked;
    }

 // Transaction methods for deposit and withdrawal
    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void incrementFailedAttempts(){
        failedAttempts++;
        if (failedAttempts >= 3){
            locked = true;
        }
    }
    public void resetFailedAttempts(){
        failedAttempts = 0;
    }
    public String toFileString(){
        return accountNumber + "|" + ownerName + "|" + pinHash + "|" + balance + "|" + failedAttempts + "|" + locked;
    }
}
