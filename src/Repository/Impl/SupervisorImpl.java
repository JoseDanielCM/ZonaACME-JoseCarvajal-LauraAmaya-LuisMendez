package Repository.Impl;

import Model.Empresa;
import Model.Funcionario;
import Model.Guarda;
import Model.Supervisor;
import Repository.DAO.SupervisorDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisorImpl implements SupervisorDAO {

    @Override
    public void crearFuncionario(Funcionario funcionario) {
        String sql = """
                INSERT INTO `Usuarios`(Documento,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
                (?,?,?,TRUE,4,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.setString(2, funcionario.getNombre());
            ps.setString(3, funcionario.getContrasenia());
            ps.setInt(4, funcionario.getEmpresa().getIdEmpresa());
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
            ps.setInt(1, funcionario.getId());
            ps.executeUpdate();
            System.out.println("Funcionario desactivado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Funcionario mostrarFuncionario(int documentoSupervisor) {
        String sql = """
            SELECT U.Nombre, Documento, E.Nombre FROM `Usuarios` U
            JOIN `Empresa` E
            ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
            WHERE U.IdTipoUsuario = 4 AND u.Documento = ? ;
        """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoSupervisor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Empresa empresa = new Empresa(rs.getString("NombreEmpresa"));
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

    }

    @Override
    public void desactivarGuarda(Guarda guarda) {
        String sql = """
           UPDATE `Usuarios` SET `Activo` = FALSE WHERE `IdUsuario`= ?;
           """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, guarda.getId());
            ps.executeUpdate();
            System.out.println("Guarda desactivado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public Guarda mostrarGuarda(int documentoGuarda) {
        String sql = """
                SELECT * FROM Usuario WHERE Usuario.Dcoumento = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoGuarda);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int documento = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                Empresa empresa = new Empresa(id, nombre);
                return empresa;
                /*    protected int id;
    protected String nombre;
    protected String contrasenia;
    protected boolean activo;
    protected Empresa empresa;*/
            }

            System.out.println("Empresa obtenida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void crearAnotaciones(int documentoPersona) {

    }

    @Override
    public void levantarRestriccion(int documentoPersona) {


    }
}
