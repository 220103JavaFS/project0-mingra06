package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.dto.CustomerDTO;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController implements Controller{

    private CustomerService customerService = new CustomerService();

    Handler getCustomers = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(customerService.findAllAccounts());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getCustomer = (ctx) ->{
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO = ctx.bodyAsClass(CustomerDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerService.findByID(Integer.parseInt(customerDTO.customerID)));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateCustomer = (ctx) ->{
        Customer customer = new Customer();

        customer = ctx.bodyAsClass(Customer.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerService.updateCustomer(customer));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler addCustomer = (ctx) ->{
        Customer customer = new Customer();

        customer = ctx.bodyAsClass(Customer.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerService.addCustomer(customer));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };
    @Override
    public void addRoutes(Javalin app) {
        app.get("/customers", getCustomers);
        app.post("/customer", getCustomer);
        app.post("/update_customer", updateCustomer);
        app.post("/add_customer", addCustomer);
    }
}



//    public Customer findByID(int id){return customerDAO.findByID(id);}
//    public boolean updateCustomer(Customer customer){return customerDAO.updateCustomer(customer);}
//    public boolean addCustomer(Customer customer){return customerDAO.addCustomer(customer);}


