package Service;

import Model.*;
import Repository.Impl.FuncionarioImpl;

import java.sql.Date;
import java.util.List;

public class FuncionarioService {
    private FuncionarioImpl funcionarioImpl;

    public FuncionarioService(){
        funcionarioImpl = new FuncionarioImpl();
    }
    public void crearTrabajador(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        int docInt;
        int docFuncionarioInt;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del trabajador debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docFuncionarioInt = Integer.parseInt(docFuncionario);
        }catch (Exception e){
            System.out.println("El documento del Funcionario debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }

        Empresa emp = funcionarioImpl.getEmpresaFuncionario(docFuncionarioInt);
        
        Vehiculo vehiculo = null;
        if (placaVehiculo != null && !placaVehiculo.isEmpty()) {
            if (placaVehiculo.matches("^[a-zA-Z0-9]{6}$")) {
                vehiculo = new Vehiculo(placaVehiculo);
                funcionarioImpl.crearVehiculo(vehiculo);
            } else {
                System.out.println("La placa del vehículo no es válida. Debe tener exactamente 6 caracteres alfanuméricos.");
                throw new IllegalArgumentException("Placa del vehículo no válida.");
            }
        }

        Trabajador trabajador = new Trabajador(docInt,nombre,true,"Permitido",emp,true,vehiculo);
        funcionarioImpl.crearTrabajador(trabajador);
    }

    public void crearInvitado(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        int docInt;
        int docFuncionarioInt;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del trabajador debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docFuncionarioInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del Funcionario debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }

        Empresa emp = funcionarioImpl.getEmpresaFuncionario(docFuncionarioInt);

        Vehiculo vehiculo = null;
        if (placaVehiculo != null && !placaVehiculo.isEmpty()) {
            if (placaVehiculo.matches("^[a-zA-Z0-9]{6}$")) {
                vehiculo = new Vehiculo(placaVehiculo);
                funcionarioImpl.crearVehiculo(vehiculo);
            } else {
                System.out.println("La placa del vehículo no es válida. Debe tener exactamente 6 caracteres alfanuméricos.");
                throw new IllegalArgumentException("Placa del vehículo no válida.");
            }
        }

        Invitado invitado = new Invitado(docInt,nombre,true,"Permitido",emp,true,vehiculo);
        funcionarioImpl.crearInvitado(invitado);
    }

    public void desactivarPersona(int id){
        Persona persona = funcionarioImpl.getPersonaById(id);
        funcionarioImpl.desactivarPersona(persona);
    }

    public List<Persona> mostrarActivos() {
        return funcionarioImpl.mostrarActivos();
    }

    public String estadoActualPersona(int id) {
        Persona persona = funcionarioImpl.getPersonaById(id);
        return funcionarioImpl.estadoActualPersona(persona);
    }

    public void RegistrarSalidaManual(String documento, String docFuncionario) {
        int docInt;
        int docFuncionarioInt;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del trabajador debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docFuncionarioInt = Integer.parseInt(docFuncionario);
        }catch (Exception e){
            System.out.println("El documento del Funcionario debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        Persona persona = funcionarioImpl.getPersonaById(docInt);
        Funcionario funcionario = funcionarioImpl.mostrarFuncionario(docFuncionarioInt);
        funcionarioImpl.RegistrarSalidaManual(persona,funcionario);
    }
}
