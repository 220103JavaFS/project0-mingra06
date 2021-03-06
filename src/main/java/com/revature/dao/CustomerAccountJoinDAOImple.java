package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.CustomerAccountJoin;
import com.revature.repos.CustomerAccountJoinDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountJoinDAOImple implements CustomerAccountJoinDAO {
    @Override
    public List<BankAccount> findAllByCustomer(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM customer_bank_account_join;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<CustomerAccountJoin> list = new ArrayList<CustomerAccountJoin>();
            List<BankAccount> accountList = new ArrayList<BankAccount>();

            while(result.next())
            {
                CustomerAccountJoin customerAccountJoin = new CustomerAccountJoin();
                customerAccountJoin.setCustomerID(result.getInt("customer"));
                customerAccountJoin.setAccountNumber(result.getInt("account_number"));
                list.add(customerAccountJoin);
            }

            //for each account number add it to the second list
            for(CustomerAccountJoin c: list)
            {
                sql = "SELECT * FROM bank_account WHERE account_number = " + c.getAccountNumber() + ";";

                result = statement.executeQuery(sql);

                //should have only 1 in it
                while(result.next())
                {
                    BankAccount bankAccount = new BankAccount();
                    bankAccount.setAccountNumber(result.getInt("account_number"));
                    bankAccount.setBalance(result.getInt("account_balance"));
                    accountList.add(bankAccount);
                }
            }
            return accountList;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
            return new ArrayList<BankAccount>();
    }

    @Override
    public List<Customer> findAllByAccount(int accountNumber) {
        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM customer_bank_account_join;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<CustomerAccountJoin> list = new ArrayList<CustomerAccountJoin>();
            List<Customer> customerList = new ArrayList<Customer>();

            while(result.next())
            {
                CustomerAccountJoin customerAccountJoin = new CustomerAccountJoin();
                customerAccountJoin.setCustomerID(result.getInt("customer"));
                customerAccountJoin.setAccountNumber(result.getInt("account_number"));
                list.add(customerAccountJoin);
            }

            //for each account number add it to the second list
            for(CustomerAccountJoin c: list)
            {
                sql = "SELECT * FROM customer WHERE customer_id = " + c.getCustomerID() + ";";

                result = statement.executeQuery(sql);

                //should have only 1 in it
                while(result.next())
                {
                    Customer customer = new Customer();
                    customer.setId(result.getInt("customer_id"));
                    customer.setFirstName(result.getString("customer_first_name"));
                    customer.setLastName(result.getString("customer_last_name"));
                    customer.setEmail(result.getString("customer_email"));
                    customerList.add(customer);
                }
            }
            return customerList;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }


    @Override
    public boolean deleteLink(CustomerAccountJoin customerAccountJoin) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM customer_bank_account_join WHERE customer = ? AND account_number = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, customerAccountJoin.getCustomerID());
            statement.setInt(2, customerAccountJoin.getAccountNumber());

            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addLink(CustomerAccountJoin customerAccountJoin) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO customer_bank_account_join(customer, account_number) VALUES(?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, customerAccountJoin.getCustomerID());
            statement.setInt(2, customerAccountJoin.getAccountNumber());

            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
