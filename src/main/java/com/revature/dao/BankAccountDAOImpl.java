package com.revature.dao;

import com.revature.dto.TransferDTO;
import com.revature.models.BankAccount;
import com.revature.models.CustomerAccountJoin;
import com.revature.repos.BankAccountDAO;
import com.revature.repos.CustomerAccountJoinDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
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
                bankAccount.setBalance(result.getDouble("account_balance"));
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
            String sql = "UPDATE bank_account SET account_balance = ? WHERE account_number = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, bankAccount.getAccountBalance());
            statement.setInt(2, bankAccount.getAccountNumber());

            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBankAccount(double balance) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO bank_account(account_balance) VALUES(?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean transfer(TransferDTO transferDTO) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "CALL transfer(?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, transferDTO.senderAccount);
            statement.setInt(2, transferDTO.receiverAccount);
            statement.setDouble(3, transferDTO.amount);
            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
