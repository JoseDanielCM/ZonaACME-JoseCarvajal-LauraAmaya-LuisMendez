package Service;

import Model.*;
import Repository.Impl.SupervisorImpl;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class SupervisorService {
    private final SupervisorImpl supervisorImpl;
    public SupervisorService(){supervisorImpl = new SupervisorImpl();}
    public void crearFuncionario(String id, String nombre, String contrasenia, String nombreEmpresa){
        int documentoInt;
        try {
            documentoInt = Integer.parseInt(id);
        }catch (Exception e) {
            System.out.println("Los datos ingresados son incorrectos");
            throw new IllegalArgumentException("Datos no validos");
        }
        Empresa emp = supervisorImpl.getEmpresaByName(nombreEmpresa);
        Funcionario funcionario = new Funcionario(documentoInt,nombre,contrasenia,true,emp);
        supervisorImpl.crearFuncionario(funcionario);
        System.out.println("Funcionario creado correctamente");

    }

    public void desactivarFuncionario(String documentoFun){
        try {
            Funcionario funcionario = mostrarFuncionarioID(documentoFun);
            supervisorImpl.desactivarFuncionario(funcionario);
        } catch (Exception e){
            System.out.println("Documento no valido");
            throw new IllegalArgumentException("Invalido");
        }

    }

    public Funcionario mostrarFuncionarioID(String documentoFun){
        return supervisorImpl.mostrarFuncionario(Integer.parseInt(documentoFun));
    }

    public void crearGuarda(String documento, String nombre, String contrasenia, String nombreEmpresa){
        int documentoInt;
        try {
            documentoInt = Integer.parseInt(documento);
        }catch (Exception e) {
            System.out.println("Los datos ingresados son incorrectos");
            throw new IllegalArgumentException("Datos no validos");
        }
        Empresa emp = supervisorImpl.getEmpresaByName(nombreEmpresa);
        Guarda guarda = new Guarda(documentoInt,nombre,contrasenia,true,emp);
        supervisorImpl.crearGuarda(guarda);
        System.out.println("Guarda creado correctamente");
    }

    public void desactivarGuarda(String documenGuarda){
        try {
            Guarda guarda = supervisorImpl.mostrarGuarda(Integer.parseInt(documenGuarda));
            supervisorImpl.desactivarGuarda(guarda);
            System.out.println("SRVC Guarda desactivado correctamente");
        } catch (Exception e){
            System.out.println("Documento no valido");
            throw new IllegalArgumentException("Invalido");
        }
    }

    public Guarda mostrarGuarda(String documentoGuar){
        return supervisorImpl.mostrarGuarda(Integer.parseInt(documentoGuar));
    }

    public void crearAnotaciones(String documento, String docUser, String tipoAnotacion, String mensajeAnot){
        Persona persona = supervisorImpl.getPersonaById(Integer.parseInt(documento));
        try {
           Anotacion anotacion = new Anotacion(persona, docUser, tipoAnotacion,mensajeAnot);
            System.out.println(anotacion);
           supervisorImpl.crearAnotaciones(anotacion);
        } catch (Exception e){
            System.out.println("Formato invalido");
            throw new IllegalArgumentException("Invalido" + e.getMessage());
        }
    }

    public void levantarRestriccion(String documentoPersona){
        supervisorImpl.levantarRestriccion(Integer.parseInt(documentoPersona));
    }

    public Persona obtenerPersona(String documentoPersona){
        return supervisorImpl.getPersonaById(Integer.parseInt(documentoPersona));
    }

    public void RegistrarSalida(String Documento, String documentoUser) {
        int DocumentoPersona, documentoUInt;
        try {
            DocumentoPersona = Integer.parseInt(Documento);
            documentoUInt = Integer.parseInt(documentoUser);
            supervisorImpl.RegistrarSalida(DocumentoPersona,documentoUInt);
        } catch (Exception e){
            System.out.println("Valores invalidos");
            throw new IllegalArgumentException("Invalido");
        }
    }

    public List<Usuario> mostrarTodosFuncionariosoGuarda(int tipo){
        return supervisorImpl.mostrarTodosFuncionariosoGuarda(tipo);
    }


}
