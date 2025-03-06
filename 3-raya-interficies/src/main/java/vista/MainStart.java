package vista;

public class MainStart {
    public static void main(String[] args) {
        LoginGUI loginGUI = LoginGUI.getInstance();
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
    }
}
