package Main;

import Model.Empresa;
import Model.Guarda;
import Model.Invitado;
import Model.Persona;
import Repository.Impl.FuncionarioImpl;
import Repository.Impl.GuardaImpl;
import Repository.Impl.SuperUsuarioImpl;
import Repository.Impl.SupervisorImpl;
import Util.DataBaseConnection;
import View.InicioSesion;

public class TestConnection {
    public static void main(String[] args) {
        DataBaseConnection.getConnection();


    }
}
