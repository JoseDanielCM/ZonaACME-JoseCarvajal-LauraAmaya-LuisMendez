package Controller;

import Model.Persona;
import Service.FuncionarioService;

import java.sql.Date;
import java.util.List;

public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(){
        funcionarioService = new FuncionarioService();
    }
    public void crearTrabajador(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        funcionarioService.crearTrabajador(documento,nombre,placaVehiculo,docFuncionario);
    }
    public void crearInvitado(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        funcionarioService.crearInvitado(documento,nombre,placaVehiculo,docFuncionario);
    }
    public void desactivarPersona(int id){
        funcionarioService.desactivarPersona(id);
    }
    public List<Persona> mostrarActivos(){
        return funcionarioService.mostrarActivos();
    }
    public String estadoActualPersona(int id) {
        return funcionarioService.estadoActualPersona(id);
    }
    public void RegistrarSalidaManual(String documento, String docFuncionario) {
        funcionarioService.RegistrarSalidaManual(documento,docFuncionario);
    }



}
