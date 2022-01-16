package com.revature.controllers;

import com.revature.services.BankAccountService;
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

    @Override
    public void addRoutes(Javalin app) {
        app.get("/customers", getCustomers);
    }
}
