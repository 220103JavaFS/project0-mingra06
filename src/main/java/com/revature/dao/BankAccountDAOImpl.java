package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.repos.BankAccountDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAOImpl implements BankAccountDAO {

    @Override
    public List<BankAccount> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM bank_account;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<BankAccount> list = new ArrayList<BankAccount>();

            while(result.next())
            {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setAccountNumber(result.getInt("account_number"));
                bankAccount.setBalance(result.getInt("account_balance"));
                list.add(bankAccount);
            }

            return list;

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<BankAccount>();
    }

    @Override
    public BankAccount findByID(int id) {

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM bank_account WHERE account_number = " + id;

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<BankAccount> list = new ArrayList<BankAccount>();

            while(result.next())
            {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setAccountNumber(result.getInt("account_number"));
                bankAccount.setBalance(result.getInt("account_balance"));
                list.add(bankAccount);
            }
            return list.get(0);//Only one should be here

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new BankAccount();
    }

    @Override
    public boolean updateBankAccount(BankAccount bankAccount) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO bank_account(account_number,account_balance) VALUES(" + bankAccount.getAccountNumber() + ", " + bankAccount.getAccountBalance() + ");";

            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO bank_account(account_number,account_balance) VALUES(" + bankAccount.getAccountNumber() + ", " + bankAccount.getAccountBalance() + ");";

            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
