package Main;

import Model.Registro;
import Model.Supervisor;
import Repository.Impl.SuperUsuarioImpl;
import Util.DataBaseConnection;

public class TestConnection {
    public static void main(String[] args) {
        SuperUsuarioImpl superUsuario = new SuperUsuarioImpl();
        Supervisor supervisor = new Supervisor("juanito","123",true,null);
        superUsuario.addSupervisor(supervisor);

    }

}
