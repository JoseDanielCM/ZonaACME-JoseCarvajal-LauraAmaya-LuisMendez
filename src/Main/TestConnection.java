package Main;

import Util.DataBaseConnection;
import View.SuperUsuario.InicioSesion;

public class TestConnection {
    public static void main(String[] args) {

        DataBaseConnection.getConnection();

        /*
        SesionImpl sesionImpl = new SesionImpl();
        Sesion sesion =  sesionImpl.buscarUsuario(1020306598,"123");
        System.out.println(sesion.getUsuario());
        */

        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);

    }
}
