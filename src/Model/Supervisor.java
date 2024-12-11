package Model;

public class Supervisor extends Usuario{
    public Supervisor(int documento,String nombre, String contrasenia, boolean activo, Empresa empresa) {
        super(documento,nombre, contrasenia, activo, empresa);
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + documento +
                ", nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", activo=" + activo +
                ", empresa=" + empresa +
                '}';
    }
}
