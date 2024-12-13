package Repository.Impl;

import Model.*;
import Repository.DAO.SupervisorDAO;
import Util.DataBaseConnection;
import java.sql.*;

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
    public Funcionario mostrarFuncionario(int documentoFuncionario) {
        String sql = """
            SELECT U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
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

    @Override
    public String mostrarAnotacionesPersonas(Persona persona) {
        if (persona == null || persona.getDocumento() == 0) {
            return "Información de la persona no válida.";
        }

        StringBuilder anotaciones = new StringBuilder();
        String sql = """
                SELECT Persona.Documento, Persona.Nombre, Persona.Estado, Persona.IdEmpresa,
                       Anotaciones.IdAnotacion, Anotaciones.Tipo, Anotaciones.Mensaje, Anotaciones.Fecha 
                FROM Persona
                JOIN Anotaciones ON Anotaciones.Documento = Persona.Documento
                WHERE Persona.Documento = ?;
                """;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, persona.getDocumento());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                anotaciones.append("Anotaciones de la persona:\n")
                        .append("Documento: ").append(resultSet.getInt("Documento")).append("\n")
                        .append("Nombre: ").append(resultSet.getString("Nombre")).append("\n")
                        .append("Estado: ").append(resultSet.getString("Estado")).append("\n")
                        .append("Empresa: ").append(resultSet.getString("IdEmpresa")).append("\n")
                        .append("Id Anotacion: ").append(resultSet.getInt("IdAnotacion")).append("\n")
                        .append("Tipo: ").append(resultSet.getString("Tipo")).append("\n")
                        .append("Mensaje: ").append(resultSet.getString("Mensaje")).append("\n")
                        .append("Fecha: ").append(resultSet.getDate("Fecha")).append("\n");
                return anotaciones.toString();

            } else {
                System.out.println("No se encontraron anotaciones para la persona.");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener anotaciones de la persona", e);
        }

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
                INSERT INTO `Anotaciones`(Documento, docUser,`Tipo`,`Mensaje`,`Fecha`) VALUES
                (?,?,?,?,?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            Persona persona = anotacion.getPersona();
            ps.setString(1, String.valueOf(persona.getDocumento()));
            ps.setString(2,anotacion.getDocUser());
            ps.setString(3, anotacion.getTipoAnotacion());
            ps.setString(4, anotacion.getMensajeAnot());
            ps.setTimestamp(5, anotacion.getFecha());
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
                     return new Invitado(documento, nombre, activo, estado, empresa, haSalido, null);
                }else{
                    return new Trabajador(documento, nombre, activo, estado, empresa, haSalido, null);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void RegistrarSalida(int Documento, Timestamp fecha, int documentoUser) {
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
                ps.setTimestamp(4, fecha);
                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Registro correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
    public void RegistrarSalidaVehiculo(int cantidadPersonas, String placa) {

    }

}


