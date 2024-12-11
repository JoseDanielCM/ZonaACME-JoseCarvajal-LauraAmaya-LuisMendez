package Main;

import Util.DataBaseConnection;
import View.InicioSesion;

public class TestConnection {
    public static void main(String[] args) {

        DataBaseConnection.getConnection();
        DataBaseConnection.setIp("127.0.0.1");

        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);

    }
}
