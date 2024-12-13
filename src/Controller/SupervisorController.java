package Controller;

import Model.Funcionario;
import Model.Guarda;
import Model.Persona;
import Service.SupervisorService;

public class SupervisorController {
    private SupervisorService supervisorService;

    public SupervisorController() {
        supervisorService = new SupervisorService();
    }

    public void crearFuncionario(String id, String nombre, String contrasenia, String nombreEmpresa) {
        supervisorService.crearFuncionario(id, nombre, contrasenia, nombreEmpresa);
    }

    public Persona obtenerPersona(String documentoPersona){
        return supervisorService.obtenerPersona(documentoPersona);
    }

    public void desactivarFuncionario(String documentoFun) {
        supervisorService.desactivarFuncionario(documentoFun);
    }

    public Funcionario mostrarFuncionarioID(String documentoFun) {
        return supervisorService.mostrarFuncionarioID(documentoFun);
    }

    public void crearGuarda(String id, String nombre, String contrasenia, String nombreEmpresa){
        supervisorService.crearGuarda(id, nombre, contrasenia, nombreEmpresa);
    }

    public void desactivarGuarda(String documentoGuar) {
        supervisorService.desactivarGuarda(documentoGuar);
    }

    public Guarda mostrarGuarda(String documentoGuar) {
        return supervisorService.mostrarGuarda(documentoGuar);
    }

    public void crearAnotaciones(String Documento, String docUser, String Tipo, String Mensaje, String Fecha){
        supervisorService.crearAnotaciones(Documento, docUser, Tipo, Mensaje, Fecha);
    }

    public void levantarRestriccion(String documentoPersona){
        supervisorService.levantarRestriccion(documentoPersona);
    }

    public void registrarSalida(String documentoPer, String fecha, String docUs){
        supervisorService.RegistrarSalida(documentoPer,fecha,docUs);
    }

}
