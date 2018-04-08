package com.m3c.ne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class ConnectionManager {

    public static Connection getConnection() throws SQLException{
        String path = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "Based";
        return DriverManager.getConnection(path,user,password);
    }

    public static void closeConnection(Connection connection){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
