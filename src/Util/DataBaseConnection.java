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
    private static String mensaje;
    public DataBaseConnection (){}

    public static Connection getConnection(){
        try {
            if (connection==null || connection.isClosed()){
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                mensaje = "Conexión correcta a la base de datos";
                System.out.println(mostrarMensaje());
            }
        } catch (SQLException e) {
            mensaje = "Error al conectar con la base de datos: " + e.getMessage();
            System.out.println(mostrarMensaje());
        }
        return connection;
    }
    public static String mostrarMensaje(){
        return mensaje;
    }
}
