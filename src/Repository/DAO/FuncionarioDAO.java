package Repository.DAO;

import Model.*;

import java.sql.Date;
import java.util.List;

public interface FuncionarioDAO {
    void crearTrabajador(Trabajador trabajador);
    void crearInvitado(Invitado invitado);
    List<Persona> mostrarActivos();
    String estadoActualPersona(Persona persona);
    Persona getPersonaById(int id);
    void desactivarPersona(Persona persona);
    void RegistrarSalidaManual(Persona persona, Date fecha, Funcionario funcionario);
    Empresa getEmpresaFuncionario(int idFuncionario);
    void crearVehiculo(Vehiculo vehiculo);
    Funcionario mostrarFuncionario(int documentoFuncionario);
}
