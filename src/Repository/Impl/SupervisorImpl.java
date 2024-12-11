package Repository.Impl;

import Model.*;
import Repository.DAO.SupervisorDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

public class SupervisorImpl implements SupervisorDAO {

    @Override
    public void crearFuncionario(Funcionario funcionario) {
        String sql = """
                INSERT INTO `Usuarios`(Documento,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
                (?,?,?,TRUE,4,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getDocumento());
            ps.setString(2, funcionario.getNombre());
            ps.setString(3, funcionario.getContrasenia());
            ps.setString(4, funcionario.getEmpresa().getIdEmpresa());
            ps.executeUpdate();

            System.out.println("Funcionario agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void desactivarFuncionario(Funcionario funcionario) {
        String sql = """
                UPDATE `Usuarios` SET `Activo` = FALSE WHERE `IdUsuario`= ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getDocumento());
            ps.executeUpdate();
            System.out.println("Funcionario desactivado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Funcionario mostrarFuncionario(int documentoSupervisor) {
        String sql = """
            SELECT U.Nombre, Documento, E.Nombre, E.IdEmpresa FROM `Usuarios` U
            JOIN `Empresa` E
            ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
            WHERE U.IdTipoUsuario = 4 AND U.Documento = ? ;
        """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoSupervisor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Empresa empresa = new Empresa(rs.getString("IdEmpresa"),rs.getString("Nombre"));
                return new Funcionario(
                        rs.getInt(1),
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

    @Override
    public void crearGuarda(Guarda guarda) {
        String sql = """
                INSERT INTO `Usuarios`(Documento,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
                (?,?,?,TRUE,3,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, guarda.getDocumento());
            ps.setString(2, guarda.getNombre());
            ps.setString(3, guarda.getContrasenia());
            ps.setString(4, guarda.getEmpresa().getIdEmpresa());
            ps.executeUpdate();

            System.out.println("Guarda agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarGuarda(Guarda guarda) {
        String sql = """
           UPDATE `Usuarios` SET `Activo` = FALSE WHERE `IdUsuario`= ?;
           """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, guarda.getDocumento());
            ps.executeUpdate();
            System.out.println("Guarda desactivado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
                Guarda guarda = new Guarda(documento, nombre,contrasenia,activo,empresa);
                return guarda;
            }

            System.out.println("Empresa obtenida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void crearAnotaciones(Anotacion anotacion) {
        String sql = """
                INSERT INTO `Anotaciones`(Documento,`Tipo`,`Mensaje`,`Fecha`) VALUES
                (?,?,?,?,?,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            Persona persona = anotacion.getPersona();
            ps.setString(1, persona.getNombre());
            ps.setString(2, anotacion.getTipoAnotacion());
            ps.setString(3, anotacion.getMensajeAnot());
            ps.setDate(4, anotacion.getFecha());
            ps.executeUpdate();
            System.out.println("Anotación agregada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void levantarRestriccion(int documentoPersona) {
        String sql = """
                UPDATE `Persona` SET `Estado` = "Permitido" WHERE `Documento` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoPersona);
            ps.executeUpdate();
            System.out.println("Restriccion levantada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void RegistrarSalida(int Documento) {

    }

    @Override
    public void RegistrarSalidaVehiculo(int cantidadPersonas, String placa) {

    }
}


