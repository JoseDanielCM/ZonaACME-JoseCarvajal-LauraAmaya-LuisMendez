package Model;

public class SuperUsuario extends Usuario {
    public SuperUsuario(int id, String nombre, String contrasenia, boolean activo, Empresa empresa) {
        super(id, nombre, contrasenia, activo, empresa);
    }
}
