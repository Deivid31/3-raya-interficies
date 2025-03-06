package juego;

import vista.*;
import java.awt.List;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Usuari;
import org.openide.util.Exceptions;
import services.TranslationService;
import persistence.GameDAO;

public class ElegirSimbolo extends javax.swing.JFrame {
    private JFrame parent;
    private Usuari user;
    private TranslationService translationService;
    private boolean juego;
    /**
     
Creates new form ElegirSimbolo*/
  public ElegirSimbolo(java.awt.Frame parent,TranslationService translationService, Usuari user,  boolean juego) {
      this.parent = this.parent;
      this.translationService = translationService;
      this.user = user;
      this.juego = juego;
      initComponents();}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonO = new javax.swing.JButton();
        jButtonX = new javax.swing.JButton();
        jLabelNick = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jButtonO.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonO.setForeground(new java.awt.Color(0, 0, 255));
        jButtonO.setText("O");
        jButtonO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOActionPerformed(evt);
            }
        });

        jButtonX.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonX.setForeground(new java.awt.Color(255, 0, 0));
        jButtonX.setText("X");
        jButtonX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXActionPerformed(evt);
            }
        });

        jLabelNick.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelNick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNick.setText("Elige el símbolo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonX, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelNick)
                .addGap(35, 35, 35)
                .addComponent(jButtonX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXActionPerformed
        if (juego == false) {
            CuatroEnRaya connect4 = new CuatroEnRaya(parent, translationService, user, true);
            connect4.setVisible(true);
        }else{
            TresEnRaya connect4 = new TresEnRaya(parent, translationService, user, true);
            connect4.setVisible(true);
        }
    }//GEN-LAST:event_jButtonXActionPerformed

    private void jButtonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOActionPerformed
        if (juego == false) {
            CuatroEnRaya connect4 = new CuatroEnRaya(parent, translationService, user, false);
            connect4.setVisible(true);
        }else{
            TresEnRaya connect4 = new TresEnRaya(parent, translationService, user, false);
            connect4.setVisible(true);
        }
    }//GEN-LAST:event_jButtonOActionPerformed
   
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonO;
    private javax.swing.JButton jButtonX;
    private javax.swing.JLabel jLabelNick;
    // End of variables declaration//GEN-END:variables
}
