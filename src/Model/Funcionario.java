package Model;

public class Funcionario extends Usuario{
    public Funcionario(int id, String nombre, String contrasenia, boolean activo, Empresa empresa) {
        super(id, nombre, contrasenia, activo, empresa);
    }

}
