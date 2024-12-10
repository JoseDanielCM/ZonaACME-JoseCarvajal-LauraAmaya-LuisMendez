package Repository.Impl;

import Model.Supervisor;
import Repository.DAO.SuperUsuarioDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Types.NULL;

public class SuperUsuarioImpl implements SuperUsuarioDAO {
    @Override
    public void addSupervisor(Supervisor supervisor) {
        String sql = """
                INSERT INTO `Usuarios`(`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
                (?,?,TRUE,1,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, supervisor.getNombre());
            ps.setString(2, supervisor.getContrasenia());
            if (supervisor.getEmpresa() != null){
                ps.setInt(3, supervisor.getEmpresa().getIdEmpresa());
            }else{
                ps.setNull(3, NULL);

            }
            ps.executeUpdate();

            System.out.println("Supervisor agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getSupervisorById(int idSupervisor) {

    }

    @Override
    public void getAllSupervisors() {

    }

    @Override
    public void desactivarSupervisor(Supervisor supervisor) {

    }
}
