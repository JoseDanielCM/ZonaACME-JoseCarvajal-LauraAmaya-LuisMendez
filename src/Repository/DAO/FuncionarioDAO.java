package Repository.DAO;

import Model.Invitado;
import Model.Persona;
import Model.Trabajador;

import java.util.List;

public interface FuncionarioDAO {
    void crearTrabajador(Trabajador trabajador);
    void crearInvitado(Invitado invitado);
    List<Persona> mostrarActivos();
    String estadoActualPersona(Persona persona);
    Persona getPersonaById(int id);
    void desactivarPersona(Persona persona);
}
