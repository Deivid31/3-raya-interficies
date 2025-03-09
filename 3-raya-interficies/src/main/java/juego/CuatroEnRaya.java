package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.LineBorder;
import model.Usuari;
import persistence.GameDAO;
import services.TranslationService;
import vista.GameSelectorGUI;
import vista.Highscores;
import vista.LoginGUI;


public class CuatroEnRaya extends javax.swing.JDialog implements ActionListener {
    private JPanel gamePanel;
    private JMenuBar menuBar;
    
    private JFrame parent;
    private TranslationService translationService;
    private final Usuari user;
    private GameDAO dao = new GameDAO();
    private boolean symbol;
    private boolean turnoX = true;
    private final int FILAS = 6;
    private final int COLUMNAS = 7;
    private JButton[][] botones = new JButton[FILAS][COLUMNAS];

    public CuatroEnRaya(JFrame parent, TranslationService translationService, Usuari user, boolean symbol) {
        this.parent = parent;
        this.translationService = translationService;
        this.user = user;
        this.symbol = symbol;
        
        initComponents();
        gamePanel = jPanel1;
        menuBar = menuBar;
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gamePanel.setLayout(new GridLayout(FILAS, COLUMNAS));

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(80, 80));
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setBorder(new LineBorder(Color.BLACK, 1));
                botones[i][j].addActionListener(this);
                gamePanel.add(botones[i][j]);
            }
        }
        
        translatePage();
        //Seleccionar idioma del panel superior para ponerle redondita
        for (int i = 0; i < jMenuLanguage.getMenuComponentCount(); i++) {
            java.awt.Component component = jMenuLanguage.getMenuComponent(i);

            if (component instanceof JRadioButtonMenuItem radioButton) {
                String temp = radioButton.getText().split("\\|")[0];
                if (translationService.getLanguage().equalsIgnoreCase(temp))
                    radioButton.setSelected(true);
            }
        }
        
        pack();
        setLocationRelativeTo(null);
        reiniciarJuego();
    }
    private void hacerMovimientoIA() {
        if (hayGanador()) {
            return;
        }

        Random random = new Random();
        int fila, columna;
        do {
            fila = random.nextInt(6);
            columna = random.nextInt(7);
        } while (!botones[fila][columna].getText().equals(""));

        botones[fila][columna].setText(turnoX ? "X" : "O");
        botones[fila][columna].setForeground(Color.WHITE);
        botones[fila][columna].setBackground(turnoX ? Color.RED : Color.BLUE);

        if (hayGanador()) {
            JOptionPane.showMessageDialog(this, translationService.translate("{CONNECT4.WIN}") + " " + (turnoX ? "X" : "O") + "!");
            try {
                if (turnoX == symbol) dao.result(user, 1);
                else dao.result(user, 0);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar el resultado en la base de datos.");
            }
            reiniciarJuego();
            return;
        }

        turnoX = !turnoX;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = FILAS - 1; i >= 0; i--) {
                if (e.getSource() == botones[i][j] && botones[i][j].getText().isEmpty()) {
                    botones[i][j].setText(turnoX ? "X" : "O");
                    botones[i][j].setForeground(Color.WHITE);
                    botones[i][j].setBackground(turnoX ? Color.RED : Color.BLUE);
                    if (hayGanador()) {
                        JOptionPane.showMessageDialog(this, translationService.translate("{CONNECT4.WIN}") + " " + (turnoX ? "X" : "O") + "!");
                        try {
                            if (turnoX == symbol) dao.result(user, 1);
                            else dao.result(user, 0);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar el resultado en la base de datos.");
                        }
                        reiniciarJuego();
                        return;
                    }
                    turnoX = !turnoX;
                    if (turnoX != symbol) {
                        hacerMovimientoIA();
                    }
                    return;
                }
            }
        }
    }

    private boolean hayGanador() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (verificarLinea(i, j, 1, 0) || // Horizontal
                    verificarLinea(i, j, 0, 1) || // Vertical
                    verificarLinea(i, j, 1, 1) || // Diagonales
                    verificarLinea(i, j, 1, -1))  
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verificarLinea(int fila, int col, int deltaFila, int deltaCol) {
        String ficha = botones[fila][col].getText();
        if (ficha.isEmpty()) return false;

        for (int k = 1; k < 4; k++) {
            int nuevaFila = fila + k * deltaFila;
            int nuevaCol = col + k * deltaCol;
            if (nuevaFila < 0 || nuevaFila >= FILAS || nuevaCol < 0 || nuevaCol >= COLUMNAS)
                return false;
            if (!botones[nuevaFila][nuevaCol].getText().equals(ficha))
                return false;
        }
        return true;
    }

    private void reiniciarJuego() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j].setText("");
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setForeground(Color.BLACK);
                botones[i][j].setBorder(new LineBorder(Color.BLACK, 1));
            }
        }
        turnoX = true;
        if (turnoX != symbol) {
            hacerMovimientoIA();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenuNavigator2 = new javax.swing.JMenu();
        jMenuItem3Raya2 = new javax.swing.JMenuItem();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        jMenuNavigator2.setText("Navigator");

        jMenuItem3Raya2.setText("null");
        jMenuItem3Raya2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3Raya2ActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItem3Raya2);

        jMenuItem4Raya.setText("null");
        jMenuItem4Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4RayaActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItem4Raya);

        jMenuItemMineSweeper.setText("null");
        jMenuItemMineSweeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMineSweeperActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItemMineSweeper);

        jMenuItemLeaderboard.setText("null");
        jMenuItemLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLeaderboardActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItemLeaderboard);

        jMenuBar3.add(jMenuNavigator2);

        jMenuLanguage.setText("Idioma");
        jMenuLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLanguagechangeLenguage(evt);
            }
        });

        buttonGroupLanguage.add(jRadioButton1);
        jRadioButton1.setText("null");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton1);

        buttonGroupLanguage.add(jRadioButton2);
        jRadioButton2.setText("null");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton2);

        buttonGroupLanguage.add(jRadioButton3);
        jRadioButton3.setText("null");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton3);

        buttonGroupLanguage.add(jRadioButton4);
        jRadioButton4.setText("null");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton4);

        buttonGroupLanguage.add(jRadioButton5);
        jRadioButton5.setText("null");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton5);

        buttonGroupLanguage.add(jRadioButton6);
        jRadioButton6.setText("null");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton6);

        buttonGroupLanguage.add(jRadioButton7);
        jRadioButton7.setText("null");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton7);

        jMenuBar3.add(jMenuLanguage);

        jMenuAccount.setText("Cuenta");

        jMenuItemLogOut.setText("null");
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogOut);

        jMenuItemDeleteAccount.setText("null");
        jMenuAccount.add(jMenuItemDeleteAccount);

        jMenuBar3.add(jMenuAccount);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3Raya2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3Raya2ActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(LoginGUI.getInstance(), translationService, user, true);
        elegirSimbolo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3Raya2ActionPerformed

    private void jMenuItem4RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4RayaActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(LoginGUI.getInstance(), translationService, user, false);
        elegirSimbolo.setVisible(true);
    }//GEN-LAST:event_jMenuItem4RayaActionPerformed

    private void jMenuItemMineSweeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMineSweeperActionPerformed
        Buscaminas ventana = new Buscaminas(LoginGUI.getInstance(), translationService, user);
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItemMineSweeperActionPerformed

    private void jMenuItemLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLeaderboardActionPerformed
        try {
            Highscores leaderboard = new Highscores(LoginGUI.getInstance(), translationService, user);
            this.setVisible(false);
            leaderboard.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItemLeaderboardActionPerformed

    private void jMenuLanguagechangeLenguage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLanguagechangeLenguage

        Object source = evt.getSource();
        if (source instanceof JRadioButtonMenuItem menuItem) {
            String[] temp = menuItem.getText().split("\\|");
            translationService.setLanguage(temp[0]);
            translatePage();
        }

    }//GEN-LAST:event_jMenuLanguagechangeLenguage

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        LoginGUI loginGUI = LoginGUI.getInstance();
        loginGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    private void changeLenguage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLenguage
        Object source = evt.getSource();
        if (source instanceof JRadioButtonMenuItem menuItem) {
            String[] temp = menuItem.getText().split("\\|");
            translationService.setLanguage(temp[0]);
            translatePage();
        }
    }//GEN-LAST:event_changeLenguage

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem3Raya;
    private javax.swing.JMenuItem jMenuItem3Raya1;
    private javax.swing.JMenuItem jMenuItem3Raya2;
    private javax.swing.JMenuItem jMenuItem4Raya;
    private javax.swing.JMenuItem jMenuItemDeleteAccount;
    private javax.swing.JMenuItem jMenuItemLeaderboard;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenuItem jMenuItemMineSweeper;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuNavigator;
    private javax.swing.JMenu jMenuNavigator1;
    private javax.swing.JMenu jMenuNavigator2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButton5;
    private javax.swing.JRadioButtonMenuItem jRadioButton6;
    private javax.swing.JRadioButtonMenuItem jRadioButton7;
    // End of variables declaration//GEN-END:variables

    
    private void translatePage() {
        setTitle(translationService.translate("{TITLE.CONNECT4}"));
        
        //Traducción MenuBar
        jMenuNavigator2.setText(translationService.translate("{TOPBAR.NAVIGATOR}"));
        jMenuItem3Raya2.setText(translationService.translate("{TICTACTOE}"));
        jMenuItem4Raya.setText(translationService.translate("{CONNECTFOUR}"));
        jMenuItemMineSweeper.setText(translationService.translate("{MINESWEEPER}"));
        jMenuItemLeaderboard.setText(translationService.translate("{TOPBAR.NAVIGATOR.LEADERBOARD}"));

        jMenuLanguage.setText(translationService.translate("{TOPBAR.LANGUAGES}"));
        jRadioButton1.setText("ARB| " + translationService.translate("{LANGUAGE.ARAB}"));
        jRadioButton2.setText("CAT| " + translationService.translate("{LANGUAGE.CATALAN}"));
        jRadioButton3.setText("ENG| " + translationService.translate("{LANGUAGE.ENGLISH}"));
        jRadioButton4.setText("ESP| " + translationService.translate("{LANGUAGE.SPANISH}"));
        jRadioButton5.setText("FRE| " + translationService.translate("{LANGUAGE.FRENCH}"));
        jRadioButton6.setText("GER| " + translationService.translate("{LANGUAGE.GERMAN}"));
        jRadioButton7.setText("RUS| " + translationService.translate("{LANGUAGE.RUSSIAN}"));

        jMenuAccount.setText(translationService.translate("{TOPBAR.ACCOUNT}"));
        jMenuItemLogOut.setText(translationService.translate("{TOPBAR.ACCOUNT.LOGOUT}"));
        jMenuItemDeleteAccount.setText(translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNT}"));
    }
}
