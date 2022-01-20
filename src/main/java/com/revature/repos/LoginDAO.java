package com.revature.repos;

import com.revature.dto.UserDTO;

public interface LoginDAO {

    public UserDTO checkLogin(String username, String password);

    boolean createAccount(UserDTO userDTO);
}
