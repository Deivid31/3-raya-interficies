package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RayaDAO {
    private Connection conectar() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/3_raya_interficies";
    String user = "root";
    String pass = "";
    Connection c = DriverManager.getConnection(url, user, pass);
    return c;
    }
    
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}