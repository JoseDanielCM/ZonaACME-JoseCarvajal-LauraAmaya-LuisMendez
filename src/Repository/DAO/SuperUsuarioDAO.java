package Repository.DAO;

import Model.Empresa;
import Model.SuperUsuario;
import Model.Supervisor;

import java.util.List;

public interface SuperUsuarioDAO {
    void addSupervisor(Supervisor supervisor);              // CREATE
    Supervisor getSupervisorById(int idSupervisor);         // READ
    List<Supervisor> getAllSupervisors();                   // READ
    Empresa getEmpresaById(int idEmpresa);                  // READ
    void desactivarSupervisor(Supervisor supervisor);       // UPDATE

}
