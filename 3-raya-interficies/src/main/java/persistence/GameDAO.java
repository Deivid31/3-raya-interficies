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
    
    public void result(String nick, int res) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("UPDATE usuarios SET juegos = juegos + 1, victoria = "+res+" WHERE nick = '"+nick+"';");
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
    
    public void delUser(Usuari usuari) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("DELETE FROM usuarios WHERE nick = '"+usuari.getNick()+"';");
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }
    
    public boolean checkUserByEmail(String email) throws SQLException {
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
    
    public boolean checkUserByNick(String nick) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "SELECT * FROM usuarios WHERE nick = '"+nick+"';";
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return false;
    }
    
    public boolean checkPasswd(String nick, String passwd) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        String query = "SELECT * FROM usuarios WHERE nick = '"+nick+"' AND passwd = '"+passwd+"';";
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return true;
        }
        rs.close();
        st.close();
        desconectar(c);
        return false;
    }
    
    public Usuari getInfoUser(String nickname) throws SQLException {
        Connection c = conectar();
        String query = "SELECT * FROM usuarios WHERE nick = '"+nickname+"';";
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
    
    public ArrayList<Usuari> getUsers() throws SQLException {
        ArrayList<Usuari> leaderboard = new ArrayList<Usuari>();
        Connection c = conectar();
        String query = "SELECT * FROM usuarios;";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String em = rs.getString("email");
            String nick = rs.getString("nick");
            String passwd = rs.getString("passwd");
            int partidas = rs.getInt("juegos");
            int vict = rs.getInt("victoria");
            leaderboard.add(new Usuari(em, nick, passwd, partidas, vict));
        }
        desconectar(c);
        return leaderboard;
    }
    
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
}