package Repository.DAO;

import Model.Supervisor;

public interface SuperUsuarioDAO {
    void addSupervisor(Supervisor supervisor);              // CREATE
    void getSupervisorById(int idSupervisor);               // READ
    void getAllSupervisors();                               // READ
    void desactivarSupervisor(Supervisor supervisor);       // UPDATE

}
