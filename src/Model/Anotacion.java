package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Anotacion {
    private Persona persona;
    private String tipoAnotacion;
    private String mensajeAnot;
    private Timestamp fecha;
    private String docUser;

    public Anotacion(Persona persona, String docUser, String tipoAnotacion, String mensajeAnot, Timestamp fecha) {
        this.persona = persona;
        this.tipoAnotacion = tipoAnotacion;
        this.mensajeAnot = mensajeAnot;
        this.fecha = fecha;
        this.docUser = docUser;
    }

    public String getDocUser() {
        return docUser;
    }

    public void setDocUser(String docUser) {
        this.docUser = docUser;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}