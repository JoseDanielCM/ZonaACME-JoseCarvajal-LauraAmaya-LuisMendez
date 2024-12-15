package Repository.Impl;

import Model.*;
import Repository.DAO.SuperUsuarioDAO;
import Util.DataBaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                (?,?,TRUE);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(empresa.getIdEmpresa()));
            ps.setString(2, empresa.getNombre());
            System.out.println(ps);
            ps.executeUpdate();
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
                SELECT `Usuarios`.*, empresa.`Nombre` as NombreEmpresa FROM Usuarios
                JOIN empresa ON empresa.`IdEmpresa` = `Usuarios`.`IdEmpresa`
                WHERE Usuarios.IdTipoUsuario = 2;
                """;
        List<Supervisor> listSupervisors = new ArrayList<Supervisor>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String contrasenia = resultSet.getString(3);
                boolean activo = resultSet.getBoolean(4);
                int idTipoUsuario = resultSet.getInt(5);
                String idEmpresa = resultSet.getString(6);
                String nombreEmpresa = resultSet.getString(7);

                Empresa empresa = new Empresa(idEmpresa,nombreEmpresa);
                Supervisor supervisor = new Supervisor(id,nombre, contrasenia, activo, empresa);
                listSupervisors.add(supervisor);
            }
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
            if (resultSet.next()){
                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                Empresa empresa = new Empresa(id,nombre);
                return empresa;
            }
            JOptionPane.showMessageDialog(null,"Empresa no encontrada");
            throw new IllegalArgumentException  ("Empresa no encontrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empresa getEmpresaByName(String name) {
        String sql = """
                SELECT * FROM Empresa WHERE Empresa.Nombre = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                String id = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                Empresa empresa = new Empresa(id,nombre);
                System.out.println("Empresa obtenida correctamente");
                return empresa;
            }
            JOptionPane.showMessageDialog(null,"Empresa no encontrada");
            throw new IllegalArgumentException  ("Empresa no encontrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desactivarSupervisor(Supervisor supervisor) {
        String sql = """
                UPDATE `Usuarios` SET `Activo` = FALSE WHERE `Documento`= ?;
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

    @Override
    public String getIp() {
        return DataBaseConnection.getIp();
    }

    @Override
    public List<Persona> getAllPersonasEmpresa(int nit) {
        String sql = """
                SELECT persona.*, Empresa.`Nombre` as NombreEmpresa FROM persona
                JOIN empresa ON empresa.`IdEmpresa` = persona.`IdEmpresa`
                WHERE persona.`IdEmpresa`= ?;
                """;
        List<Persona> listPersonas = new ArrayList<Persona>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nit);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Documento");
                String nombre = resultSet.getString("Nombre");
                String tipo = resultSet.getString("Tipo");
                String idEmpresa = resultSet.getString("IdEmpresa");
                String nombreEmpresa = resultSet.getString("NombreEmpresa");

                Empresa empresa = new Empresa(idEmpresa,nombreEmpresa);
                if (tipo.equals("Trabajador")){
                    Trabajador persona = new Trabajador(id,nombre,true,tipo,empresa,false,null) ;
                    listPersonas.add(persona);
                }else{
                    Invitado persona = new Invitado(id,nombre,true,tipo,empresa,false,null) ;
                    listPersonas.add(persona);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se encontró Empresa con ese nit");
            throw new RuntimeException(e);
        }
        return listPersonas;
    }

    @Override
    public List<Registro> getListaRegistros(String inicial, String finalDate) {
        String sql = """
                SELECT * FROM Registro
                WHERE Fecha BETWEEN ? AND ?;
                """;
        List<Registro> listRegistros = new ArrayList<Registro>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, inicial);
            ps.setString(2, finalDate);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Documento");
                String fecha = resultSet.getString("Fecha");
                int documentoUser = resultSet.getInt("DocUser");
                String tipo = resultSet.getString("TipoRegistro");

                Registro registro = new Registro(id,fecha,documentoUser,tipo);
                listRegistros.add(registro);
            }
            return listRegistros;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ingresar fechas con el formato dado");
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getNombreFuncionarioEmpresa(Empresa empresa) {
        String sql = """
                SELECT usuarios.`Nombre` FROM usuarios
                JOIN empresa ON empresa.`IdEmpresa` = usuarios.`IdEmpresa`
                WHERE usuarios.`IdTipoUsuario` = 4 AND empresa.`Nombre` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, empresa.getNombre());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("Nombre");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ingresar fechas con el formato dado");
            throw new RuntimeException(e);
        }
        return null;
    }
}
