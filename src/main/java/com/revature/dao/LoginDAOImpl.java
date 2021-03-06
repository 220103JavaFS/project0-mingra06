package com.revature.dao;

import com.revature.dto.UserDTO;
import com.revature.models.BankAccount;
import com.revature.repos.LoginDAO;
import com.revature.utils.ConnectionUtil;
import org.eclipse.jetty.server.Authentication;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {


    @Override
    public UserDTO checkLogin(String username, String password){
        try(Connection conn = ConnectionUtil.getConnection()) {
            if(!validateInput(username))
            {
                System.out.println("Error in input, potential SQL injection detected.");
                return new UserDTO();
            }
            String sql = "SELECT * FROM logins WHERE username = " + username + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<BankAccount> list = new ArrayList<BankAccount>();

            while(result.next())
            {
                if(result.getString("en_password").equals(password))
                {
                    UserDTO userDTO = new UserDTO();
                    userDTO.access = result.getInt("access_level");
                    return userDTO;
                }
                else
                {
                    UserDTO userDTO = new UserDTO();
                    userDTO.access = 1;
                    return userDTO;
                }
            }
        }catch(PSQLException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UserDTO();
    }

    @Override
    public boolean createAccount(UserDTO userDTO) {
        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO logins(username, password) VALUES(?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userDTO.username);
            statement.setString(2, userDTO.password);
            statement.setInt(3, 1);//Set default access to customer, only Manager can update

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean validateInput(String input)
    {
        if(input.toUpperCase().contains("INSERT") || input.toUpperCase().contains("DELETE") || input.toUpperCase().contains("ADD") || input.toUpperCase().contains("WHERE") || input.toUpperCase().contains("FROM")
        || input.toUpperCase().contains("WHEN") || input.toUpperCase().contains("GROUP") || input.toUpperCase().contains("VALUES"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
