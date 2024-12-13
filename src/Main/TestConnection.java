package Main;

import Util.DataBaseConnection;
import View.SuperUsuario.InicioSesion;

public class TestConnection {
    public static void main(String[] args) {

        DataBaseConnection.getConnection();

        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);

    }
}
