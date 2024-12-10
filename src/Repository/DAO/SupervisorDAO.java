package Repository.DAO;

import Model.Funcionario;
import Model.Guarda;

public interface SupervisorDAO {
    void crearFuncionario(Funcionario funcionario);
    void desactivarFuncionario(Funcionario funcionario);
    Funcionario mostrarFuncionario(int documentoSupervisor);
    void crearGuarda(Guarda guarda);
    void desactivarGuarda(Guarda guarda);
    Guarda mostrarGuarda(int documentoGuarda);
    void crearAnotaciones(int documentoPersona);
    void levantarRestriccion(int documentoPersona);

}
