package Service;

import Model.Funcionario;
import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;
import Repository.Impl.GuardaImpl;
import Service.Stategy.RegistroStrategy;

import java.util.ArrayList;
import java.util.List;

public class GuardaService {
    private GuardaImpl guardaImpl;

    public GuardaService(){
        guardaImpl = new GuardaImpl();
    }

    public String crearRegistro(String documento, String docGuarda, String placa, RegistroStrategy strategy) {
        String resultado = strategy.crearRegistro(documento, docGuarda, placa);
        Persona persona = guardaImpl.getPersonaById(Integer.parseInt(documento));
        if (persona != null) {
            mostrarAnotaciones(guardaImpl.mostrarAnotacionesPersonas(persona));
        }
        return resultado;
    }
    public String mostrarAnotaciones(String anotaciones){
        return anotaciones;
    }
}

    /*public String crearRegistroEntradaVehiculo(String documentos, String docGuarda, String placa){
        List<String> documentosList = List.of(documentos.split(","));
        List<Persona> personasList = new ArrayList<Persona>();
        for (String documento : documentosList){
            int documentoInt = Integer.parseInt(documento);
            Persona persona = guardaImpl.getPersonaById(documentoInt);
            personasList.add(persona);
        }
        int docGuardInt = Integer.parseInt(docGuarda);
        Guarda guarda = guardaImpl.mostrarGuarda(docGuardInt);
        Vehiculo vehiculo = new Vehiculo(placa);
        guardaImpl.crearRegistroEntradaVehiculo(personasList,guarda, vehiculo);
        return "¡Registro de entrada de vhículo realizado con éxito!";
    }*/
    /*public String crearRegistroSalidaVehiculo(String documentos, String docGuarda, String placa){
        List<String> documentosList = List.of(documentos.split(","));
        List<Persona> personasList = new ArrayList<Persona>();
        for (String documento : documentosList){
            int documentoInt = Integer.parseInt(documento);
            Persona persona = guardaImpl.getPersonaById(documentoInt);
            personasList.add(persona);
        }
        int docGuardInt = Integer.parseInt(docGuarda);
        Guarda guarda = guardaImpl.mostrarGuarda(docGuardInt);
        Vehiculo vehiculo = new Vehiculo(placa);
        guardaImpl.crearRegistroSalidaVehiculo(personasList,guarda, vehiculo);
        return "¡Registro de salida de vhículo realizado con éxito!";
    }*/