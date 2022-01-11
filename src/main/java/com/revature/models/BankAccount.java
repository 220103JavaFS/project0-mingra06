package com.revature.models;

import java.util.ArrayList;

public class BankAccount {

    int accountNumber;
    double accountBalance;
    ArrayList<PersonType> accountOwners;


    public BankAccount() {
        this.accountOwners = new ArrayList<PersonType>();
    }


    public BankAccount(int accountNumber, double accountBalance, ArrayList<PersonType> accountOwners) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountOwners = accountOwners;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public ArrayList<PersonType> getAccountOwners() {
        return accountOwners;
    }

    public void setAccountOwners(ArrayList<PersonType> accountOwners) {
        this.accountOwners = accountOwners;
    }
}
