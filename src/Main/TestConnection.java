package Main;

import Model.Registro;
import Util.DataBaseConnection;

public class TestConnection {
    public static void main(String[] args) {
        DataBaseConnection.getConnection();

        Registro registro = new Registro();
    }

}
