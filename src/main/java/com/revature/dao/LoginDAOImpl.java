package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.repos.LoginDAO;
import com.revature.utils.ConnectionUtil;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {


    @Override
    public boolean checkLogin(String username, String password){
        try(Connection conn = ConnectionUtil.getConnection()) {
            validateInput(username)
            String sql = "SELECT * FROM logins WHERE username = " + username + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<BankAccount> list = new ArrayList<BankAccount>();

            while(result.next())
            {
                if(result.getString("en_password").equals(password))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

        }catch(PSQLException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean validateInput(String input)
    {
        switch (input.toUpperCase())
            case
    }
}
