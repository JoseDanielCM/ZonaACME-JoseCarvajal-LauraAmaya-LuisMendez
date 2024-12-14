package Repository.DAO;

import java.sql.Timestamp;

public interface SalidaDAO {
    void RegistrarSalida(int Documento, int documentoUser);
    void RegistrarSalidaVehiculo(int cantidadPersonas, String placa);
}
