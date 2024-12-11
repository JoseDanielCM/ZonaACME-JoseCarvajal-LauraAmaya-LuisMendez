package Repository.Impl;

import Model.*;
import Repository.DAO.GuardaDAO;
import Util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuardaImpl implements GuardaDAO {

    @Override
    public void crearRegistro(Persona persona, Guarda guarda) {
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

    }

    @Override
    public void registrarVehiculo(String placa, int cantidadPersonas) {

    }

    @Override
    public void registrarSalida(int documento) {

    }

    @Override
    public void RegistrarSalida(int Documento) {

    }

    @Override
    public void RegistrarSalidaVehiculo(int cantidadPersonas, String placa) {

    }


}
