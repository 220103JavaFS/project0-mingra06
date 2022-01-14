package com.revature.models;

import java.util.ArrayList;

public class BankAccount {

    int accountNumber;
    double accountBalance;


    public BankAccount() {
    }


    public BankAccount(int accountNumber, double accountBalance, ArrayList<PersonType> accountOwners) {
        this.accountNumber = accountNumber;
        this.deposit(accountBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public boolean setBalance(int accountBalance)
    {
        this.accountBalance = accountBalance;
        return true;
    }


    public boolean deposit(double money)
    {
        if(money > 0)
        {
            accountBalance+= money;
            return true;
        }

        else
        {
            System.out.println("Error. Negative Deposit attempted.");
            return false;
        }

    }

    public boolean withdraw(double money)
    {
        if(money > 0)
        {
            if(money < accountBalance)
            {
                accountBalance-= money;
                return true;
            }

            else
            {
                System.out.println("Error. Withdraw amount is greater then account balance.");
                return false;
            }

        }
        else
        {
            System.out.println("Error. Negative Deposit attempted.");
            return false;
        }
    }
    public boolean addOwner(Customer newOwner)
    {
        newOwner.addAccount(this);
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }

    //This should never change so may need to be set to private, or just removed.
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
