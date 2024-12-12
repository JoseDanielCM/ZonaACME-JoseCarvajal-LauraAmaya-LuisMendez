package Repository.DAO;

import Model.Guarda;
import Model.Persona;

import java.sql.Date;

public interface SalidaDAO {
    void RegistrarSalida(int Documento,Date fecha, int documentoUser);
    void RegistrarSalidaVehiculo(int cantidadPersonas, String placa);
}
