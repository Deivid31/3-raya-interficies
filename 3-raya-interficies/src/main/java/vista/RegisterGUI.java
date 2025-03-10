package vista;

import java.sql.SQLException;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Usuari;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.openide.util.Exceptions;
import persistence.GameDAO;
import services.TranslationService;

public class RegisterGUI extends javax.swing.JFrame {

    private ValidationGroup valGrp;
    private JFrame parent;
    private GameDAO gameDAO;
    private TranslationService translationService;

    public RegisterGUI(JFrame parent, TranslationService translationService) {
        initComponents();
        this.parent = parent;
        this.translationService = translationService;
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        valGrp = validationPanel.getValidationGroup();
        gameDAO = new GameDAO();
        translatePage();
        
        
        valGrp.add(jTextFieldEmail, StringValidators.EMAIL_ADDRESS);
        valGrp.add(jTextFieldNick, StringValidators.REQUIRE_NON_EMPTY_STRING);
        valGrp.add(jPasswordFieldPasswd, StringValidators.REQUIRE_NON_EMPTY_STRING);
        
        
        
        // Si hay problemas (errores), el botón se deshabilita para que la gente
        // no pueda crear usuarios erróneos
        jButtonCreateUser.setEnabled(false);
        
        validationPanel.addChangeListener(event -> {
            jButtonCreateUser.setEnabled(validationPanel.getProblem() == null);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCreateUser = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelNick = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jLabelPasswd = new javax.swing.JLabel();
        jPasswordFieldPasswd = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jComboBoxLang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);

        jButtonCreateUser.setText("Crear usuario");
        jButtonCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateUserActionPerformed(evt);
            }
        });

        jButtonLogin.setText("Iniciar sesión");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmail.setText("Email:");

        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldEmail.setName("email"); // NOI18N

        jLabelNick.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNick.setText("Apodo:");

        jTextFieldNick.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPasswd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPasswd.setText("Contraseña:");

        jPasswordFieldPasswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        validationPanel.setBorder(null);

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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(jButtonCreateUser))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxLang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNick)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPasswd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jComboBoxLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswd)
                    .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(validationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreateUser)
                    .addComponent(jButtonLogin))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateUserActionPerformed
        try {
            if (gameDAO.checkUserByEmail(jTextFieldEmail.getText().toLowerCase())) {
                JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.DUPLICATEDEMAIL}"), "", JOptionPane.ERROR_MESSAGE);
            } else {
                if (gameDAO.checkUserByNick(jTextFieldNick.getText().toLowerCase())) {
                    JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.DUPLICATEDNICK}"), "", JOptionPane.WARNING_MESSAGE);
                } else {
                    gameDAO.addUser(new Usuari(jTextFieldEmail.getText(), jTextFieldNick.getText(), jPasswordFieldPasswd.getText()));
                    JOptionPane.showMessageDialog(this, translationService.translate("{SUCCESSREGISTER}"), "", JOptionPane.INFORMATION_MESSAGE);
                    parent.setVisible(true);
                    this.dispose();
                }
            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButtonCreateUserActionPerformed

    private void jComboBoxLangPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxLangPopupMenuWillBecomeInvisible
        String[] codeLang = {"", "ARB", "CAT", "ENG", "ESP", "FRE", "GER", "RUS"};
        codeLang[0] = translationService.getLanguage();
        translationService.setLanguage(codeLang[jComboBoxLang.getSelectedIndex()]);
        translatePage();
    }//GEN-LAST:event_jComboBoxLangPopupMenuWillBecomeInvisible

    private void translatePage() {
        //Teóricamente Pedro nos dijo que así debería funcionar
        Locale.setDefault(new Locale(translationService.getLanguage()));
        validationPanel.validate();
        validationPanel.repaint();
        validate();
        repaint();
        
        this.setTitle(translationService.translate("{TITLE.REGISTER}"));
        
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
        jButtonCreateUser.setText(translationService.translate("{CREATEUSER}"));

        jLabelEmail.setText(translationService.translate("{EMAIL}") + ":");
        jTextFieldEmail.setName(translationService.translate("{EMAIL}"));
        jLabelNick.setText(translationService.translate("{NICKNAME}") + ":");
        jTextFieldNick.setName(translationService.translate("{NICKNAME}"));
        jLabelPasswd.setText(translationService.translate("{PASSWORD}") + ":");
        jPasswordFieldPasswd.setName(translationService.translate("{PASSWORD}"));
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateUser;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JComboBox<String> jComboBoxLang;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JLabel jLabelPasswd;
    private javax.swing.JPasswordField jPasswordFieldPasswd;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNick;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
