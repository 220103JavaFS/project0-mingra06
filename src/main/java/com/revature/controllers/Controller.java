package com.revature.controllers;

import com.revature.App;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Controller {
    public static Logger log = LoggerFactory.getLogger(App.class);
    public abstract void addRoutes(Javalin app);
}
