package com.revature.services;

import com.revature.dao.CustomerAccountJoinDAOImple;
import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.CustomerAccountJoin;
import com.revature.repos.CustomerAccountJoinDAO;

import java.util.List;

public class CustomerAccountJoinService {

    private CustomerAccountJoinDAO customerAccountJoinDAO = new CustomerAccountJoinDAOImple();

    public List<BankAccount> findAllByCustomer(int id)
    {
        return customerAccountJoinDAO.findAllByCustomer(id);
    }
    public List<Customer> findAllByAccount(int accountNumber)
    {
        return customerAccountJoinDAO.findAllByAccount(accountNumber);
    }

    public boolean updateLink(int id, int accountNumber) {
        return customerAccountJoinDAO.updateLink(id, accountNumber);
    }

    public boolean addLink(int id, int accountNumber ) {
        return customerAccountJoinDAO.addLink(id, accountNumber);
    }

}
