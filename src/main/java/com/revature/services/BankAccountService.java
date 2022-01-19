package com.revature.services;

import com.revature.dao.BankAccountDAOImpl;
import com.revature.dto.TransferDTO;
import com.revature.models.BankAccount;
import com.revature.repos.BankAccountDAO;

import java.util.List;

public class BankAccountService {

    private BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();

    public List<BankAccount> findAllAccounts()
    {
        return bankAccountDAO.findAll();
    }



    public BankAccount findByID(int id)
    {
        return bankAccountDAO.findByID(id);
    }
    public boolean updateBankAccount(BankAccount bankAccount)
    {
     return bankAccountDAO.updateBankAccount(bankAccount);
    }
    public boolean addBankAccount(double balance)
    {
        return bankAccountDAO.addBankAccount(balance);
    }


    public boolean transfer(TransferDTO transferDTO) {
        return bankAccountDAO.transfer(transferDTO);
    }
}
