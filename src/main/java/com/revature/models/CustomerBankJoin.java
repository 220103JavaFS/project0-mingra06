package com.revature.models;

public class CustomerBankJoin {


    int customerID;
    int accountNumber;

    public CustomerBankJoin(int customerID, int accountNumber) {
        this.customerID = customerID;
        this.accountNumber = accountNumber;
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
