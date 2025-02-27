package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Usuari;

public class GameDAO {
    private Connection conectar() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/3_raya_interficies";
    String user = "root";
    String pass = "";
    Connection c = DriverManager.getConnection(url, user, pass);
    return c;
    }
    
    public void result(String email, int res) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("UPDATE 3_raya_interficies SET juegos = juegos + 1, victorias = "+res+" WHERE email = '"+email+"';");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public void addUser(Usuari usuari) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("INSERT INTO usuarios (email, nick, passwd) VALUES ('"+usuari.getEmail()+"','"+usuari.getNick()+"','"+usuari.getPasswd()+"');");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public boolean checkUser(String email) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "SELECT * FROM usuarios WHERE email = '"+email+"';";
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return false;
    }
    
    public boolean checkPasswd(String email, String passwd) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "SELECT * FROM usuarios WHERE email = '"+email+"' AND passwd = '"+passwd+"';";
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return false;
    }
    
    public Usuari getInfoUser(String email) throws SQLException {
        Connection c = conectar();
        String query = "SELECT * FROM usuarios WHERE email = '"+email+"';";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        String em = "";
        String nick = "";
        String passwd = "";
        while (rs.next()) {
            em = rs.getString("email");
            nick = rs.getString("nick");
            passwd = rs.getString("passwd");
        }
        desconectar(c);
        return new Usuari(em, nick, passwd);
    }
    
    public void getUsers() throws SQLException {
        Connection c = conectar();
        String query = "SELECT * FROM usuarios;";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String em = rs.getString("email");
            String nick = rs.getString("nick");
            String passwd = rs.getString("passwd");
        }
        desconectar(c);
    }
    
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}