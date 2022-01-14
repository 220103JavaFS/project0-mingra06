package com.revature.controllers;

import com.revature.services.BankAccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class BankAccountController implements Controller{

    private BankAccountService bankAccountService = new BankAccountService();
    Handler getBankAccounts = (ctx) ->{
        ctx.json(bankAccountService.findAllAccounts());
        ctx.status(200);
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("bankAccount", getBankAccounts);
    }
}
