package com.revature.services;

import com.revature.dao.BankAccountDAOImpl;
import com.revature.models.BankAccount;
import com.revature.models.CustomerBankJoin;
import com.revature.repos.BankAccountDAO;
import com.revature.repos.CustomerAccountJoinDAO;

import java.util.List;

public class BankAccountService {

    private BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();
    private CustomerAccountJoinDAO = new CustomerAccountJoinDAOImple();

    public List<BankAccount> findAllAccounts()
    {
        return bankAccountDAO.findAll();
    }




}
