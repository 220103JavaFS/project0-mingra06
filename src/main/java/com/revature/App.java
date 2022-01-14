package com.revature;

import com.revature.controllers.BankAccountController;
import com.revature.controllers.Controller;
import com.revature.controllers.PersonController;
import io.javalin.Javalin;

public class App {

    private static Javalin app;

    public static void main(String[] args) {


        app = Javalin.create(); //This represents the configuration of the framework at runtime.



        configure(new BankAccountController());

        app.start();

    }

    public static void configure(Controller... controllers){

        for(Controller c: controllers){
            c.addRoutes(app);
        }

    }
}
