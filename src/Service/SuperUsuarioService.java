package Service;

import Model.Supervisor;
import Repository.Impl.SuperUsuarioImpl;

public class SuperUsuarioService{
    private SuperUsuarioImpl superUsuarioImpl;

    public SuperUsuarioService() {
        superUsuarioImpl = new SuperUsuarioImpl();
    }
/*
    public void addSupervisor(String name) {
        superUsuarioImpl.addSupervisor(supervisor);
    }

*/
}
