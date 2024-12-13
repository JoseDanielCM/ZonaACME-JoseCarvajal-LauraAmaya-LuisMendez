package Repository.DAO;

import java.sql.Timestamp;

public interface SalidaDAO {
    void RegistrarSalida(int Documento, Timestamp fecha, int documentoUser);
    void RegistrarSalidaVehiculo(int cantidadPersonas, String placa);
}
