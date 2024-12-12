package Repository.Impl;

import Model.*;
import Repository.DAO.GuardaDAO;
import Util.DataBaseConnection;

import java.sql.*;
import java.util.List;

public class GuardaImpl implements GuardaDAO {

    @Override
    public void crearRegistro(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro` VALUES
                (?,NOW(),?,NULL,"Entrada",NULL);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            ps.executeUpdate();

            System.out.println("Registro ingresado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void mostrarAnotacionesPersonas(int documento) {
        String sql = """
                SELECT `Persona`.`Documento`,`Persona`.`Nombre`,`Persona`.`Estado`,`Persona`.`IdEmpresa`,`Anotaciones`.`IdAnotacion`,`Anotaciones`.`Tipo`,`Anotaciones`.`Mensaje`,`Anotaciones`.`Fecha` FROM `Persona`
                JOIN `Anotaciones` ON `Anotaciones`.`Documento` = `Persona`.`Documento`
                where `Persona`.`Documento` =  ?;
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, documento);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                System.out.println("Anotaciones de la persona:");
                System.out.println("Documento: " + resultSet.getInt("Documento"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Estado: " + resultSet.getString("Estado"));
                System.out.println("Empresa: " + resultSet.getString("IdEmpresa"));
                System.out.println("Id Anotacion: " + resultSet.getInt("IdAnotacion"));
                System.out.println("Tipo: " + resultSet.getString("Tipo"));
                System.out.println("Mensaje: " + resultSet.getString("Mensaje"));
                System.out.println("Fecha: " + resultSet.getDate("Fecha"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearRegistroVehiculo(Persona persona, Guarda guarda, Vehiculo vehiculo) {
        String sql = """
                INSERT INTO `Registro` VALUES
                (?,NOW(),?,NULL,"Entrada",?);
                """;
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, persona.getDocumento());
            ps.setInt(2, guarda.getDocumento());
            ps.setString(3, vehiculo.getPlaca());
            ps.executeUpdate();

            System.out.println("Registro con carro ingresado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registrarVehiculo(String placa, List<Persona> personas, Guarda guarda) {
        for (int i = 0; i < personas.size(); i++) {
            crearRegistroVehiculo(personas.get(i), guarda, placa);
        }
    }

    @Override
    public void RegistrarSalida(int Documento, Date fecha, int documentoUser) {
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
                ps.setDate(4, fecha);
                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Registro correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
                    return new Invitado(documento, nombre, activo, estado, empresa, haSalido);
                }else{
                    return new Trabajador(documento, nombre, activo, estado, empresa, haSalido);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void RegistrarSalidaVehiculo(int cantidadPersonas, String placa) {

    }


}
