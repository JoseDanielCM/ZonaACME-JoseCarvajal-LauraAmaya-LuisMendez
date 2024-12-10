package Model;

public class Funcionario extends Usuario{
    public Funcionario(String nombre, String contrasenia, boolean activo, Empresa empresa) {
        super(nombre, contrasenia, activo, empresa);
    }
}
