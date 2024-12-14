package Service.Stategy;
import Model.*;
import Repository.Impl.GuardaImpl;

import javax.swing.*;
import java.util.List;
public class RegistroSalidaVehiculo implements RegistroStrategy {
    private GuardaImpl guardaImpl;

    public RegistroSalidaVehiculo(GuardaImpl guardaImpl) {
        this.guardaImpl = guardaImpl;
    }

    @Override
    public String crearRegistro(String documento, String docGuarda, String placa) {
        List<String> documentosList = List.of(documento.split(","));
        String msg = "¡Registro de salida de vehículo realizado con éxito!";
        for (String doc : documentosList) {
            RegistroSalidaPersona salidaPersona = new RegistroSalidaPersona(guardaImpl);
            String text = salidaPersona.crearRegistro(doc, docGuarda, placa);
            if (text.contains("no está registrada")){
                msg = "Se realizó registro a las personas permitidas";
            }
            JOptionPane.showMessageDialog(null,text);

        }
        return msg;
    }
}

