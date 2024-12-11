package Main;

import Model.Empresa;
import Model.Registro;
import Model.Supervisor;
import Repository.Impl.SuperUsuarioImpl;
import Repository.Impl.SupervisorImpl;
import Util.DataBaseConnection;

public class TestConnection {
    public static void main(String[] args) {
        // DataBaseConnection.getConnection();

        // DataBaseConnection.getConnection();
        SuperUsuarioImpl superUsuario = new SuperUsuarioImpl();
        /*
        Empresa empresa = superUsuario.getEmpresaById(1);

        System.out.println(superUsuario.getSupervisorById(1102359598));

        SupervisorImpl supervisor = new SupervisorImpl();
        supervisor.mostrarFuncionario(1102359898); */

        superUsuario.setIp("127.0.0.1");
        System.out.println(superUsuario.getEmpresaById(1));
    }

}
