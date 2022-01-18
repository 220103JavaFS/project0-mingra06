package com.revature.services;

import com.revature.dao.BankAccountDAOImpl;
import com.revature.models.BankAccount;
import com.revature.repos.BankAccountDAO;

import java.util.List;

public class BankAccountService {

    private BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();

    public List<BankAccount> findAllAccounts()
    {
        return bankAccountDAO.findAll();
    }




}
