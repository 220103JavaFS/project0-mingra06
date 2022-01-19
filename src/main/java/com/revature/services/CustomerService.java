package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;

import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public List<Customer> findAllAccounts()
    {
        return customerDAO.findAll();
    }
    public Customer findByID(int id){return customerDAO.findByID(id);}
    public boolean updateCustomer(Customer customer){return customerDAO.updateCustomer(customer);}
    public boolean addCustomer(Customer customer){return customerDAO.addCustomer(customer);}

}
