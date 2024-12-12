package Model;

import java.time.format.DateTimeFormatter;

public abstract class Registro {
    private Persona persona;
    private DateTimeFormatter fecha;
    private Funcionario funcionario;
    private Anotacion anotacion;
    private String tipoRegistro;
    private Vehiculo vehiculo;
}
