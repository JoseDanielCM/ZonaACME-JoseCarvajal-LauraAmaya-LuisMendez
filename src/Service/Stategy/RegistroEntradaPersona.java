package Service.Stategy;

import Model.*;
import Repository.Impl.GuardaImpl;

public class RegistroEntradaPersona implements RegistroStrategy {
    private GuardaImpl guardaImpl;

    public RegistroEntradaPersona(GuardaImpl guardaImpl) {
        this.guardaImpl = guardaImpl;
    }

    @Override
    public String crearRegistro(String documento, String docGuarda, String placa) {
        int docInt;
        int docGuardaInt;
        Vehiculo vehiculo = null;
        try {
            docInt = Integer.parseInt(documento);
        } catch (Exception e) {
            return "El documento de la persona debe ser un numero";
        }
        try {
            docGuardaInt = Integer.parseInt(docGuarda);
        } catch (Exception e) {
            return "El documento del Guarda debe ser un numero";
        }
        Persona persona = guardaImpl.getPersonaById(docInt);
        Guarda guarda = guardaImpl.mostrarGuarda(docGuardaInt);
        if (placa != null && !placa.isEmpty()) {
            vehiculo = new Vehiculo(placa);
        }
        if (persona == null) {
            return "La persona no está registrada por favor comúniquese con el funcionario de la empresa.";
        } else if (guardaImpl.validarEstadoPersona(persona)) {
            guardaImpl.crearRegistroEntradaPersona(persona, guarda, vehiculo);
            return "¡Registro de entrada realizado con éxito!";
        } else {
            return "La persona tiene el acceso restringido, por favor comúniquese con el funcionario de la empresa.";
        }
    }
}

