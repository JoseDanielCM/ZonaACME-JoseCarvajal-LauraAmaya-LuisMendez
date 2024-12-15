package Service.Stategy;

import Model.*;
import Repository.Impl.GuardaImpl;
import View.Extras.MostrarAnotaciones;

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
        String txt = guardaImpl.mostrarAnotacionesPersonas(persona);

        if (persona == null) {
            return "La persona "+docInt+" no está registrada por favor comúniquese con el funcionario de la empresa.";
        } else if (guardaImpl.validarEstadoPersona(persona)) {
            MostrarAnotaciones mostrar = new MostrarAnotaciones(txt,false);
            mostrar.setVisible(true);
            if (persona.isHaSalido()) {
                guardaImpl.crearRegistroEntradaPersona(persona, guarda, vehiculo);
                return "¡Registro de entrada de "+persona.getNombre()+" realizado con éxito!";
            }else {
                return "!La persona: "+persona.getNombre()+" Está intentando ingresar sin registro previo de salida";
            }

        } else {
            MostrarAnotaciones mostrar = new MostrarAnotaciones(txt,true);
            mostrar.setVisible(true);
            return "La persona: "+persona.getNombre()+" tiene el acceso restringido, por favor comúniquese con el funcionario de la empresa.";
        }
    }
}

