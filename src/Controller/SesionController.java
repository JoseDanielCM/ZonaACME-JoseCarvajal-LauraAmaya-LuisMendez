package Controller;

import Model.Sesion;
import Service.SesionService;

public class SesionController {
    private SesionService sesionService;

    public SesionController() {
        sesionService = new SesionService();
    }

    public Sesion buscarUsuario(String username, String password) {
        return sesionService.buscarUsuario(username, password);
    }
}
