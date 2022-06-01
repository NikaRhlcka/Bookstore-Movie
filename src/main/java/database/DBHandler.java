package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//creating a connection to SQL Database
public class DBHandler {
    String connectionUrl = "jdbc:mysql://localhost:3306/movies";
    //String connectionUrl = "jdbc:mysql://localhost:3306/shop";
    String user = "root";
    String pass = "picklerickR567";

    //make connection static
    //because only one connecting is needed in the whole program
    private static Connection connection;
    public DBHandler(){
        try{
            connection = DriverManager.getConnection(connectionUrl,user,pass);
            System.out.println("Successfully connected!");
        }catch (SQLException e){
            System.out.println("Error connecting database.");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
