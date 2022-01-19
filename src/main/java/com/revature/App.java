package com.revature;

import com.revature.controllers.*;
import com.revature.models.AccessManager;
import io.javalin.Javalin;

public class App {

    private static Javalin app;

    public static void main(String[] args) {

        app = Javalin.create(config -> {
            config.accessManager(new AccessManager());}); //This represents the configuration of the framework at runtime.
        configure(new BankAccountController(), new LoginController(), new EmployeeController(), new CustomerAccountController(), new CustomerController());

        app.start();

    }

    public static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
