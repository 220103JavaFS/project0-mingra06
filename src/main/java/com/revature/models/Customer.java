package com.revature.models;


import java.util.ArrayList;

public class Customer extends PersonType {

    ArrayList<BankAccount> bankAccounts;

    public Customer() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public Customer(String firstName, String lastName, String email, int id,  ArrayList<BankAccount> bankAccounts) {
        super(firstName, lastName, email, id, AccessLevel.CUSTOMER);
        this.bankAccounts = bankAccounts;
    }

    public boolean addAccount(BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
        return true;
    }
}
