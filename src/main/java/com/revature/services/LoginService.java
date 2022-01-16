package com.revature.services;

public class LoginService {

    public boolean login(String username, String password){
        System.out.println("=================");
        System.out.println("password" + password);
        if(username.equals("agent") & password.equals("password"))
        {
            System.out.println("++++++++++++++++");
            System.out.println(username + password);
            return true;
        }else {
            return false;
        }
    }
}
