package Util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String USER = "campus2023";
    private static String PASSWORD = "campus2023";
    private static Connection connection;
    private static String ip = "localhost";



    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://"+ip+":3306/ZonaACME";
                System.out.println(url);
                connection = DriverManager.getConnection(url, USER, PASSWORD);
                System.out.println("Bien bien");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar la base de datos");
        }
        return connection;    }

    public static void setIp(String nuevaIp) {
        ip = nuevaIp;
    }
}


