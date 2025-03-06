package vista;

import java.awt.Image;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import juego.Buscaminas;
import juego.CuatroEnRaya;
import juego.tresenraya;
import services.TranslationService;
import persistence.GameDAO;

public class GameSelectorGUI extends javax.swing.JFrame {
    private TranslationService translationService;
    private JFrame parent;
    private GameDAO gameDAO;
    private String user;

    public GameSelectorGUI(JFrame parent, TranslationService translationService, String user) {
        initComponents();
        this.parent = parent;
        this.translationService = translationService;
        this.user = user;
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        this.translationService = translationService;
        translatePage();
        
        //Iconos
        jImage3Raya.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jImage4Raya.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\connect4_icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jImageMineSweeper.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\minesweeper_icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        
        gameDAO = new GameDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        jPanel3Raya = new javax.swing.JPanel();
        jButton3Raya = new javax.swing.JButton();
        jImage3Raya = new javax.swing.JLabel();
        jPanel3Raya8 = new javax.swing.JPanel();
        jButton4Raya = new javax.swing.JButton();
        jImage4Raya = new javax.swing.JLabel();
        jPanel3Raya9 = new javax.swing.JPanel();
        jButtonMineSweeper = new javax.swing.JButton();
        jImageMineSweeper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNavigator = new javax.swing.JMenu();
        jMenuItem3Raya = new javax.swing.JMenuItem();
        jMenuItem4Raya = new javax.swing.JMenuItem();
        jMenuItemMineSweeper = new javax.swing.JMenuItem();
        jMenuItemLeaderboard = new javax.swing.JMenuItem();
        jMenuLanguage = new javax.swing.JMenu();
        jRadioButton1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton4 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton6 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton7 = new javax.swing.JRadioButtonMenuItem();
        jMenuAccount = new javax.swing.JMenu();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jMenuItemDeleteAccount = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jButton3Raya.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3Raya.setText("3 En raya");
        jButton3Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3RayaActionPerformed(evt);
            }
        });

        jImage3Raya.setText(" ");

        javax.swing.GroupLayout jPanel3RayaLayout = new javax.swing.GroupLayout(jPanel3Raya);
        jPanel3Raya.setLayout(jPanel3RayaLayout);
        jPanel3RayaLayout.setHorizontalGroup(
            jPanel3RayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3RayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImage3Raya)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3Raya, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3RayaLayout.setVerticalGroup(
            jPanel3RayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3RayaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3RayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jImage3Raya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3Raya, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton4Raya.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4Raya.setText("Conecta 4");
        jButton4Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4RayaActionPerformed(evt);
            }
        });

        jImage4Raya.setText(" ");

        javax.swing.GroupLayout jPanel3Raya8Layout = new javax.swing.GroupLayout(jPanel3Raya8);
        jPanel3Raya8.setLayout(jPanel3Raya8Layout);
        jPanel3Raya8Layout.setHorizontalGroup(
            jPanel3Raya8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Raya8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImage4Raya)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4Raya, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Raya8Layout.setVerticalGroup(
            jPanel3Raya8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Raya8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Raya8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jImage4Raya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4Raya, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButtonMineSweeper.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonMineSweeper.setText("Busca Minas");
        jButtonMineSweeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMineSweeperActionPerformed(evt);
            }
        });

        jImageMineSweeper.setText(" ");

        javax.swing.GroupLayout jPanel3Raya9Layout = new javax.swing.GroupLayout(jPanel3Raya9);
        jPanel3Raya9.setLayout(jPanel3Raya9Layout);
        jPanel3Raya9Layout.setHorizontalGroup(
            jPanel3Raya9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Raya9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImageMineSweeper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButtonMineSweeper, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Raya9Layout.setVerticalGroup(
            jPanel3Raya9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Raya9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Raya9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jImageMineSweeper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMineSweeper, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jMenuNavigator.setText("Navegador");

        jMenuItem3Raya.setText("3 en Raya...");
        jMenuNavigator.add(jMenuItem3Raya);

        jMenuItem4Raya.setText("Conecta 4...");
        jMenuNavigator.add(jMenuItem4Raya);

        jMenuItemMineSweeper.setText("Buscaminas...");
        jMenuNavigator.add(jMenuItemMineSweeper);

        jMenuItemLeaderboard.setText("Clasificación...");
        jMenuNavigator.add(jMenuItemLeaderboard);

        jMenuBar1.add(jMenuNavigator);

        jMenuLanguage.setText("Idioma");

        buttonGroupLanguage.add(jRadioButton1);
        jRadioButton1.setText("ARB| Árabe");
        jMenuLanguage.add(jRadioButton1);

        buttonGroupLanguage.add(jRadioButton2);
        jRadioButton2.setText("CAT| Catalán");
        jMenuLanguage.add(jRadioButton2);

        buttonGroupLanguage.add(jRadioButton3);
        jRadioButton3.setText("ENG| Inglés");
        jMenuLanguage.add(jRadioButton3);

        buttonGroupLanguage.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("ESP| Español");
        jMenuLanguage.add(jRadioButton4);

        buttonGroupLanguage.add(jRadioButton5);
        jRadioButton5.setText("FRE| Francés");
        jMenuLanguage.add(jRadioButton5);

        buttonGroupLanguage.add(jRadioButton6);
        jRadioButton6.setText("GER| Alemán");
        jMenuLanguage.add(jRadioButton6);

        buttonGroupLanguage.add(jRadioButton7);
        jRadioButton7.setText("RUS| Ruso");
        jMenuLanguage.add(jRadioButton7);

        jMenuBar1.add(jMenuLanguage);

        jMenuAccount.setText("Cuenta");

        jMenuItemLogOut.setText("Cerrar sesión...");
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogOut);

        jMenuItemDeleteAccount.setText("Borrar cuenta");
        jMenuAccount.add(jMenuItemDeleteAccount);

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3Raya8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3Raya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3Raya9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3Raya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3Raya8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3Raya9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3RayaActionPerformed
        tresenraya tictactoe = new tresenraya(this, translationService, user);
        tictactoe.setVisible(true);
    }//GEN-LAST:event_jButton3RayaActionPerformed

    private void jButton4RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4RayaActionPerformed
        CuatroEnRaya connect4 = new CuatroEnRaya(this, translationService, user);
        connect4.setVisible(true);
    }//GEN-LAST:event_jButton4RayaActionPerformed

    private void jButtonMineSweeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMineSweeperActionPerformed
        Buscaminas minesweeper = new Buscaminas(this, translationService, user);
        minesweeper.setVisible(true);
    }//GEN-LAST:event_jButtonMineSweeperActionPerformed

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        LoginGUI loginGUI = LoginGUI.getInstance();
        loginGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed
   
    
    
    private void translatePage() {
        this.setTitle(translationService.translate("{TITLE.GAMESELECTOR}"));
        
        jButton3Raya.setText(translationService.translate("{TICTACTOE}"));
        jButton4Raya.setText(translationService.translate("{CONNECTFOUR}"));
        jButtonMineSweeper.setText(translationService.translate("{MINESWEEPER}"));
        
        jMenuNavigator.setText(translationService.translate("{TOPBAR.NAVIGATOR}"));
        jMenuItem3Raya.setText(translationService.translate("{TICTACTOE}"));
        jMenuItem4Raya.setText(translationService.translate("{CONNECTFOUR}"));
        jMenuItemMineSweeper.setText(translationService.translate("{MINESWEEPER}"));
        jMenuItemLeaderboard.setText(translationService.translate("{TOPBAR.NAVIGATOR.LEADERBOARD}"));
        
        jMenuLanguage.setText(translationService.translate("{TOPBAR.LANGUAGES}"));
        jRadioButton1.setText(translationService.translate("{LANGUAGE.ARAB}"));
        jRadioButton2.setText(translationService.translate("{LANGUAGE.CATALAN}"));
        jRadioButton3.setText(translationService.translate("{LANGUAGE.ENGLISH}"));
        jRadioButton4.setText(translationService.translate("{LANGUAGE.SPANISH}"));
        jRadioButton5.setText(translationService.translate("{LANGUAGE.FRENCH}"));
        jRadioButton6.setText(translationService.translate("{LANGUAGE.GERMAN}"));
        jRadioButton7.setText(translationService.translate("{LANGUAGE.RUSSIAN}"));
        
        
        jMenuAccount.setText(translationService.translate("{TOPBAR.ACCOUNT}"));
        jMenuItemLogOut.setText(translationService.translate("{TOPBAR.ACCOUNT.LOGOUT}"));
        jMenuItemDeleteAccount.setText(translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNT}"));
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JButton jButton3Raya;
    private javax.swing.JButton jButton4Raya;
    private javax.swing.JButton jButtonMineSweeper;
    private javax.swing.JLabel jImage3Raya;
    private javax.swing.JLabel jImage4Raya;
    private javax.swing.JLabel jImageMineSweeper;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3Raya;
    private javax.swing.JMenuItem jMenuItem4Raya;
    private javax.swing.JMenuItem jMenuItemDeleteAccount;
    private javax.swing.JMenuItem jMenuItemLeaderboard;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenuItem jMenuItemMineSweeper;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuNavigator;
    private javax.swing.JPanel jPanel3Raya;
    private javax.swing.JPanel jPanel3Raya8;
    private javax.swing.JPanel jPanel3Raya9;
    private javax.swing.JRadioButtonMenuItem jRadioButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButton5;
    private javax.swing.JRadioButtonMenuItem jRadioButton6;
    private javax.swing.JRadioButtonMenuItem jRadioButton7;
    // End of variables declaration//GEN-END:variables
}
