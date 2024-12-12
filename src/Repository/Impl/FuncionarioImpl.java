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
                INSERT INTO `Persona`(`Documento`,`Nombre`,`Activo`,`Tipo`,`Estado`,`IdEmpresa`,`haSalido`) VALUES
                (?,?,TRUE,"Trabajador","Permitido",?,FALSE);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trabajador.getDocumento());
            ps.setString(2, trabajador.getNombre());
            ps.setString(3, trabajador.getEmpresa().getIdEmpresa());
            ps.executeUpdate();

            System.out.println("Trabajador creado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearInvitado(Invitado invitado) {
        String sql = """
                INSERT INTO `Persona`(`Documento`,`Nombre`,`Activo`,`Tipo`,`Estado`,`IdEmpresa`,`haSalido`) VALUES
                (?,?,TRUE,"Invitado","Permitido",?,FALSE);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, invitado.getDocumento());
            ps.setString(2, invitado.getNombre());
            ps.setString(3, invitado.getEmpresa().getIdEmpresa());
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
                    SELECT `Persona`.*, empresa.`Nombre`, empresa.idEmpresa FROM `Persona`
                    JOIN empresa ON empresa.`IdEmpresa` = `Persona`.`IdEmpresa`
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
                String nombreEmpresa = resultSet.getString(8);
                String idEmpresa = resultSet.getString(9);
                boolean haSalido = resultSet.getBoolean(7);
                Empresa empresa = new Empresa(idEmpresa,nombreEmpresa);
                if (tipo.equals("Invitado")){
                    Invitado invitado = new Invitado(id, nombre, activo, estado, empresa, haSalido);
                    persons.add(invitado);
                }else{
                    Trabajador trabajador = new Trabajador(id, nombre, activo, estado, empresa, haSalido);
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
                    return new Invitado(documento, nombre, activo, estado, empresa, haSalido);
                }else{
                    return new Trabajador(documento, nombre, activo, estado, empresa, haSalido);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
