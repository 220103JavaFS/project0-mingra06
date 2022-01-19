package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repos.EmployeeDAO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM employee;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Employee> list = new ArrayList<Employee>();

            while(result.next())
            {
                Employee employee = new Employee();
                employee.setId(result.getInt("customer_id"));
                employee.setFirstName(result.getString("employee_first_name"));
                employee.setLastName(result.getString("employee_last_name"));
                employee.setEmail(result.getString("employee_email"));
                list.add(employee);
            }

            return list;

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<Employee>();
    }

    @Override
    public Employee findByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM employee WHERE employee_number = " + id + ";";
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Employee> list = new ArrayList<Employee>();

            while(result.next())
            {
                Employee employee = new Employee();
                employee.setEmployeeNumber(result.getInt("employee_number"));
                employee.setId(result.getInt("customer_id"));
                employee.setFirstName(result.getString("employee_first_name"));
                employee.setLastName(result.getString("employee_last_name"));
                employee.setEmail(result.getString("employee_email"));
                list.add(employee);
            }
            return list.get(0);

        }catch(SQLException e)
    {
        e.printStackTrace();
    }
        return new Employee();
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE employee SET employee_first_name = ?, employee_last_name = ?, employee_email = ? WHERE employee_number = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getId());

            statement.executeUpdate();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO employee(employee_first_name, employee_last_name, employee_email) VALUES(?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());

            statement.executeUpdate();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
