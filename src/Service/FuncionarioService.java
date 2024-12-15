package Service;

import Model.*;
import Repository.Impl.FuncionarioImpl;
import Service.Factory.PersonaFactory;

import java.sql.Date;
import java.util.List;
public class FuncionarioService {
    private FuncionarioImpl funcionarioImpl;

    public FuncionarioService() {
        this.funcionarioImpl = new FuncionarioImpl();
    }

    public void crearTrabajador(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        int docInt = validarDocumento(documento);
        int docFuncionarioInt = validarDocumento(docFuncionario);

        Empresa empresa = funcionarioImpl.getEmpresaFuncionario(docFuncionarioInt);
        Vehiculo vehiculo = PersonaFactory.crearVehiculo(placaVehiculo);

        if (vehiculo != null) {
            funcionarioImpl.crearVehiculo(vehiculo);
        }

        Trabajador trabajador = PersonaFactory.crearTrabajador(docInt, nombre, empresa, vehiculo);
        funcionarioImpl.crearTrabajador(trabajador);
    }

    public void updatePersona(String newName, String documento) {
        int docInt = validarDocumento(documento);
        funcionarioImpl.updatePersona(newName, docInt);
    }

    public void updatePlaca(String newPlaca, String oldPlaca) {
        funcionarioImpl.updateVehiculoPlaca(newPlaca, oldPlaca);
    }

    public void crearInvitado(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        int docInt = validarDocumento(documento);
        int docFuncionarioInt = validarDocumento(docFuncionario);

        Empresa empresa = funcionarioImpl.getEmpresaFuncionario(docFuncionarioInt);
        Vehiculo vehiculo = PersonaFactory.crearVehiculo(placaVehiculo);

        if (vehiculo != null) {
            funcionarioImpl.crearVehiculo(vehiculo);
        }

        Invitado invitado = PersonaFactory.crearInvitado(docInt, nombre, empresa, vehiculo);
        funcionarioImpl.crearInvitado(invitado);
    }

    public void desactivarPersona(int id) {
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
        int docInt = validarDocumento(documento);
        int docFuncionarioInt = validarDocumento(docFuncionario);

        Persona persona = funcionarioImpl.getPersonaById(docInt);
        Funcionario funcionario = funcionarioImpl.mostrarFuncionario(docFuncionarioInt);

        funcionarioImpl.RegistrarSalidaManual(persona, funcionario);
    }

    public Persona getPersonaById(String idStr) {
        int id = validarDocumento(idStr);
        return funcionarioImpl.getPersonaById(id);
    }

    public List<Persona> mostrarTodos() {
        return funcionarioImpl.mostrarTodos();
    }

    private int validarDocumento(String documento) {
        try {
            return Integer.parseInt(documento);
        } catch (Exception e) {
            System.out.println("El documento debe ser un número válido.");
            throw new IllegalArgumentException("Documento no válido.");
        }
    }




}