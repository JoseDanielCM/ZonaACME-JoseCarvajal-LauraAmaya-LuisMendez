package Util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String USER = "root";
    private static String PASSWORD = "1234";
    private static Connection connection;
    private static String ip = "localhost";



    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://"+ip+":3306/ZonaACME";
                connection = DriverManager.getConnection(url, USER, PASSWORD);
                System.out.println("Conectado correctamente a la base de datos");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar la base de datos");
        }
        return connection;    }

    public static void setIp(String nuevaIp) {
        ip = nuevaIp;
    }
}


