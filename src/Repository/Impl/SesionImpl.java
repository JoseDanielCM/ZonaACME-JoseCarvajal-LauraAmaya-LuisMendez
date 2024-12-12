package Repository.Impl;

import Model.*;
import Repository.DAO.SesionDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SesionImpl implements SesionDAO {
    @Override
    public Sesion buscarUsuario(int username, String password) {
        String sql = """
SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= ? AND Usuarios.`Contrasena` = ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,username);
            ps.setString(2,password);
            System.out.println(ps);
            ResultSet resultSet= ps.executeQuery();
            if (resultSet.next()) {
                // EMPRESA
                String nitEmpresa = resultSet.getString("IdEmpresa");
                String nombreEmpresa = resultSet.getString("NombreEmpresa");
                Empresa empresa = new Empresa(nitEmpresa,nombreEmpresa);

                // USER
                int id = resultSet.getInt("Documento");
                String nombre = resultSet.getString("Nombre");
                String contrasena = resultSet.getString("Contrasena");
                boolean activo = resultSet.getBoolean("Activo");
                String tipoUser = resultSet.getString("NombreTipo");

                //CASOS
                Sesion sesion;
                switch (tipoUser){
                    case "SuperUsuario":
                        SuperUsuario superUsuario = new SuperUsuario(id, nombre,contrasena,activo,empresa);
                        sesion = new Sesion(superUsuario);
                        return sesion;
                    case "Supervisor":
                        SuperUsuario supervisor = new SuperUsuario(id, nombre,contrasena,activo,empresa);
                        sesion = new Sesion(supervisor);
                        return sesion;
                    case "Guarda":
                        SuperUsuario guarda = new SuperUsuario(id, nombre,contrasena,activo,empresa);
                        sesion = new Sesion(guarda);
                        return sesion;
                    case "Funcionario":
                        SuperUsuario funcionario = new SuperUsuario(id, nombre,contrasena,activo,empresa);
                        sesion = new Sesion(funcionario);
                        return sesion;
                    default:
                        System.out.println("Tipo de usuario no reconocido");
                        return null;
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
