package com.revature.models;

import io.javalin.core.security.RouteRole;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;

public class AccessManager implements io.javalin.core.security.AccessManager {
    @Override
    public void manage(@NotNull Handler handler, @NotNull Context ctx, @NotNull Set<RouteRole> routeRoles) throws Exception {
        Role userRole = getUserRole(ctx);



        ArrayList<String> openList = new ArrayList<>();
        openList.add("/login");
        openList.add("/logout");
        openList.add("/add_customer");
        openList.add("/create_account");


        if(ctx.req.getSession(false) == null && !openList.contains(ctx.path())){
            ctx.status(401);
            return;
        }
        else if(openList.contains(ctx.path()))
        {
            ctx.status(200);
            handler.handle(ctx);
            return;
        }

        int accessLevel = 0;

        try{
            accessLevel = (Integer) ctx.req.getSession(false).getAttribute(("accessLevel"));
        }
        catch(Exception e){
            //attribute "accessLevel" didn't exist or is not an Account Object
        }

        if (userRole.equals(Role.MANAGER) || routeRoles.contains(Role.BASE)) {
            handler.handle(ctx);
        }
        //if user is EMPLOYEE and route is for EMPLOYEE
        else if(userRole.equals(Role.EMPLOYEE) && routeRoles.contains(Role.EMPLOYEE)){
            handler.handle(ctx);
        }
        else {
            ctx.status(403).result("Forbidden");
        }
    }

    Role getUserRole(Context ctx) {
        int accessLevel = 1;
        try{
            accessLevel = (Integer) ctx.req.getSession(false).getAttribute("accessLevel");
        }
        catch (Exception e){
            //attribute "accessLevel" didn't exist or is not an Account object
        }

        switch (accessLevel){
            case 1:
                return Role.CUSTOMER;
            case 2:
                return Role.EMPLOYEE;
            case 3:
                return Role.MANAGER;
            default:
                return Role.BASE;
        }
    }
}
