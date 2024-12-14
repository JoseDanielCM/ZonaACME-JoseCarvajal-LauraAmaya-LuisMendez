package Service.Stategy;
import Model.*;
import Repository.Impl.GuardaImpl;

import java.util.List;
public class RegistroSalidaVehiculo implements RegistroStrategy {
    private GuardaImpl guardaImpl;

    public RegistroSalidaVehiculo(GuardaImpl guardaImpl) {
        this.guardaImpl = guardaImpl;
    }

    @Override
    public String crearRegistro(String documento, String docGuarda, String placa) {
        List<String> documentosList = List.of(documento.split(","));

        for (String doc : documentosList) {
            RegistroSalidaPersona salidaPersona = new RegistroSalidaPersona(guardaImpl);
            salidaPersona.crearRegistro(doc, docGuarda, placa);
        }
        return "¡Registro de salida de vehículo realizado con éxito!";
    }
}

