package com.revature.services;

import com.revature.dao.LoginDAOImpl;
import com.revature.repos.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO = new LoginDAOImpl();

    public boolean checkLogin(String username, String password)
    {
        return loginDAO.checkLogin(username, password);
    }
}
