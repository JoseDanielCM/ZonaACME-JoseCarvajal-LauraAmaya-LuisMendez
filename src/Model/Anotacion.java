package Model;

import java.sql.Date;

public class Anotacion {
    private int idAnotacion;
    private Persona persona;
    private String tipoAnotacion;
    private String mensajeAnot;
    private Date fecha;

    public Anotacion(int idAnotacion, Persona persona, String tipoAnotacion, String mensajeAnot, Date fecha) {
        this.idAnotacion = idAnotacion;
        this.persona = persona;
        this.tipoAnotacion = tipoAnotacion;
        this.mensajeAnot = mensajeAnot;
        this.fecha = fecha;
    }

    public int getIdAnotacion() {
        return idAnotacion;
    }

    public void setIdAnotacion(int idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoAnotacion() {
        return tipoAnotacion;
    }

    public void setTipoAnotacion(String tipoAnotacion) {
        this.tipoAnotacion = tipoAnotacion;
    }

    public String getMensajeAnot() {
        return mensajeAnot;
    }

    public void setMensajeAnot(String mensajeAnot) {
        this.mensajeAnot = mensajeAnot;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}