package com.revature.controllers;

import com.revature.dto.BankAccountDTO;
import com.revature.dto.CustomerDTO;
import com.revature.dto.EmployeeDTO;
import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.CustomerAccountJoin;
import com.revature.services.CustomerAccountJoinService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class CustomerAccountController implements Controller{


    CustomerAccountJoinService customerAccountJoinService = new CustomerAccountJoinService();

    Handler getAllByCustomer = (ctx) ->{
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO = ctx.bodyAsClass(CustomerDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.findAllByCustomer(Integer.parseInt(customerDTO.customerID)));
            log.info("All accounts owned by customer retrieved.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler getAllByAccount = (ctx) ->{
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO = ctx.bodyAsClass(BankAccountDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.findAllByAccount(Integer.parseInt(bankAccountDTO.accountNumber)));
            log.info("All customers that own account retrieved.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler deleteLink = (ctx) ->{
        CustomerAccountJoin accountJoin = new CustomerAccountJoin();

        accountJoin = ctx.bodyAsClass(CustomerAccountJoin.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.updateLink(accountJoin));
            log.info("Link deleted.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler addLink = (ctx) ->{

        System.out.println("Entering");

        CustomerAccountJoin accountJoin = new CustomerAccountJoin();

        accountJoin = ctx.bodyAsClass(CustomerAccountJoin.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.addLink(accountJoin));
            log.info("Link added.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };




    @Override
    public void addRoutes(Javalin app) {
        app.post("/by_customer", getAllByCustomer);
        app.post("/by_account", getAllByAccount);
        app.post("/update_link", deleteLink);
        app.post("/add_link", addLink);
    }
}


//
//    public List<BankAccount> findAllByCustomer(int id)
//    {
//        return customerAccountJoinDAO.findAllByCustomer(id);
//    }
//    public List<Customer> findAllByAccount(int accountNumber)
//    {
//        return customerAccountJoinDAO.findAllByAccount(accountNumber);
//    }
//
//    public boolean updateLink(int id, int accountNumber) {
//        return customerAccountJoinDAO.updateLink(id, accountNumber);
//    }
//
//    public boolean addLink(int id, int accountNumber ) {
//        return customerAccountJoinDAO.addLink(id, accountNumber);
//    }
