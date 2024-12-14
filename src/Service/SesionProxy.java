package Service;

import Model.Sesion;

import javax.swing.*;

public class SesionProxy implements SesionServiceInterfaz{
    private final SesionServiceInterfaz sesionServiceInterfaz;

    public SesionProxy(SesionServiceInterfaz sesionServiceInterfaz){
        this.sesionServiceInterfaz = sesionServiceInterfaz;
    }

    @Override
    public Sesion buscarUsuario(String username, String password) {

        if (username == null || username.isEmpty()) {
            System.out.println("El nombre de usuario no puede estar vacío.");
            return null;
        }

        if (password == null || password.isEmpty()) {
            System.out.println("La contraseña no puede estar vacía.");
            return null;
        }

        return sesionServiceInterfaz.buscarUsuario(username, password);
    }
}
