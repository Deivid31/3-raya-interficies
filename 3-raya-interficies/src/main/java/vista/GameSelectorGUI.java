package vista;

import java.awt.Image;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import juego.Buscaminas;
import juego.CuatroEnRaya;
import services.TranslationService;
import persistence.GameDAO;

public class GameSelectorGUI extends javax.swing.JFrame {
    private TranslationService translationService;
    private JFrame parent;
    private GameDAO gameDAO;

    public GameSelectorGUI(JFrame parent, TranslationService translationService) {
        initComponents();
        this.parent = parent;
        this.translationService = translationService;
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        this.translationService = translationService;
        translatePage();
        
        //Iconos
        jImage3Raya.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jImage4Raya.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        jImageMineSweeper.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\images\\minesweeper_icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING)));
        
        gameDAO = new GameDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3Raya = new javax.swing.JPanel();
        jButton3Raya = new javax.swing.JButton();
        jImage3Raya = new javax.swing.JLabel();
        jPanel3Raya8 = new javax.swing.JPanel();
        jButton4Raya = new javax.swing.JButton();
        jImage4Raya = new javax.swing.JLabel();
        jPanel3Raya9 = new javax.swing.JPanel();
        jButtonMineSweeper = new javax.swing.JButton();
        jImageMineSweeper = new javax.swing.JLabel();

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
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3RayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3RayaActionPerformed

    private void jButton4RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4RayaActionPerformed
        CuatroEnRaya connect4 = new CuatroEnRaya(this, translationService, "");
        //TODO: Pasarle usuario
    }//GEN-LAST:event_jButton4RayaActionPerformed

    private void jButtonMineSweeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMineSweeperActionPerformed
        Buscaminas minesweeper = new Buscaminas(this, translationService, "");
        //TODO: Pasarle usuario
    }//GEN-LAST:event_jButtonMineSweeperActionPerformed
   
    
    
    private void translatePage() {
        this.setTitle(translationService.translate("{TITLE.GAMESELECTOR}"));
        
        jButton3Raya.setText(translationService.translate("{TICTACTOE}"));
        jButton4Raya.setText(translationService.translate("{CONNECTFOUR}"));
        jButtonMineSweeper.setText(translationService.translate("{MINESWEEPER}"));
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3Raya;
    private javax.swing.JButton jButton3Raya1;
    private javax.swing.JButton jButton3Raya2;
    private javax.swing.JButton jButton3Raya3;
    private javax.swing.JButton jButton3Raya4;
    private javax.swing.JButton jButton3Raya5;
    private javax.swing.JButton jButton3Raya6;
    private javax.swing.JButton jButton3Raya7;
    private javax.swing.JButton jButton3Raya8;
    private javax.swing.JButton jButton4Raya;
    private javax.swing.JButton jButtonMineSweeper;
    private javax.swing.JLabel jImage3Raya;
    private javax.swing.JLabel jImage3Raya1;
    private javax.swing.JLabel jImage3Raya2;
    private javax.swing.JLabel jImage3Raya3;
    private javax.swing.JLabel jImage3Raya4;
    private javax.swing.JLabel jImage3Raya5;
    private javax.swing.JLabel jImage3Raya6;
    private javax.swing.JLabel jImage3Raya7;
    private javax.swing.JLabel jImage3Raya8;
    private javax.swing.JLabel jImage4Raya;
    private javax.swing.JLabel jImageMineSweeper;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3Raya;
    private javax.swing.JPanel jPanel3Raya1;
    private javax.swing.JPanel jPanel3Raya2;
    private javax.swing.JPanel jPanel3Raya3;
    private javax.swing.JPanel jPanel3Raya4;
    private javax.swing.JPanel jPanel3Raya5;
    private javax.swing.JPanel jPanel3Raya6;
    private javax.swing.JPanel jPanel3Raya7;
    private javax.swing.JPanel jPanel3Raya8;
    private javax.swing.JPanel jPanel3Raya9;
    // End of variables declaration//GEN-END:variables
}
