package model;

public class Usuari {
    private String email;
    private String nick;
    private String passwd;
    private int partidas;
    private int vict;

    public Usuari(String email, String nick, String passwd) {
        this.email = email;
        this.nick = nick;
        this.passwd = passwd;
    }
    
    public Usuari(String email, String nick, String passwd, int partidas, int vict) {
        this.email = email;
        this.nick = nick;
        this.passwd = passwd;
        this.partidas = partidas; 
        this.vict = vict;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getVict() {
        return vict;
    }

    public void setVict(int vict) {
        this.vict = vict;
    }
}