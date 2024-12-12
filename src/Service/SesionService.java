package Service;

import Model.Sesion;
import Repository.Impl.SesionImpl;

public class SesionService {
    SesionImpl sesion;

    public SesionService() {
        sesion = new SesionImpl();
    }

    public Sesion buscarUsuario(int username, String password) {
        return sesion.buscarUsuario(username, password);
    }
}
