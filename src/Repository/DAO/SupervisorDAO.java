package Repository.DAO;

import Model.Anotacion;
import Model.Funcionario;
import Model.Guarda;

public interface SupervisorDAO extends SalidaDAO {
    void crearFuncionario(Funcionario funcionario);
    void desactivarFuncionario(Funcionario funcionario);
    Funcionario mostrarFuncionario(int documentoSupervisor);
    void crearGuarda(Guarda guarda);
    void desactivarGuarda(Guarda guarda);
    Guarda mostrarGuarda(int documentoGuarda);
    void crearAnotaciones(Anotacion anotacion);
    void levantarRestriccion(int documentoPersona);
    @Override
    void RegistrarSalida(int Documento);
}
