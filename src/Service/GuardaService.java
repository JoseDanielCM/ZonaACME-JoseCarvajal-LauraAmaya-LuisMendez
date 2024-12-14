package Service;

import Model.Funcionario;
import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;
import Repository.Impl.GuardaImpl;
import Service.Stategy.RegistroStrategy;
import View.Extras.MostrarAnotaciones;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GuardaService {
    private GuardaImpl guardaImpl;

    public GuardaService(){
        guardaImpl = new GuardaImpl();
    }

    public String crearRegistro(String documento, String docGuarda, String placa, RegistroStrategy strategy) {
        String resultado = strategy.crearRegistro(documento, docGuarda, placa);
        return resultado;
    }
    public String mostrarAnotaciones(String anotaciones){
        return anotaciones;
    }
}