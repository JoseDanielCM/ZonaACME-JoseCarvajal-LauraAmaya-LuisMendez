package Repository.DAO;

import Model.Guarda;
import Model.Persona;
import Model.Registro;

public interface EntradaDAO {
    void EntradaManual(Persona persona, Guarda guarda);
    void EntradaAutomatica();
}
