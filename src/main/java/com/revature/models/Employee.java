package com.revature.models;

public class Employee extends PersonType{

    int employeeNumber;
    Customer employeeCustomer;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, int id,  int employeeNumber, Role accessLevel) {
        super(firstName, lastName, email, id, accessLevel);
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
