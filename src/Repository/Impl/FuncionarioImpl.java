package Repository.Impl;

import Model.*;
import Repository.DAO.FuncionarioDAO;
import Util.DataBaseConnection;

import javax.swing.*;
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
                Vehiculo vehiculo = new Vehiculo(placaVehiculo);
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
    public void RegistrarSalidaManual(Persona persona, Funcionario funcionario) {
        if(persona == null){
            System.out.println("Usuario no encontrado");
        } else {
            String sql = """
            INSERT INTO `Anotaciones`(`Documento`,DocUser,`Tipo`,`Mensaje`,`Fecha`) VALUES
            (?,?,"Registro",?,NOW());
            """;
            try (Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, persona.getDocumento());
                ps.setInt(2, funcionario.getDocumento());
                ps.setString(3, "Persona identificada con el documento: " + persona.getDocumento() + " ha registrado salida manual");
                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Registro correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

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
                Vehiculo vehiculo = new Vehiculo(placaVehiculo);
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
    public void crearVehiculo(Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Vehiculo`(`Placa`, `Estado`,`haSalido`) VALUES
                (?,"Permitido",TRUE);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  vehiculo.getPlaca());
            System.out.println(ps);
            ps.executeUpdate();

            System.out.println("Vehículo creado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePersona(String newName, String newPlaca, int documento) {
        String sql = """
                UPDATE `Persona` SET `Nombre` = ?, `PlacaVehiculo` = ?  WHERE `Documento` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  newName);
            ps.setString(2,  newPlaca);
            ps.setInt(3,  documento);
            System.out.println(ps);
            ps.executeUpdate();

            System.out.println("Persona actualizada correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateVehiculoPlaca(String newPlaca, String oldPlaca) {
        String sql = """
                UPDATE `Vehiculo` SET `Placa` = ? WHERE `Placa` = ?;
                  """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,  newPlaca);
            ps.setString(2,  oldPlaca);
            System.out.println(ps);
            ps.executeUpdate();

            System.out.println("Placa actualizada");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Funcionario mostrarFuncionario(int documentoFuncionario) {
        String sql = """
            SELECT U.*, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
            JOIN `Empresa` E
            ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
            WHERE U.IdTipoUsuario = 4 AND U.Documento = ? ;
        """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoFuncionario);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Empresa empresa = new Empresa(rs.getString("IdEmpresa"),rs.getString("NombreEmpresa"));
                return new Funcionario(
                        rs.getInt("Documento"),
                        rs.getString("Nombre"),
                        rs.getString("Contrasena"),
                        rs.getBoolean("Activo"),
                        empresa
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
