package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

import java.util.List;

public interface CustomerAccountJoinDAO {

    public List<BankAccount> findAllByCustomer(Integer id);
    public List<Customer>findAllByAccount(Integer accountNumber);
    public Customer findByID(int id);
    public boolean updateLink(int id, int accountNumber);
    public boolean addLink(Customer customer);
}
