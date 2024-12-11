package Controller;

import Model.Empresa;
import Model.Supervisor;
import Service.SuperUsuarioService;

import java.util.List;

public class SuperUsuarioController {
    private SuperUsuarioService superUsuarioService;
    public SuperUsuarioController() {
        superUsuarioService = new SuperUsuarioService();
    }
    public void addSupervisor(String documento, String name, String password, String empresaName) {
        superUsuarioService.addSupervisor(documento, name, password, empresaName);
    }

    public void addEmpresa(String idEmpresa, String name) {
        superUsuarioService.addEmpresa(idEmpresa,name);
    }

    public Supervisor getSupervisorById(int id) {
        return superUsuarioService.getSupervisorById(id);
    }

    public List<Supervisor> getAllSupervisors() {
        return superUsuarioService.getAllSupervisors();
    }

    public Empresa getEmpresaById(int id) {
        return superUsuarioService.getEmpresaById(id);
    }

    public Empresa getEmpresaByName(String name) {
        return superUsuarioService.getEmpresaByName(name);
    }

    public void desactivarSupervisor(int id) {
        superUsuarioService.desactivarSupervisor(id);
    }

    public void desactivarEmpresa(String nombreEmpresa) {
        superUsuarioService.desactivarEmpresa(nombreEmpresa);
    }

    public void desactivarEmpresaById(String idEmpresaStr) {
        superUsuarioService.desactivarEmpresaById(idEmpresaStr);
    }

    public void setIp(String ip) {
        superUsuarioService.setIp(ip);
    }

}
