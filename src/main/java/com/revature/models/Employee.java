package com.revature.models;

public class Employee extends PersonType{

    int employeeNumber;
    Customer employeeCustomer;

    public Employee() {
    }

    public Employee(String name, String email, int id,  int employeeNumber, AccessLevel accessLevel) {
        super(name, email, id, accessLevel);
        this.employeeNumber = employeeNumber;
    }
}
