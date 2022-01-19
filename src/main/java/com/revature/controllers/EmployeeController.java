package com.revature.controllers;

import com.revature.models.Role;
import com.revature.models.Employee;
import com.revature.dto.EmployeeDTO;
import com.revature.services.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller{

    private EmployeeService employeeService = new EmployeeService();

    Handler getEmployees = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(employeeService.findAllAccounts());
            log.info("All employees retrieved.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler getEmployee = (ctx) ->{
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO = ctx.bodyAsClass(EmployeeDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(employeeService.findByID(Integer.parseInt(employeeDTO.employeeID)));
            log.info("Employee retrieved by ID.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler updateEmployee = (ctx) ->{



        Employee employee = new Employee();

        employee = ctx.bodyAsClass(Employee.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(employeeService.updateEmployee(employee));
            log.info("Employee updated.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler addEmployee = (ctx) ->{
        Employee customer = new Employee();

        customer = ctx.bodyAsClass(Employee.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(employeeService.addEmployee(customer));
            log.info("Employee added.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/employees", getEmployees, Role.EMPLOYEE);
        app.post("/employee", getEmployee, Role.EMPLOYEE);
        app.post("/update_employee", updateEmployee, Role.MANAGER);
        app.post("/add_employee", addEmployee, Role.MANAGER);
    }



}
