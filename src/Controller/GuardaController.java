package Controller;

import Repository.Impl.GuardaImpl;
import Service.GuardaService;
import Service.Stategy.*;



public class GuardaController {
    private GuardaService guardaService;

    public GuardaController(){
        guardaService = new GuardaService();
    }

    public String crearRegistroEntradaPersona(String documento, String docGuarda, String placa) {
        RegistroStrategy entradaPersona = new RegistroEntradaPersona(new GuardaImpl());
        return guardaService.crearRegistro(documento,docGuarda,placa,entradaPersona);
    }
    public String crearRegistroSalidaPersona(String documento, String docGuarda, String placa) {
        RegistroStrategy salidaPersona = new RegistroSalidaPersona(new GuardaImpl());
        return guardaService.crearRegistro(documento,docGuarda,placa,salidaPersona);
    }
    public String mostrarAnotaciones(String anotaciones){
        return guardaService.mostrarAnotaciones(anotaciones);
    }
    public String crearRegistroEntradaVehiculo(String documentos, String docGuarda, String placa){
        RegistroStrategy entradaVehiculo = new RegistroEntradaVehiculo(new GuardaImpl());
        return guardaService.crearRegistro(documentos,docGuarda,placa,entradaVehiculo);
    }
    public String crearRegistroSalidaVehiculo(String documentos, String docGuarda, String placa){
        RegistroStrategy salidaVehiculo = new RegistroSalidaVehiculo(new GuardaImpl());
        return guardaService.crearRegistro(documentos,docGuarda,placa,salidaVehiculo);
    }

}
