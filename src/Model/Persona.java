package Model;

public abstract class Persona {
    private int documento;
    private String nombre;
    private boolean activo;
    private String estado;
    private Empresa empresa;
    private boolean haSalido;

    public Persona(int documento, String nombre, boolean activo, String estado, Empresa empresa, boolean haSalido) {
        this.documento = documento;
        this.nombre = nombre;
        this.activo = activo;
        this.estado = estado;
        this.empresa = empresa;
        this.haSalido = haSalido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean isHaSalido() {
        return haSalido;
    }

    public void setHaSalido(boolean haSalido) {
        this.haSalido = haSalido;
    }
}
