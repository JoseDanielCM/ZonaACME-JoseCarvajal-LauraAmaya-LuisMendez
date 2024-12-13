package Controller;

import Service.GuardaService;

public class GuardaController {
    private GuardaService guardaService;

    public GuardaController(){
        guardaService = new GuardaService();
    }

    public String crearRegistroEntradaPersona(String documento, String docGuarda, String placa) {
        return guardaService.crearRegistroEntradaPersona(documento,docGuarda,placa);
    }
    public String crearRegistroSalidaPersona(String documento, String docGuarda, String placa) {
        return guardaService.crearRegistroSalidaPersona(documento,docGuarda,placa);
    }
    public String mostrarAnotaciones(String anotaciones){
        return guardaService.mostrarAnotaciones(anotaciones);
    }
    public String crearRegistroEntradaVehiculo(String documentos, String docGuarda, String placa){
        return guardaService.crearRegistroEntradaVehiculo(documentos,docGuarda,placa);
    }
    public String crearRegistroSalidaVehiculo(String documentos, String docGuarda, String placa){
        return guardaService.crearRegistroSalidaVehiculo(documentos,docGuarda,placa);
    }


}
