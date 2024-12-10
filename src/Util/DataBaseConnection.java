package Util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ZonaACME";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";
    private static Connection connection;
    public DataBaseConnection (){}

    public static Connection getConnection(){
        try {
            if (connection==null || connection.isClosed()){
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar la base de datos");
        }
        return connection;
    }
}
