package Repository.DAO;

import Model.Guarda;
import Model.Persona;

public interface GuardaDAO extends SalidaDAO {
    void crearRegistro(Persona persona, Guarda guarda);

    void mostrarAnotacionesPersonas(int documento);
    
    void registrarVehiculo(String placa, int cantidadPersonas);
    
    void registrarSalida(int documento);

    @Override
    void RegistrarSalida(int Documento);
}
