package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.CustomerAccountJoin;

import java.util.List;

public interface CustomerAccountJoinDAO {

    public List<BankAccount> findAllByCustomer(int id);
    public List<Customer>findAllByAccount(int accountNumber);
    public boolean deleteLink(CustomerAccountJoin customerAccountJoin);
    public boolean addLink(CustomerAccountJoin customerAccountJoin);
}
