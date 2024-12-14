package Service;
import Model.Sesion;

public interface SesionServiceInterfaz {
    Sesion buscarUsuario(String username, String password);
}