package Model;

import java.time.format.DateTimeFormatter;

public class Registro {
    private int idRegistro;
    private Persona persona;
    private DateTimeFormatter fecha;
    private Funcionario funcionario;
    private Anotacion anotacion;
    private String tipoRegistro;
    private String placaVehiculo;
}