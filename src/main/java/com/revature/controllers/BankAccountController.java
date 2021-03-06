package com.revature.controllers;

import com.revature.dto.BankAccountDTO;
import com.revature.dto.TransferDTO;
import com.revature.models.Role;
import com.revature.models.BankAccount;
import com.revature.services.BankAccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class BankAccountController implements Controller{

    private BankAccountService bankAccountService = new BankAccountService();

    Handler getBankAccounts = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.findAllAccounts());
            log.info("All bank accounts retrieved.");
            ctx.status(200);
        }else {
            log.warn("Session invalid");
            ctx.status(401);
        }
    };


    //FIX
    Handler getBankAccountByID = (ctx) ->{
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO = ctx.bodyAsClass(BankAccountDTO.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.findByID(Integer.parseInt(bankAccountDTO.accountNumber)));
            log.info("Bank account retrieved.");
            ctx.status(200);
        }else {
            log.warn("Session invalid.");
            ctx.status(401);
        }
    };

    Handler updateBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.updateBankAccount(account));
            log.info("Bank account updated.");
            ctx.status(200);
        }else {
            log.warn("Session invalid");
            ctx.status(401);
        }
    };

    Handler addBankAccount = (ctx) ->{
        BankAccount account = new BankAccount();

        account = ctx.bodyAsClass(BankAccount.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(bankAccountService.addBankAccount(account.getAccountBalance()));
            log.info("Bank account added.");
            ctx.status(200);
        }else {
            log.warn("Session invalid.");
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
                log.info("Withdraw completed.");
                ctx.status(200);
            }
            else
            {
                log.warn("Withdraw failed.");
                ctx.status(402);
            }

        }else {
            log.warn("Session invalid.");
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
                log.info("Deposit completed.");
                ctx.status(200);
            }
            else
            {
                log.warn("Deposit failed.");
                ctx.status(400);
            }

        }else {
            log.warn("Session invalid.");
            ctx.status(401);
        }
    };

    Handler transferBankAccount = (ctx) ->{

        TransferDTO transferDTO = new TransferDTO();

        transferDTO = ctx.bodyAsClass(TransferDTO.class);

        if(bankAccountService.transfer(transferDTO)) {
            ctx.status(200);
            log.info("Successful transfer.");
        }else {
            log.warn("Transfer failed.");
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/bank_accounts", getBankAccounts, Role.EMPLOYEE);
        app.post("/bank_account", getBankAccountByID, Role.EMPLOYEE);
        app.post("/update_bank_account", updateBankAccount, Role.EMPLOYEE);
        app.post("/add_bank_account", addBankAccount, Role.EMPLOYEE);
        app.post("/deposit", depositBankAccount, Role.EMPLOYEE);
        app.post("/withdraw", withdrawBankAccount, Role.EMPLOYEE);
        app.post("transfer", transferBankAccount, Role.EMPLOYEE);
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