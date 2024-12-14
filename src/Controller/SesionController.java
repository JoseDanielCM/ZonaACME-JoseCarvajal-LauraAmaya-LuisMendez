package Controller;

import Model.Sesion;
import Service.SesionProxy;
import Service.SesionService;

public class SesionController {
    private SesionProxy sesionProxy;

    public SesionController() {
        // Inyecta el servicio real en el Proxy
        this.sesionProxy = new SesionProxy(new SesionService());
    }

    public Sesion buscarUsuario(String username, String password) {
        return sesionProxy.buscarUsuario(username, password);
    }
}
