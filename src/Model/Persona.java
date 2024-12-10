package Model;

abstract class Persona {
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
}
