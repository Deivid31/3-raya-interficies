package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Usuari;

public class GameDAO {
    private Connection conectar() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/3_raya_interficies";
    String user = "root";
    String pass = "";
    Connection c = DriverManager.getConnection(url, user, pass);
    return c;
    }
    
    public void result(String email, String res) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("UPDATE 3_raya_interficies SET "+res+" = "+res+" + 1 WHERE e-mail = "+email+";");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void addUser(Usuari usuari) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("INSERT INTO 3_raya_interficies VALUES ("+usuari.getEmail()+","+usuari.getNick()+","+usuari.getPasswd()+");");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void getUser(String email) throws SQLException {
        Connection c = conectar();
        String query = "SELECT * FROM usuarios WHERE e-mail = "+email+";";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String em = rs.getString("e-mail");
            String nick = rs.getString("nick");
            String passwd = rs.getString("passwd");
            //ArrayList stats = rs.getArray("victoria, derrota, empate");
        }
        desconectar(c);
    }
    
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}