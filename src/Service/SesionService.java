package Service;

import Model.Sesion;
import Repository.Impl.SesionImpl;

public class SesionService {
    SesionImpl sesion;

    public SesionService() {
        sesion = new SesionImpl();
    }

    public Sesion buscarUsuario(String username, String password) {
        int documento;
        try {
            documento = Integer.parseInt(username);
            return sesion.buscarUsuario(documento, password);
        } catch (Exception e){
            System.out.println(e);
            throw new IllegalStateException ("Documento deben ser numeros");
        }

    }
}
