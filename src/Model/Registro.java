package Model;

import java.time.format.DateTimeFormatter;

public class Registro {
    private int documento;
    private String fecha;
    private int documentoUsuario;
    private String tipo;

    public Registro(int documento, String fecha, int documentoUsuario, String tipo) {
        this.documento = documento;
        this.fecha = fecha;
        this.documentoUsuario = documentoUsuario;
        this.tipo = tipo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(int documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "documento=" + documento +
                ", fecha='" + fecha + '\'' +
                ", documentoUsuario=" + documentoUsuario +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
