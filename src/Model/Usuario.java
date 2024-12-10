package Model;

public abstract class Usuario {
    protected int documento;
    protected String nombre;
    protected String contrasenia;
    protected boolean activo;
    protected Empresa empresa;

    public Usuario(int documento,String nombre, String contrasenia, boolean activo, Empresa empresa) {
        this.documento = documento;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.activo = activo;
        this.empresa = empresa;
    }

    public int getDocumento() {
        return documento;
    }

    public void setdocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
