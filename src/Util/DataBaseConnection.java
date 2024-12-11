package Util;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String USER = "campus2023";
    private static String PASSWORD = "campus2023";
    private static Connection connection;
    private static String ip;
    private static final String archivoURL = "/home/camper/Escritorio/ZonaACME-JoseCarvajal-LauraAmaya-LuisMendez/src/Util/IpConnection.txt";

    public static void leerIp(){
        FileReader fr;
        BufferedReader buffer;
        String linea;
        try {
            fr = new FileReader(archivoURL);
            buffer = new BufferedReader(fr);
            while ((linea = buffer.readLine()) != null){
                System.out.println(linea);
                ip = linea;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                leerIp();
                String url = "jdbc:mysql://"+ ip +":3306/ZonaACME";
                connection = DriverManager.getConnection(url, USER, PASSWORD);
                System.out.println(url);
                System.out.println("Conectado correctamente a la base de datos");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar la base de datos");
        }
        return connection;}

    public static void setIp(String nuevaIp) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(archivoURL))){
            try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoURL))){
                bufferedWriter.write(nuevaIp);
                bufferedWriter.newLine();
                leerIp();
                getConnection();
        }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


