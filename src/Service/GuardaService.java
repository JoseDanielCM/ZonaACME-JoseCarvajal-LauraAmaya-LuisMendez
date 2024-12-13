package Service;

import Model.Funcionario;
import Model.Guarda;
import Model.Persona;
import Model.Vehiculo;
import Repository.Impl.GuardaImpl;

import java.util.ArrayList;
import java.util.List;

public class GuardaService {
    private GuardaImpl guardaImpl;

    public GuardaService(){
        guardaImpl = new GuardaImpl();
    }

    public String crearRegistroEntradaPersona(String documento, String docGuarda, String placa) {
        int docInt;
        int docGuardaInt;
        Vehiculo vehiculo = null;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento de la persona debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docGuardaInt = Integer.parseInt(docGuarda);
        }catch (Exception e){
            System.out.println("El documento del Guarda debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        Persona persona = guardaImpl.getPersonaById(docInt);
        Guarda guarda = guardaImpl.mostrarGuarda(docGuardaInt);
        if (placa != null && !placa.isEmpty()){
            vehiculo = new Vehiculo(placa);
        }
        if (persona == null){
            return "La persona no está registrada por favor comúniquese con el funcionario de la empresa.";
        } else if (guardaImpl.validarEstadoPersona(persona)) {
            guardaImpl.crearRegistroEntradaPersona(persona,guarda,vehiculo);
            mostrarAnotaciones(guardaImpl.mostrarAnotacionesPersonas(persona));
        } else {
            mostrarAnotaciones(guardaImpl.mostrarAnotacionesPersonas(persona));
            return "La persona tiene el acceso restringido, por favor comúniquese con el funcionario de la empresa.";

        }
        return "¡Registro de entrada realizado con éxito!";
    }

    public String crearRegistroSalidaPersona(String documento, String docGuarda, String placa) {
        int docInt;
        int docGuardaInt;
        Vehiculo vehiculo = null;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento de la persona debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docGuardaInt = Integer.parseInt(docGuarda);
        }catch (Exception e){
            System.out.println("El documento del Guarda debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        Persona persona = guardaImpl.getPersonaById(docInt);
        Guarda guarda = guardaImpl.mostrarGuarda(docGuardaInt);
        if (placa != null && !placa.isEmpty()){
            vehiculo = new Vehiculo(placa);
        }
        if (persona == null){
            return "La persona no está registrada por favor comúniquese con el funcionario de la empresa.";
        } else if (guardaImpl.validarEstadoPersona(persona)) {
            guardaImpl.crearRegistroSalidaPersona(persona,guarda,vehiculo);
            mostrarAnotaciones(guardaImpl.mostrarAnotacionesPersonas(persona));
        }
        return "¡Registro de salida realizado con éxito!";
    }

    public String mostrarAnotaciones(String anotaciones){
        return anotaciones;
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

    public String crearRegistroEntradaVehiculo(String documentos, String docGuarda, String placa){
        List<String> documentosList = List.of(documentos.split(","));

        for (String documento : documentosList){
            crearRegistroEntradaPersona(documento,docGuarda,placa);
        }
        return "¡Registro de entrada de vhículo realizado con éxito!";
    }

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
    public String crearRegistroSalidaVehiculo(String documentos, String docGuarda, String placa){
        List<String> documentosList = List.of(documentos.split(","));

        for (String documento : documentosList){
            crearRegistroSalidaPersona(documento,docGuarda,placa);
        }
        return "¡Registro de salida de vhículo realizado con éxito!";
    }
}
