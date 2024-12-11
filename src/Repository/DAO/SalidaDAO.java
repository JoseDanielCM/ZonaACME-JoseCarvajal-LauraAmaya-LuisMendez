package Repository.DAO;

import Model.Guarda;
import Model.Persona;

public interface SalidaDAO {
    void SalidaManual(Persona persona, Guarda guarda);
    void SalidaAutomatica();
}
