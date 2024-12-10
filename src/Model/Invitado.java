package Model;

public class Invitado extends Persona{
    public Invitado(int documento, String nombre, boolean activo, String estado, Empresa empresa, boolean haSalido) {
        super(documento, nombre, activo, estado, empresa, haSalido);
    }
}
