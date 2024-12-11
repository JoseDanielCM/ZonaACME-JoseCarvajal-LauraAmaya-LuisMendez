package Repository.DAO;

import Model.Guarda;
import Model.Persona;

public interface SalidaDAO {
    void RegistrarSalida(int Documento);
    void RegistrarSalidaVehiculo(int cantidadPersonas, String placa);
}
