package Service;

import Model.Empresa;
import Model.Supervisor;
import Repository.Impl.SuperUsuarioImpl;

import java.util.List;

public class SuperUsuarioService{
    private SuperUsuarioImpl superUsuarioImpl;

    public SuperUsuarioService() {
        superUsuarioImpl = new SuperUsuarioImpl();
    }
    public void addSupervisor(String documento, String name, String password, String empresaName) {
        int docInt;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e) {
            System.out.println("El documento degbe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        Empresa emp = superUsuarioImpl.getEmpresaByName(empresaName);
        Supervisor supervisor = new Supervisor(docInt,name,password,true,emp);
        superUsuarioImpl.addSupervisor(supervisor);
    }

    public void addEmpresa(String idEmpresa, String nombre) {
        if (idEmpresa == null || idEmpresa.isEmpty() || nombre == null || nombre.isEmpty()) {
            System.out.println("El documento y el nombre no pueden estar vacíos.");
        }else if (!idEmpresa.matches("\\d+")) {
            System.out.println("El documento debe contener solo números.");
        }else if (idEmpresa.length() > 10 || nombre.length() > 110) {
            System.out.println("El documento o el nombre exceden la longitud permitida.");
        }else {
            Empresa empresa = new Empresa(idEmpresa, nombre);
            superUsuarioImpl.addEmpresa(empresa);
        }
    }

    public Supervisor getSupervisorById(int id) {
        return superUsuarioImpl.getSupervisorById(id);
    }

    public List<Supervisor> getAllSupervisors() {
        return superUsuarioImpl.getAllSupervisors();
    }

    public Empresa getEmpresaById(int id) {
        return superUsuarioImpl.getEmpresaById(id);
    }

    public Empresa getEmpresaByName(String name) {
        return superUsuarioImpl.getEmpresaByName(name);
    }

    public void desactivarSupervisor(int id) {
        Supervisor supervisor = superUsuarioImpl.getSupervisorById(id);
        superUsuarioImpl.desactivarSupervisor(supervisor);
    }

    public void desactivarEmpresa(String nombreEmpresa) {
        Empresa empresa = superUsuarioImpl.getEmpresaByName(nombreEmpresa);
        superUsuarioImpl.desactivarEmpresa(empresa);
    }
    public void desactivarEmpresaById(String idEmpresaStr) {
        int idEmpresa = Integer.parseInt(idEmpresaStr);
        Empresa empresa = superUsuarioImpl.getEmpresaById(idEmpresa);
        superUsuarioImpl.desactivarEmpresa(empresa);
    }

    public void setIp(String ip) {
        superUsuarioImpl.setIp(ip);
    }

}
