package Model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String idEmpresa;
    private String nombre;

    private boolean activo;

    private List<Persona> listaInvitados = new ArrayList<Persona>();
    private List<Persona> listaTrabajadores = new ArrayList<Persona>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Empresa(String idEmpresa, String nombre) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.activo = true;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(List<Persona> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public List<Persona> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Persona> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
