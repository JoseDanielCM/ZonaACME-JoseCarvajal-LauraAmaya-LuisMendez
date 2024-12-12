package Repository.DAO;

import Model.*;

import java.sql.Date;
import java.util.List;

public interface FuncionarioDAO extends SalidaDAO{
    void crearTrabajador(Trabajador trabajador);
    void crearInvitado(Invitado invitado);
    List<Persona> mostrarActivos();
    String estadoActualPersona(Persona persona);
    Persona getPersonaById(int id);
    void desactivarPersona(Persona persona);
    void crearAnotacion(Anotacion anotacion, int documento);
    @Override
    void RegistrarSalida(int Documento, Date fecha, int documentoUser);
    Empresa getEmpresaFuncionario(int idFuncionario);
    void crearVehiculo(Vehiculo vehiculo);
}
