package Service.Stategy;
import Model.*;
import Repository.Impl.GuardaImpl;

import java.util.List;

public class RegistroEntradaVehiculo implements RegistroStrategy {
    private GuardaImpl guardaImpl;

    public RegistroEntradaVehiculo(GuardaImpl guardaImpl) {
        this.guardaImpl = guardaImpl;
    }

    @Override
    public String crearRegistro(String documento, String docGuarda, String placa) {
        List<String> documentosList = List.of(documento.split(","));

        for (String doc : documentosList) {
            RegistroEntradaPersona entradaPersona = new RegistroEntradaPersona(guardaImpl);
            entradaPersona.crearRegistro(doc, docGuarda, placa);
        }
        return "¡Registro de entrada de vehículo realizado con éxito!";
    }
}

