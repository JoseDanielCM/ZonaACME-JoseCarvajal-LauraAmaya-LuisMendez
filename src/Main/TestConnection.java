package Main;

import Service.SuperUsuarioService;
import Util.DataBaseConnection;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        SuperUsuarioService superUsuarioService = new SuperUsuarioService();

        superUsuarioService.addSupervisor("1102359298","jeijei","admin123","Campus");
    }

}
