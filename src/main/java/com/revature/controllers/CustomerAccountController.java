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
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getAllByAccount = (ctx) ->{
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO = ctx.bodyAsClass(BankAccountDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.findAllByAccount(Integer.parseInt(bankAccountDTO.accountNumber)));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateLink = (ctx) ->{
        CustomerAccountJoin accountJoin = new CustomerAccountJoin();

        accountJoin = ctx.bodyAsClass(CustomerAccountJoin.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.updateLink(accountJoin));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler addLink = (ctx) ->{
        CustomerAccountJoin accountJoin = new CustomerAccountJoin();

        accountJoin = ctx.bodyAsClass(CustomerAccountJoin.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(customerAccountJoinService.addLink(accountJoin));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };




    @Override
    public void addRoutes(Javalin app) {
        app.get("/by_customer", getAllByCustomer);
        app.get("/by_account", getAllByAccount);
        app.get("/update_link", updateLink);
        app.get("/add_link", addLink);
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
