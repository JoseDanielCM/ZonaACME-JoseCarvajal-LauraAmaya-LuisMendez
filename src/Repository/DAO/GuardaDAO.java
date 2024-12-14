package Repository.DAO;

import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;

import java.sql.Date;
import java.util.List;

public interface GuardaDAO {
    void crearRegistroEntradaPersona(Persona persona, Guarda guarda,Vehiculo vehiculo);
    void crearRegistroSalidaPersona(Persona persona, Guarda guarda, Vehiculo vehiculo);
    String mostrarAnotacionesPersonas(Persona persona);

    Persona getPersonaById(int id);
    boolean validarEstadoPersona(Persona persona);
    Guarda mostrarGuarda(int documentoGuarda);
}
