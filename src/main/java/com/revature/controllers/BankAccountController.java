package com.revature.controllers;

import com.revature.dto.BankAccountDTO;
import com.revature.models.BankAccount;
import com.revature.services.BankAccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class BankAccountController implements Controller{

    private BankAccountService bankAccountService = new BankAccountService();

    Handler getBankAccounts = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.findAllAccounts());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };


    //FIX
    Handler getBankAccountByID = (ctx) ->{
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO = ctx.bodyAsClass(BankAccountDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.findByID(Integer.parseInt(bankAccountDTO.accountNumber)));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.updateBankAccount(account));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler addBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.addBankAccount(account.getAccountBalance()));
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler withdrawBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {
            double total = bankAccountService.findByID(account.getAccountNumber()).getAccountBalance();
            if(total >= account.getAccountBalance())
            {
                account.setBalance(total - account.getAccountBalance());
                ctx.json(bankAccountService.updateBankAccount(account));
                ctx.status(200);
            }
            else
            {
                ctx.status(402);
            }

        }else {
            ctx.status(401);
        }
    };

    Handler depositBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {

            double total = bankAccountService.findByID(account.getAccountNumber()).getAccountBalance();

            if(account.getAccountBalance() > 0)
            {
                account.setBalance(total + account.getAccountBalance());
                ctx.json(bankAccountService.updateBankAccount(account));
                ctx.status(200);
            }
            else
            {
                ctx.status(400);
            }

        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/bank_accounts", getBankAccounts);
        app.post("/bank_account", getBankAccountByID);
        app.post("/update_bank_account", updateBankAccount);
        app.post("/add_bank_account", addBankAccount);
        app.post("/deposit", depositBankAccount);
        app.post("/withdraw", withdrawBankAccount);
    }
}



//
//    public BankAccount findByID(int id)
//    {
//        return bankAccountDAO.findByID(id);
//    }
//    public boolean updateBankAccount(BankAccount bankAccount)
//    {
//        return bankAccountDAO.updateBankAccount(bankAccount);
//    }
//    public boolean addBankAccount(BankAccount bankAccount)
//    {
//        return bankAccountDAO.addBankAccount(bankAccount);
//    }