package com.revature.controllers;

import com.revature.dto.UserDTO;
import com.revature.models.Role;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.eclipse.jetty.server.Authentication;

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
            log.info("Login successful");
            ctx.status(200);
        }else
        {
            ctx.req.getSession().invalidate();
            log.warn("Login failed.");
            ctx.status(401);
        }
    };
    private Handler logoutAttempt = (ctx) -> {
            ctx.req.getSession().invalidate();
            log.info("Session logged out.");
            ctx.status(200);
    };

    private Handler createAccount = (ctx) -> {
        UserDTO userDTO = new UserDTO();
        userDTO = ctx.bodyAsClass(UserDTO.class);
        userDTO.password = toHexString(getSHA(userDTO.password));
        if(loginService.createAccount(userDTO))
        {
            log.info("Account created.");
            ctx.status(200);
        }else
        {
            log.info("Account creation failed.");
            ctx.status(400);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginAttempt);
        app.get("/logout", this.logoutAttempt);
        app.post("/create_account", createAccount);

    }
}
