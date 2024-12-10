package Model;

public class Supervisor extends Usuario{
    public Supervisor(int id,String nombre, String contrasenia, boolean activo, Empresa empresa) {
        super(id,nombre, contrasenia, activo, empresa);
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", activo=" + activo +
                ", empresa=" + empresa +
                '}';
    }
}
