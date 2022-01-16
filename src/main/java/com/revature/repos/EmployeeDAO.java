package com.revature.repos;


import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findByID(int id);
    public boolean updateEmployee(Employee employee);
    public boolean addEmployee(Employee employee);
}
