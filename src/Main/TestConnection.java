package Main;

import Model.*;
import Repository.Impl.FuncionarioImpl;
import Repository.Impl.SuperUsuarioImpl;
import Repository.Impl.SupervisorImpl;
import Util.DataBaseConnection;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        /*
        // DataBaseConnection.getConnection();

        // DataBaseConnection.getConnection();
        SuperUsuarioImpl superUsuario = new SuperUsuarioImpl();
        Empresa empresa = superUsuario.getEmpresaById(1);

        System.out.println(superUsuario.getSupervisorById(1102359598));

        SupervisorImpl supervisor = new SupervisorImpl();
        supervisor.mostrarFuncionario(1102359898);

        superUsuario.setIp("127.0.0.1");
        superUsuario.activarEmpresa("Campus");
        */

        SuperUsuarioImpl superUsuario = new SuperUsuarioImpl();
        FuncionarioImpl funcionario = new FuncionarioImpl();
        List<Persona> people = funcionario.mostrarActivos();
        System.out.println(people.toString());
        // funcionario.desactivarPersona();
    }

}
