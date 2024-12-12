package Repository.DAO;

import Model.Anotacion;
import Model.Invitado;
import Model.Persona;
import Model.Trabajador;
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
}
