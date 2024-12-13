package Repository.DAO;

import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;

import java.sql.Date;
import java.util.List;

public interface GuardaDAO extends SalidaDAO {
    void crearRegistroEntradaPersona(Persona persona, Guarda guarda);
    void crearRegistroSalidaPersona(Persona persona, Guarda guarda);

    void mostrarAnotacionesPersonas(Persona persona);

    void crearRegistroEntradaVehiculo(List<Persona> personas, Guarda guarda);
    void crearRegistroSalidaVehiculo(List<Persona> personas, Guarda guarda);

    Persona getPersonaById(int id);
    @Override
    void RegistrarSalida(int Documento, Date fecha, int documentoUser);
}
