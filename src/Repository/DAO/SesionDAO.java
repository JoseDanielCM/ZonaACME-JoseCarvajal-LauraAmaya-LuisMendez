package Repository.DAO;

import Model.Sesion;

public interface SesionDAO {
    Sesion buscarUsuario(int username, String password);
}
