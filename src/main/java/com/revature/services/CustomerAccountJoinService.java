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

    public boolean updateLink(CustomerAccountJoin customerAccountJoin) {
        return customerAccountJoinDAO.deleteLink(customerAccountJoin);
    }

    public boolean addLink(CustomerAccountJoin customerAccountJoin) {
        return customerAccountJoinDAO.addLink(customerAccountJoin);
    }

}
