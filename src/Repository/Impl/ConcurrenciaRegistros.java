package Repository.Impl;

import Model.Usuario;
import Util.DataBaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcurrenciaRegistros {

    private void mostrarRegistro(JTextArea areaTexto, Usuario usuario, Connection conexion) {
        new Thread(()->{
            try {
                while (true){
                    actualizarAreaTexto(areaTexto, usuario, conexion);
                    Thread.sleep(10000);
                }
            } catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Problemas con el proceso de concurrencia "+ e.getMessage());
            }}).start();
    }

    private void actualizarAreaTexto(JTextArea areaTexto, Usuario usuario, Connection conexion){
        String sql = "SELECT * FROM Registro WHERE TipoRegistro = ? AND Fecha > NOW() - INTERVAL 10 SECOND";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, "Entrada");
            ResultSet rs = ps.executeQuery();

            StringBuilder nuevosRegistros = new StringBuilder();

            while (rs.next()){
                String id = rs.getString("IdRegistro");
                String documento = rs.getString("Documento");
                String fecha = rs.getString("Fecha");
                String usuarioDoc = rs.getString("DocUser");
                String idAnotacion = rs.getString("IdAnotacion");
                String placa = rs.getString("PlacaVehiculo");

                nuevosRegistros.append(String.format("Numero: %s, Documento: %s, Fecha/Hora: %s, Hecho por: %s, Número Anotación: %s, Vehiculo: %s \n", id, documento, fecha, usuarioDoc, idAnotacion, placa));

            }

            SwingUtilities.invokeLater(() -> areaTexto.replaceSelection(nuevosRegistros.toString()));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void manejoRegistros(JTextArea areaTexto, Usuario usuario){
        SwingUtilities.invokeLater(() -> {
            Connection conexion = DataBaseConnection.getConnection();
            ConcurrenciaRegistros actualizador = new ConcurrenciaRegistros();

            actualizador.actualizarAreaTexto(areaTexto, usuario, conexion);
        });
    }

}