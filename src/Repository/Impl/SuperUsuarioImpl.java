package Repository.Impl;

import Model.Supervisor;
import Repository.DAO.SuperUsuarioDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuperUsuarioImpl implements SuperUsuarioDAO {
    @Override
    public void addSupervisor(Supervisor supervisor) {
        String sql = "INSERT INTO";
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
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
