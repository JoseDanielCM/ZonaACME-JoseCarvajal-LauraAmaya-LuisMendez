package Repository.Impl;

import Model.*;
import Repository.DAO.FuncionarioDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioImpl implements FuncionarioDAO {
    @Override
    public void crearTrabajador(Trabajador trabajador) {
        String sql = """
                INSERT INTO `Persona`(`Documento`,`Nombre`,`Activo`,`Tipo`,`Estado`,`IdEmpresa`,`haSalido`,`PlacaVehiculo`) VALUES
                (?,?,TRUE,"Trabajador","Permitido",?,FALSE,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trabajador.getDocumento());
            ps.setString(2, trabajador.getNombre());
            ps.setString(3, trabajador.getEmpresa().getIdEmpresa());
            ps.setString(4, trabajador.getVehiculo().getPlaca());
            ps.executeUpdate();

            System.out.println("Trabajador creado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearInvitado(Invitado invitado) {
        String sql = """
                INSERT INTO `Persona`(`Documento`,`Nombre`,`Activo`,`Tipo`,`Estado`,`IdEmpresa`,`haSalido`,`PlacaVehiculo`) VALUES
                (?,?,TRUE,"Invitado","Permitido",?,FALSE,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, invitado.getDocumento());
            ps.setString(2, invitado.getNombre());
            ps.setString(3, invitado.getEmpresa().getIdEmpresa());
            ps.setString(4, invitado.getVehiculo().getPlaca());
            System.out.println(ps);
            ps.executeUpdate();

            System.out.println("Invitado agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarPersona(Persona persona) {
        String sql = """
                UPDATE `Persona` SET `Activo` = FALSE WHERE `Documento`= ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.executeUpdate();
            System.out.println("Persona desactivada correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Persona> mostrarActivos() {
        String sql = """
                    SELECT `Persona`.*, e.`Nombre` FROM `Persona`
                    JOIN Empresa e ON e.`IdEmpresa` = `Persona`.`IdEmpresa`
                    WHERE `Persona`.`Activo` = TRUE;
                """;
        List<Persona> persons = new ArrayList<Persona>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                boolean activo = resultSet.getBoolean(3);
                String tipo = resultSet.getString(4);
                String estado = resultSet.getString(5);
                String idEmpresa = resultSet.getString(6);
                String nombreEmpresa = resultSet.getString(9);
                boolean haSalido = resultSet.getBoolean(7);
                String placaVehiculo = resultSet.getString(8);
                Empresa empresa = new Empresa(idEmpresa,nombreEmpresa);
                Vehiculo vehiculo = new Vehiculo(placaVehiculo,"Permitido",haSalido);
                if (tipo.equals("Invitado")){
                    Invitado invitado = new Invitado(id, nombre, activo, estado, empresa, haSalido, vehiculo);
                    persons.add(invitado);
                }else{
                    Trabajador trabajador = new Trabajador(id, nombre, activo, estado, empresa, haSalido, vehiculo);
                    persons.add(trabajador);
                }
            }
            System.out.println("Lista de activos seleccionados automaticamente");
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String estadoActualPersona(Persona persona) {
        String sql = """
                SELECT * FROM `Persona` WHERE `Documento` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ResultSet resultSet= ps.executeQuery();
            return resultSet.getString(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearAnotacion(Anotacion anotacion, int documento) {
        return;
    }

    @Override
    public void RegistrarSalida(int Documento, Date fecha, int documentoUser) {
        if(getPersonaById(Documento) == null){
            System.out.println("Usuario no encontrado");
        } else {
            String sql = """
            INSERT INTO `Anotaciones`(`Documento`,DocUser,`Tipo`,`Mensaje`,`Fecha`) VALUES
            (?,?,"Registro",?,?);
            """;
            try (Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Documento);
                ps.setInt(2, documentoUser);
                ps.setString(3, "Persona identificada con el documento: " + Documento + " ha registrado salida manual");
                ps.setDate(4, fecha);
                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Registro correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void RegistrarSalidaVehiculo(int cantidadPersonas, String placa) {}

    @Override
    public Persona getPersonaById(int id) {
        String sql = """
                SELECT `Persona`.*, e.`Nombre` FROM `Persona`
                JOIN Empresa e ON e.`IdEmpresa` = `Persona`.`IdEmpresa`
                WHERE Persona.`Documento` = ?;

                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString(2);
                boolean activo = resultSet.getBoolean(3);
                String tipo = resultSet.getString(4);
                String estado = resultSet.getString(5);
                String idEmpresa = resultSet.getString(6);
                String nombreEmpresa = resultSet.getString(9);
                boolean haSalido = resultSet.getBoolean(7);
                String placaVehiculo = resultSet.getString(8);
                Empresa empresa = new Empresa(idEmpresa,nombreEmpresa);
                Vehiculo vehiculo = new Vehiculo(placaVehiculo,"Permitido",haSalido);
                if (tipo.equals("Invitado")){
                    return new Invitado(id, nombre, activo, estado, empresa, haSalido, vehiculo);
                }else{
                    return new Trabajador(id, nombre, activo, estado, empresa, haSalido, vehiculo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Empresa getEmpresaFuncionario(int idFuncionario) {
        String sql = """
                SELECT E.`IdEmpresa`, E.`Nombre` FROM Usuarios AS U
                JOIN Empresa as E ON E.`IdEmpresa` = U.`IdEmpresa`
                WHERE U.`Documento` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idFuncionario);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                Empresa empresa = new Empresa(id,nombre);
                return empresa;
            }

            System.out.println("Empresa obtenida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return null;
    }
}
