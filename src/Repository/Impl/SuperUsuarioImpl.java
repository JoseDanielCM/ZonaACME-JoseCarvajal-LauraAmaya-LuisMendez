package Repository.Impl;

import Model.Empresa;
import Model.Supervisor;
import Repository.DAO.SuperUsuarioDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class SuperUsuarioImpl implements SuperUsuarioDAO {
    @Override
    public void addSupervisor(Supervisor supervisor) {
        String sql = """
                INSERT INTO `Usuarios`(Documento,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
                (?,?,?,TRUE,2,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, supervisor.getDocumento());
            ps.setString(2, supervisor.getNombre());
            ps.setString(3, supervisor.getContrasenia());
            ps.setString(4, supervisor.getEmpresa().getIdEmpresa());
            ps.executeUpdate();

            System.out.println("Supervisor agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addEmpresa(Empresa empresa) {
        String sql = """
                INSERT INTO `Empresa` VALUES
                (?,TRUE);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, empresa.getNombre());

            System.out.println("Empresa creada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Supervisor getSupervisorById(int idSupervisor) {
        String sql = """
            SELECT *
            FROM Usuarios u
            JOIN TipoUsuario t ON u.IdTipoUsuario = t.IdTipo
            WHERE t.Nombre = 'Supervisor' AND u.Documento = ?;
        """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSupervisor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new Supervisor(
                        rs.getInt(1),
                        rs.getString("Nombre"),
                        rs.getString("Contrasena"),
                        rs.getBoolean("Activo"),
                        getEmpresaById(rs.getInt("IdEmpresa"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Supervisor> getAllSupervisors() {
        String sql = """
                SELECT * FROM Usuarios WHERE Usuarios.IdTipoUsuario = 2;
                """;
        List<Supervisor> listSupervisors = new ArrayList<Supervisor>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String contrasenia = resultSet.getString(3);
                boolean activo = resultSet.getBoolean(4);
                int idTipoUsuario = resultSet.getInt(5);
                int idEmpresa = resultSet.getInt(6);
                Empresa empresa = getEmpresaById(idEmpresa);
                Supervisor supervisor = new Supervisor(id,nombre, contrasenia, activo, empresa);
                listSupervisors.add(supervisor);
            }

            System.out.println("Supervisor traido correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSupervisors;
    }

    @Override
    public Empresa getEmpresaById(int idEmpresa) {
        String sql = """
                SELECT * FROM Empresa WHERE Empresa.IdEmpresa = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEmpresa);
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
    public Empresa getEmpresaByName(String name) {
        String sql = """
                SELECT * FROM Empresa WHERE Empresa.Nombre = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                Empresa empresa = new Empresa(id,nombre);
                System.out.println("Empresa obtenida correctamente");
                return empresa;
            }
            throw new IllegalArgumentException  ("Empresa no encontrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarSupervisor(Supervisor supervisor) {
        String sql = """
                UPDATE `Usuarios` SET `Activo` = FALSE WHERE `IdUsuario`= ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, supervisor.getDocumento());
            ps.executeUpdate();
            System.out.println("Supervisor desactivado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarEmpresa(Empresa empresa) {
        String sql = """
                UPDATE `Empresa` SET `Activo` = FALSE WHERE `Nombre`= ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, empresa.getNombre());
            ps.executeUpdate();
            System.out.println("Empresa desactivada correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void setIp(String ip) {
        DataBaseConnection.setIp(ip);
    }
}
