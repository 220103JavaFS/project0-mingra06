package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

import java.util.List;

public interface BankAccountDAO {

    public List<BankAccount> findAll();
    public BankAccount findByID(int id);
    public boolean updateBankAccount(BankAccount bankAccount);
    public boolean addBankAccount(double balance);


}
