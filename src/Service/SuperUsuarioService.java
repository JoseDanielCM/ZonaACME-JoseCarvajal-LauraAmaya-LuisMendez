package Service;

import Model.Empresa;
import Model.Supervisor;
import Repository.Impl.SuperUsuarioImpl;

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


}
