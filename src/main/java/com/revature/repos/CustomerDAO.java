package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();
    public Customer findByID(int id);
    public boolean updateCustomer(Customer customer);
    public boolean addCustomer(Customer customer);

}
