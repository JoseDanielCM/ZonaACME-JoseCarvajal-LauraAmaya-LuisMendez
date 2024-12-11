package Repository.Impl;

import Model.*;
import Repository.DAO.FuncionarioDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            ps.setInt(3, trabajador.getEmpresa().getIdEmpresa());
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
            ps.setInt(3, invitado.getEmpresa().getIdEmpresa());
            ps.executeUpdate();

            System.out.println("Invitado agregado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarPersona(Persona persona) {
        String sql = """
                UPDATE `Persona` SET `Activo` = FALSE WHERE `IdUsuario`= ?;
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
                SELECT * FROM `Persona` WHERE `Activo` = TRUE;
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
                boolean haSalido = resultSet.getBoolean(7);
                Empresa empresa = new Empresa(nombreEmpresa);
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
                SELECT * FROM `Persona` WHERE `IdPersona` = ?;
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
}
