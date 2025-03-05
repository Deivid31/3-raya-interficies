package vista;

import java.awt.List;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Usuari;
import org.openide.util.Exceptions;
import services.TranslationService;
import persistence.GameDAO;

public class LoginGUI extends javax.swing.JFrame {
    private TranslationService translationService;
    private GameDAO gameDAO;

    public LoginGUI() {
        initComponents();
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        translationService = new TranslationService();
        translatePage();
        gameDAO = new GameDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogin = new javax.swing.JButton();
        jButtonRegister = new javax.swing.JButton();
        jLabelNick = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jLabelPasswd = new javax.swing.JLabel();
        jPasswordFieldPasswd = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxLang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jButtonLogin.setText("Iniciar sesión");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonRegister.setText("Registrarse");
        jButtonRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        jLabelNick.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNick.setText("Apodo:");

        jTextFieldNick.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPasswd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPasswd.setText("Contraseña:");

        jPasswordFieldPasswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBoxLang.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jComboBoxLang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cambiar Idioma...", "Árabe", "Catalán", "Inglés", "Español", "Francés", "Alemán", "Ruso" }));
        jComboBoxLang.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxLangPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPasswd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNick)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxLang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogin))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jComboBoxLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswd)
                    .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonRegister))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        RegisterGUI registerGUI = new RegisterGUI(this, translationService);
        registerGUI.setLocationRelativeTo(null);
        registerGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jComboBoxLangPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxLangPopupMenuWillBecomeInvisible
        String[] codeLang = {"", "ARAB", "CAT", "ENG", "ES", "FRA", "GER", "RUS"};
        codeLang[0] = translationService.getLanguage();
        translationService.setLanguage(codeLang[jComboBoxLang.getSelectedIndex()]);
        translatePage();
    }//GEN-LAST:event_jComboBoxLangPopupMenuWillBecomeInvisible

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        try {
            if(!gameDAO.checkUserByNick(jTextFieldNick.getText().toLowerCase())) {
                JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.WRONGLOGIN}"), "", JOptionPane.WARNING_MESSAGE);
            } else {
                Usuari jugador = gameDAO.getInfoUser(jTextFieldNick.getText());
                if(!gameDAO.checkPasswd(jugador.getNick(), jPasswordFieldPasswd.getText())) {
                    JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.WRONGLOGIN}"), "", JOptionPane.WARNING_MESSAGE);
                } else {
                    GameSelectorGUI gameSelectorGUI = new GameSelectorGUI(this, translationService, jTextFieldNick.getText().toLowerCase());
                    gameSelectorGUI.setLocationRelativeTo(null);
                    gameSelectorGUI.setVisible(true);
                    this.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        
    }//GEN-LAST:event_jButtonLoginActionPerformed
   
    
    
    private void translatePage() {
        this.setTitle(translationService.translate("{TITLE.LOGIN}"));
        
        jComboBoxLang.removeAllItems();
        jComboBoxLang.addItem(translationService.translate("{SELECTLANGUAGE}") + "...");
        jComboBoxLang.addItem("ARB| " + translationService.translate("{LANGUAGE.ARAB}"));
        jComboBoxLang.addItem("CAT| " + translationService.translate("{LANGUAGE.CATALAN}"));
        jComboBoxLang.addItem("ENG| " + translationService.translate("{LANGUAGE.ENGLISH}"));
        jComboBoxLang.addItem("ESP| " + translationService.translate("{LANGUAGE.SPANISH}"));
        jComboBoxLang.addItem("FRE| " + translationService.translate("{LANGUAGE.FRENCH}"));
        jComboBoxLang.addItem("GER| " + translationService.translate("{LANGUAGE.GERMAN}"));
        jComboBoxLang.addItem("RUS| " + translationService.translate("{LANGUAGE.RUSSIAN}"));
        
        jButtonLogin.setText(translationService.translate("{LOGIN}"));
        jButtonRegister.setText(translationService.translate("{REGISTER}"));
        
        jLabelNick.setText(translationService.translate("{NICKNAME}") + ":");
        jLabelPasswd.setText(translationService.translate("{PASSWORD}") + ":");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JComboBox<String> jComboBoxLang;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JLabel jLabelPasswd;
    private javax.swing.JPasswordField jPasswordFieldPasswd;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldNick;
    // End of variables declaration//GEN-END:variables
}
