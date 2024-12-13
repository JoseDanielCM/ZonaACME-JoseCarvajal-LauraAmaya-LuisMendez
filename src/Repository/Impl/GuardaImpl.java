package Repository.Impl;

import Model.*;
import Repository.DAO.GuardaDAO;
import Util.DataBaseConnection;

import java.sql.*;
import java.util.List;

public class GuardaImpl implements GuardaDAO {

    @Override
    public void crearRegistroEntradaPersona(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro` VALUES
                (?,NOW(),?,NULL,"Entrada",?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            ps.setString(3, vehiculo.getPlaca());
            ps.executeUpdate();

            System.out.println("Registro ingresado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void crearRegistroSalidaPersona(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro` VALUES
                (?,NOW(),?,NULL,"Salida",?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            ps.setString(3, vehiculo.getPlaca());
            ps.executeUpdate();

            System.out.println("Registro ingresado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String mostrarAnotacionesPersonas(Persona persona) {
        if (persona == null || persona.getDocumento() == 0) {
            return "Información de la persona no válida.";
        }

        StringBuilder anotaciones = new StringBuilder();
        String sql = """
                SELECT Persona.Documento, Persona.Nombre, Persona.Estado, Persona.IdEmpresa,
                       Anotaciones.IdAnotacion, Anotaciones.Tipo, Anotaciones.Mensaje, Anotaciones.Fecha 
                FROM Persona
                JOIN Anotaciones ON Anotaciones.Documento = Persona.Documento
                WHERE Persona.Documento = ?;
                """;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, persona.getDocumento());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                anotaciones.append("Anotaciones de la persona:\n")
                        .append("Documento: ").append(resultSet.getInt("Documento")).append("\n")
                        .append("Nombre: ").append(resultSet.getString("Nombre")).append("\n")
                        .append("Estado: ").append(resultSet.getString("Estado")).append("\n")
                        .append("Empresa: ").append(resultSet.getString("IdEmpresa")).append("\n")
                        .append("Id Anotacion: ").append(resultSet.getInt("IdAnotacion")).append("\n")
                        .append("Tipo: ").append(resultSet.getString("Tipo")).append("\n")
                        .append("Mensaje: ").append(resultSet.getString("Mensaje")).append("\n")
                        .append("Fecha: ").append(resultSet.getDate("Fecha")).append("\n");
            } else {
                anotaciones.append("No se encontraron anotaciones para la persona.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener anotaciones de la persona", e);
        }

        return anotaciones.toString();
    }
/*
    @Override
    public void crearRegistroEntradaVehiculo(List<Persona> personas, Guarda guarda, Vehiculo vehiculo) {
        if (personas == null || personas.isEmpty()) {
            System.out.println("La lista de personas está vacía o es nula. No se puede realizar el registro.");
            return;
        }

        for (Persona persona : personas) {
            try {
                if (persona != null) {
                    mostrarAnotacionesPersonas(persona);
                    crearRegistroEntradaPersona(persona, guarda, vehiculo);
                } else {
                    System.out.println("Se encontró una persona nula en la lista, se omite el registro.");
                }
            } catch (Exception e) {
                System.out.println("Error al registrar la entrada de la persona con documento: "
                        + (persona != null ? persona.getDocumento() : "Persona no registrada"));
                e.printStackTrace();
            }
        }
    }

    @Override
    public void crearRegistroSalidaVehiculo(List<Persona> personas, Guarda guarda, Vehiculo vehiculo) {
        if (personas == null || personas.isEmpty()) {
            System.out.println("La lista de personas está vacía o es nula. No se puede realizar el registro.");
            return;
        }

        for (Persona persona : personas) {
            try {
                if (persona != null) {
                    crearRegistroSalidaPersona(persona, guarda, vehiculo);
                    mostrarAnotacionesPersonas(persona);
                } else {
                    System.out.println("Se encontró una persona nula en la lista, se omite el registro.");
                }
            } catch (Exception e) {
                System.out.println("Error al registrar la entrada de la persona con documento: "
                        + (persona != null ? persona.getDocumento() : "Persona no registrada"));
                e.printStackTrace();
            }
        }
    }
*/
    @Override
    public Persona getPersonaById(int id) {
        String sql = """
                SELECT Persona.*, Empresa.`Nombre`, Empresa.idEmpresa from Persona
                JOIN Empresa ON Empresa.`IdEmpresa` = Persona.`IdEmpresa`
                WHERE Persona.`Documento` = ?;

                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()) {
                int documento = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                boolean activo = resultSet.getBoolean(3);
                String tipo = resultSet.getString(4);
                String estado = resultSet.getString(5);
                String nombreEmpresa = resultSet.getString(8);
                String idEmpresa = resultSet.getString(9);
                boolean haSalido = resultSet.getBoolean(7);
                Empresa empresa = new Empresa(idEmpresa, nombreEmpresa);
                if (tipo.equals("Invitado")){
                    return new Invitado(documento, nombre, activo, estado, empresa, haSalido,null);
                }else{
                    return new Trabajador(documento, nombre, activo, estado, empresa, haSalido,null);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean validarEstadoPersona(Persona persona){
        return persona.getEstado().equals("Permitido");
    }

    @Override
    public Guarda mostrarGuarda(int documentoGuarda) {
        String sql = """
                SELECT `Usuarios`.*, `Empresa`.`Nombre`  FROM Usuarios
                JOIN `Empresa` ON `Empresa`.`IdEmpresa` = `Usuarios`.`IdEmpresa` WHERE Usuarios.Documento = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoGuarda);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int documento = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String contrasenia = resultSet.getString(3);
                boolean activo = resultSet.getBoolean(4);
                String  idEmpresa = resultSet.getString(6);
                String  nombreEmpresa = resultSet.getString(7);
                Empresa empresa = new Empresa(idEmpresa, nombreEmpresa);
                return new Guarda(documento, nombre,contrasenia,activo,empresa);
            }

            System.out.println("Empresa obtenida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
