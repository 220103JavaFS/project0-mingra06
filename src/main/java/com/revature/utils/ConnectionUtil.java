package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {



    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(("org.postgresql.Driver"));
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //jdbc:postgresql://endpoint:port/databasename
        String url = "jdbc:postgresql://javafs220103.cgbxbw6vcclz.us-east-1.rds.amazonaws.com:5432/demos";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }

//
//    public static void main(String[] args){
//        try{
//            getConnection();
//            System.out.println("Connection successfull");
//        }catch(SQLException e)
//        {
//            System.out.println("Connection Failed");
//            e.printStackTrace();
//        }
//    }
}
