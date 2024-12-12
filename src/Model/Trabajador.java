package Model;

public class Trabajador extends Persona{
    public Trabajador(int documento, String nombre, boolean activo, String estado, Empresa empresa, boolean haSalido, Vehiculo vehiculo) {
        super(documento, nombre, activo, estado, empresa, haSalido, vehiculo);
    }

}
