package model;

public class Usuari {
    private String email;
    private String nick;
    private String passwd;

    public Usuari(String email, String nick, String passwd) {
        this.email = email;
        this.nick = nick;
        this.passwd = passwd;
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
}