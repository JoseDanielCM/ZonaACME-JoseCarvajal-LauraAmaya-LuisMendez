package Model;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String contrasenia;
    protected boolean activo;
    protected Empresa empresa;

    public Usuario(String nombre, String contrasenia, boolean activo, Empresa empresa) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.activo = activo;
        this.empresa = empresa;
    }
    
}
