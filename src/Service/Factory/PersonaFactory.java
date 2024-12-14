package Service.Factory;

import Model.*;

public class PersonaFactory {

    public static Trabajador crearTrabajador(int documento, String nombre, Empresa empresa, Vehiculo vehiculo) {
        return new Trabajador(documento, nombre, true, "Permitido", empresa, true, vehiculo);
    }

    public static Invitado crearInvitado(int documento, String nombre, Empresa empresa, Vehiculo vehiculo) {
        return new Invitado(documento, nombre, true, "Permitido", empresa, true, vehiculo);
    }

    public static Vehiculo crearVehiculo(String placaVehiculo) {
        if (placaVehiculo != null && !placaVehiculo.isEmpty()) {
            if (placaVehiculo.matches("^[a-zA-Z0-9]{6}$")) {
                return new Vehiculo(placaVehiculo);
            } else {
                throw new IllegalArgumentException("La placa del vehículo no es válida. Debe tener exactamente 6 caracteres alfanuméricos.");
            }
        }
        return null;
    }
}
