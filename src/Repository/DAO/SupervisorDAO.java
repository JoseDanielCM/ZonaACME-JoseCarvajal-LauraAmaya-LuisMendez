package Repository.DAO;

import Model.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;

public interface SupervisorDAO extends SalidaDAO {
    void crearFuncionario(Funcionario funcionario);
    void desactivarFuncionario(Funcionario funcionario);
    Funcionario mostrarFuncionario(int documentoFuncionario);
    void crearGuarda(Guarda guarda);
    void desactivarGuarda(Guarda guarda);
    Guarda mostrarGuarda(int documentoGuarda);
    void crearAnotaciones(Anotacion anotacion);
    void levantarRestriccion(int documentoPersona);
    Persona getPersonaById(int id);
    Empresa getEmpresaByName(String name);
    @Override
    void RegistrarSalida(int Documento, Date fecha, int documentoUser);
}
