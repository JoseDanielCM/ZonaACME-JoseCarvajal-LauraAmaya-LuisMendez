package Main;

import Model.Supervisor;
import Model.Usuario;
import Repository.Impl.SuperUsuarioImpl;
import Util.DataBaseConnection;
import View.Funcionario.PersonasActivasMenu;
import View.SuperUsuario.InicioSesion;

import java.util.List;

public class TestConnection {

    public static void main(String[] args) {

        DataBaseConnection.getConnection();

        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);

    }
}

//2023-11-22 12:03:13 - 1231231231 1102359999

