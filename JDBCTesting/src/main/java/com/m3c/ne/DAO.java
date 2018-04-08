package com.m3c.ne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private String query = "select * from employees where employee_id = ?";

    public void runSQL(){
        Connection connection = null;
        try{
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 100);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                Double salary = resultSet.getDouble(7);
                System.out.println("NAME: "+name+" SALARY: "+ salary);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }
}