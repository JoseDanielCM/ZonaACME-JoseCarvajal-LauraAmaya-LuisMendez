package Repository.Impl;

import Model.*;
import Repository.DAO.SupervisorDAO;
import Util.DataBaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                UPDATE `Usuarios` SET `Activo` = FALSE WHERE `Documento`= ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getDocumento());
            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("Funcionario desactivado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Funcionario mostrarFuncionario(int documentoFuncionario) {
        String sql = """
            SELECT U.`Documento`, U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
            JOIN `Empresa` E
            ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
            WHERE U.IdTipoUsuario = 4 AND U.Documento = ? ;
        """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoFuncionario);
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
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            int contador = 1;
            while (resultSet.next()) {
                if (contador == 1){
                    anotaciones.append("ANOTACIONES DE LA PERSONA:\n");
                }
                anotaciones.append("Anotacion :"+contador+"\n")
                        .append("Documento: ").append(resultSet.getInt("Documento")).append("\n")
                        .append("Nombre: ").append(resultSet.getString("Nombre")).append("\n")
                        .append("Estado: ").append(resultSet.getString("Estado")).append("\n")
                        .append("Empresa: ").append(resultSet.getString("IdEmpresa")).append("\n")
                        .append("Id Anotacion: ").append(resultSet.getInt("IdAnotacion")).append("\n")
                        .append("Tipo: ").append(resultSet.getString("Tipo")).append("\n")
                        .append("Mensaje: ").append(resultSet.getString("Mensaje")).append("\n")
                        .append("Fecha: ").append(resultSet.getDate("Fecha")).append("\n")
                        .append("------------------------------------------------\n")
                ;
                contador++;
            }
            return anotaciones.toString();
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
           UPDATE `Usuarios` SET `Activo` = FALSE WHERE `Documento`= ?;
           """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, guarda.getDocumento());
            ps.executeUpdate();
            System.out.println("IMPL Guarda desactivado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public Guarda mostrarGuarda(int documentoGuarda) {
        String sql = """
                SELECT U.`Documento`, U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
                JOIN `Empresa` E
                ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
                WHERE U.IdTipoUsuario = 3 AND U.Documento = ? ;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documentoGuarda);
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int documento = resultSet.getInt("Documento");
                String nombre = resultSet.getString("Nombre");
                String contrasenia = resultSet.getString("Contrasena");
                boolean activo = resultSet.getBoolean("Activo");
                String  idEmpresa = resultSet.getString("IdEmpresa");
                String  nombreEmpresa = resultSet.getString("NombreEmpresa");
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
                (?,?,?,?,NOW());
                """;
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            Persona persona = anotacion.getPersona();
            ps.setString(1, String.valueOf(persona.getDocumento()));
            ps.setString(2,anotacion.getDocUser());
            ps.setString(3, anotacion.getTipoAnotacion());
            ps.setString(4, anotacion.getMensajeAnot());
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
    public void RegistrarSalida(int Documento, int documentoUser) {
        if(getPersonaById(Documento) == null){
            System.out.println("Usuario no encontrado");
        } else {
            String sql = """
            INSERT INTO `Anotaciones`(`Documento`,DocUser,`Tipo`,`Mensaje`,`Fecha`) VALUES
            (?,?,"Registro",?,NOW());
            """;
            try (Connection conn = DataBaseConnection.getConnection()){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Documento);
                ps.setInt(2, documentoUser);
                ps.setString(3, "Persona identificada con el documento: " + Documento + " ha sido registrad@ salida manual");
                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Registro correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Usuario> mostrarTodosFuncionariosoGuarda(int tipo) {
        String sql = """
                SELECT U.`Documento`, U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
                JOIN `Empresa` E
                ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
                WHERE U.IdTipoUsuario = ? ;
                """; // 3 guarda 4 funcionario
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tipo);
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int documento = resultSet.getInt("Documento");
                String nombre = resultSet.getString("Nombre");
                String contrasenia = resultSet.getString("Contrasena");
                boolean activo = resultSet.getBoolean("Activo");
                String  idEmpresa = resultSet.getString("IdEmpresa");
                String  nombreEmpresa = resultSet.getString("NombreEmpresa");
                Empresa empresa = new Empresa(idEmpresa, nombreEmpresa);
                if (tipo==3){
                    Guarda guarda = new Guarda(documento, nombre,contrasenia,activo,empresa);
                    usuarios.add(guarda);
                }else {
                    Funcionario funcionario = new Funcionario(documento, nombre,contrasenia,activo,empresa);
                    usuarios.add(funcionario);
                }
            }
            return usuarios;
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


