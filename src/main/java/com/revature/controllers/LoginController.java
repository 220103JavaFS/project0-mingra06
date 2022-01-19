package com.revature.controllers;

import com.revature.dto.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import static com.revature.models.EncryptionSHA.getSHA;
import static com.revature.models.EncryptionSHA.toHexString;

public class LoginController implements Controller{

    LoginService loginService = new LoginService();

    private Handler loginAttempt = (ctx) -> {
        UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);

        userDTO = loginService.checkLogin(userDTO.username, toHexString(getSHA(userDTO.password)));
        if(userDTO != null)
        {
            ctx.req.getSession().setAttribute("accessLevel", userDTO.access);
            ctx.status(200);
        }else
        {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };
    private Handler logoutAttempt = (ctx) -> {
            ctx.req.getSession().invalidate();
            ctx.status(200);
    };
    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginAttempt);
        app.get("/logout", this.logoutAttempt);
    }
}
