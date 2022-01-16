package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public List<Customer> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<Customer>();

            while(result.next())
            {
                Customer customer = new Customer();
                customer.setId(result.getInt("customer_id"));
                customer.setFirstName(result.getString("customer_first_name"));
                customer.setLastName(result.getString("customer_last_name"));
                customer.setEmail(result.getString("customer_email"));
                list.add(customer);
            }

            return list;

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }

    @Override
    public Customer findByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer WHERE customer_id = " + id + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<Customer>();

            while(result.next())
            {
                Customer customer = new Customer();
                customer.setId(result.getInt("customer_id"));
                customer.setFirstName(result.getString("customer_first_name"));
                customer.setLastName(result.getString("customer_last_name"));
                customer.setEmail(result.getString("customer_email"));
                list.add(customer);
            }
            return list.get(0);//Only one should be here

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new Customer();
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES(" + customer.getFirstName() + ", " + customer.getLastName() + ", " + customer.getEmail() + ");";

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
    public boolean addCustomer(Customer customer) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES(" + customer.getFirstName() + ", " + customer.getLastName() + ", " + customer.getEmail() + ");";

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
