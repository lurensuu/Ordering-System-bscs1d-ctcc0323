package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import colors.color;

public class MyData {
    public static boolean register (String username, String password) {
        try{
        if(!checkUser(username)){
            Connection connection = DriverManager.getConnection(color.DB_URL, color.DB_USERNAME, color.DB_PASSWORD);
            PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " + color.DB_USERS_TABLE_NAME + "(username, password)" + 
            "VALUES(?, ?)");

            insertUser.setString(1, username);
            insertUser.setString(2, password);

            insertUser.executeUpdate();
            return true;
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
        return false;

    }

    public static boolean checkUser (String username){
        try{
            Connection connection = DriverManager.getConnection(color.DB_URL, color.DB_USERNAME, color.DB_PASSWORD);

            PreparedStatement checkUserExists = connection.prepareStatement("SELECT * FROM " + color.DB_USERS_TABLE_NAME + " WHERE USERNAME = ?");
            checkUserExists.setString(1, username);
            ResultSet resultSet = checkUserExists.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public static boolean validateLogin(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(color.DB_URL, color.DB_USERNAME, color.DB_PASSWORD);

            PreparedStatement validateUser = connection.prepareStatement("SELECT * FROM " + color.DB_USERS_TABLE_NAME +
            " WHERE USERNAME = ? AND PASSWORD = ?");
            validateUser.setString(1, username);
            validateUser.setString(2, password);

            ResultSet resultSet = validateUser.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();

        }

        return true;
    }
    
}
