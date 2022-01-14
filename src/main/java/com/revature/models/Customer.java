package com.revature.models;

import com.revature.dao.PersonDAO;

import java.util.ArrayList;

public class Customer extends PersonType {

    ArrayList<BankAccount> bankAccounts;

    public Customer() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public Customer(String name, String email, int id,  ArrayList<BankAccount> bankAccounts) {
        super(name, email, id, AccessLevel.CUSTOMER);
        this.bankAccounts = bankAccounts;
    }

    public boolean addAccount(BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
        return true;
    }
}
