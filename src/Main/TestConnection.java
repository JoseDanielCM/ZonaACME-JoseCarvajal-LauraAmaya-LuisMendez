package Main;

import Model.*;
import Repository.Impl.*;
import Util.DataBaseConnection;
import View.InicioSesion;

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
