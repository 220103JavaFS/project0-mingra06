package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

import java.util.List;

public interface CustomerAccountJoinDAO {

    public List<BankAccount> findAllByCustomer(int id);
    public List<Customer>findAllByAccount(int accountNumber);
    public boolean updateLink(int id, int accountNumber);
    public boolean addLink(int id, int accountNumber);
}
