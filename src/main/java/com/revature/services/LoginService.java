package com.revature.services;

import com.revature.dao.LoginDAOImpl;
import com.revature.dto.UserDTO;
import com.revature.repos.LoginDAO;

public class LoginService {

    private LoginDAO loginDAO = new LoginDAOImpl();

    public UserDTO checkLogin(String username, String password)
    {
        return loginDAO.checkLogin(username, password);
    }

    public boolean createAccount(UserDTO userDTO) {
        return loginDAO.createAccount(userDTO);
    }
}
