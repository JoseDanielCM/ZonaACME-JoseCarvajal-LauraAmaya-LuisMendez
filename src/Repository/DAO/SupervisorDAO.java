package Repository.DAO;

import Model.*;

import java.sql.Timestamp;

public interface SupervisorDAO extends SalidaDAO {
    void crearFuncionario(Funcionario funcionario);
    void desactivarFuncionario(Funcionario funcionario);
    Funcionario mostrarFuncionario(int documentoFuncionario);
    String mostrarAnotacionesPersonas(Persona persona);
    void crearGuarda(Guarda guarda);
    void desactivarGuarda(Guarda guarda);
    Guarda mostrarGuarda(int documentoGuarda);
    void crearAnotaciones(Anotacion anotacion);
    void levantarRestriccion(int documentoPersona);
    Persona getPersonaById(int id);
    Empresa getEmpresaByName(String name);
    @Override
    void RegistrarSalida(int Documento, int documentoUser);
}
