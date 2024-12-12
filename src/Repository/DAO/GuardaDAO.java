package Repository.DAO;

import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;

import java.sql.Date;
import java.util.List;

public interface GuardaDAO extends SalidaDAO {
    void crearRegistro(Persona persona, Guarda guarda, Vehiculo vehiculo);

    void mostrarAnotacionesPersonas(int documento);

    void crearRegistroVehiculo(Persona persona, Guarda guarda, Vehiculo vehiculo);

    void registrarVehiculo(String placa, List<Persona> personas, Guarda guarda);
    Persona getPersonaById(int id);
    @Override
    void RegistrarSalida(int Documento, Date fecha, int documentoUser);
}
