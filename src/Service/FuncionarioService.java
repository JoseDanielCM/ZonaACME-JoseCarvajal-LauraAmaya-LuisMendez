package Service;

import Model.Empresa;
import Model.Trabajador;
import Model.Vehiculo;
import Repository.Impl.FuncionarioImpl;

public class FuncionarioService {
    private FuncionarioImpl funcionarioImpl;

    public FuncionarioService(){
        funcionarioImpl = new FuncionarioImpl();
    }
    public void crearTrabajador(String documento, String nombre, String placaVehiculo, String docFuncionario) {
        int docInt;
        int docFuncionarioInt;
        try {
            docInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del trabajador debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }
        try {
            docFuncionarioInt = Integer.parseInt(documento);
        }catch (Exception e){
            System.out.println("El documento del Funcionario debe ser un numero");
            throw new IllegalArgumentException("Invalid document");
        }

        Empresa emp = funcionarioImpl.getEmpresaFuncionario(docFuncionarioInt);
        //Vehiculo vehiculo = funcionarioImpl.crearVehiculo(placaVehiculo);
        //Trabajador trabajador = new Trabajador(docInt,nombre,true,"Permitido",emp,true,vehiculo);


    }
}
