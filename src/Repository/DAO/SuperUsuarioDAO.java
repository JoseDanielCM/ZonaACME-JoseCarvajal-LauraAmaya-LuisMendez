package Repository.DAO;

import Model.*;

import java.util.List;

public interface SuperUsuarioDAO {
    void addSupervisor(Supervisor supervisor);              // CREATE
    void addEmpresa(Empresa empresa);                       // CREATE
    Supervisor getSupervisorById(int idSupervisor);         // READ
    List<Supervisor> getAllSupervisors();                   // READ
    Empresa getEmpresaById(int idEmpresa);                  // READ
    Empresa getEmpresaByName(String name);                  // READ
    void desactivarSupervisor(Supervisor supervisor);       // UPDATE
    void desactivarEmpresa(Empresa empresa);           // UPDATE
    void setIp(String ip);                                  // UPDATE
    String getIp();                                  // UPDATE
    List<Persona> getAllPersonasEmpresa(int nit); // READ
    List<Registro> getListaRegistros(String inicial, String finalDate);
    String getNombreFuncionarioEmpresa(Empresa empresa);
}
