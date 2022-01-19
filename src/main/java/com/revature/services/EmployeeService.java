package com.revature.services;

import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repos.EmployeeDAO;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Employee> findAllAccounts(){return employeeDAO.findAll();}
    public Employee findByID(int id){return employeeDAO.findByID(id);}
    public boolean updateEmployee(Employee employee){return employeeDAO.updateEmployee(employee);}
    public boolean addEmployee(Employee employee){return employeeDAO.addEmployee(employee);}


}
