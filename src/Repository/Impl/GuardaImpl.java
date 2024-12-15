package Repository.Impl;

import Model.*;
import Repository.DAO.GuardaDAO;
import Util.DataBaseConnection;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class GuardaImpl implements GuardaDAO {

    @Override
    public void crearRegistroEntradaPersona(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
                (?,NOW(),?,NULL,"Entrada",?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            if (vehiculo==null){
                ps.setString(3, null);
            }else{
                ps.setString(3, vehiculo.getPlaca());
            }
            System.out.println(ps);
            ps.executeUpdate();

            System.out.println("Registro ingresado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La placa o las personas no existen o fueron ingresadas incorrectamente");
            throw new RuntimeException(e);
        }
    }
    @Override
    public void crearRegistroSalidaPersona(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
                (?,NOW(),?,NULL,"Salida",?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            if (vehiculo==null){
                ps.setString(3, null);
            }else{
                ps.setString(3, vehiculo.getPlaca());
            }
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
            boolean tieneAnotaciones = false;
            while (resultSet.next()) {
                tieneAnotaciones = true;
                anotaciones.append("Anotaciones de la persona:\n")
                        .append("Documento: ").append(resultSet.getInt("Documento")).append("\n")
                        .append("Nombre: ").append(resultSet.getString("Nombre")).append("\n")
                        .append("Estado: ").append(resultSet.getString("Estado")).append("\n")
                        .append("Empresa: ").append(resultSet.getString("IdEmpresa")).append("\n")
                        .append("Id Anotacion: ").append(resultSet.getInt("IdAnotacion")).append("\n")
                        .append("Tipo: ").append(resultSet.getString("Tipo")).append("\n")
                        .append("Mensaje: ").append(resultSet.getString("Mensaje")).append("\n")
                        .append("Fecha: ").append(resultSet.getDate("Fecha")).append("\n")
                        .append("------------------------------------------------\n")
                ;
            }

            if (!tieneAnotaciones){
                anotaciones.append("No se encontraron anotaciones para la persona.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener anotaciones de la persona", e);
        }

        return anotaciones.toString();
    }
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
