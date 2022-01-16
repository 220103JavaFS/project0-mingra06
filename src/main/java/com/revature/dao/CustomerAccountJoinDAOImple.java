package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.repos.CustomerAccountJoinDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountJoinDAOImple implements CustomerAccountJoinDAO {
    @Override
    public List<BankAccount> findAllByCustomer(Integer id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer_bank_account_join WHERE customer = " + id;

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<BankAccount> list = new ArrayList<BankAccount>();

            while(result.next())
            {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setAccountNumber(result.getInt("customer"));
                bankAccount.setBalance(result.getInt("account_number"));
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
    public List<Customer> findAllByAccount(Integer accountNumber) {
        return null;
    }

    @Override
    public Customer findByID(int id) {
        return null;
    }

    @Override
    public boolean updateLink(int id, int accountNumber) {
        return false;
    }

    @Override
    public boolean addLink(Customer customer) {
        return false;
    }
}
