package Controller;

import Model.Funcionario;
import Service.SupervisorService;

public class SupervisorController {
    private SupervisorService supervisorService;

    public SupervisorController() {
        supervisorService = new SupervisorService();
    }

    public void crearFuncionario(String id, String nombre, String contrasenia, String nombreEmpresa) {
        supervisorService.crearFuncionario(id, nombre, contrasenia, nombreEmpresa);
    }

    public void desactivarFuncionario(String documentoFun) {
        supervisorService.desactivarFuncionario(documentoFun);
    }

    public Funcionario mostrarFuncionarioID(String documentoFun) {
        return supervisorService.mostrarFuncionarioID(documentoFun);
    }


}
