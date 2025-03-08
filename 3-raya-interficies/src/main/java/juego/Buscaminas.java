package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Random;
import model.Usuari;
import org.openide.util.Exceptions;
import persistence.GameDAO;
import services.TranslationService;
import vista.GameSelectorGUI;
import vista.Highscores;
import vista.LoginGUI;

public class Buscaminas extends JDialog {
    private JPanel gamePanel;
    private JMenuBar menuBar;

    private TranslationService translationService;
    private final Usuari user;
    private GameDAO dao = new GameDAO();
    private final int filas = 8;
    private final int columnas = 8;
    private final int minas = 10;
    private JButton[][] botones;
    private boolean[][] esMina;
    private boolean[][] revelado;
    private boolean[][] marcado;
    private int celdasReveladas;

    public Buscaminas(JFrame parent, TranslationService translationService, Usuari user) {
        super(parent, "Buscaminas", true);
        this.translationService = translationService;
        this.user = user;
        
        initComponents();

        gamePanel = jPanel1;
        menuBar = jMenuBar1;

        setSize(500, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setJMenuBar(menuBar);
        
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

        iniciarJuego();
    }

    private void iniciarJuego() {
        botones = new JButton[filas][columnas];
        esMina = new boolean[filas][columnas];
        revelado = new boolean[filas][columnas];
        marcado = new boolean[filas][columnas];
        celdasReveladas = 0;

        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(filas, columnas));
        inicializarTablero();
        colocarMinas();
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(new Color(173, 216, 230));
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                final int x = i, y = j;
                botones[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            marcarCelda(x, y);
                        } else {
                            revelarCelda(x, y);
                        }
                    }
                });
                gamePanel.add(botones[i][j]);
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);
            if (!esMina[x][y]) {
                esMina[x][y] = true;
                colocadas++;
            }
        }
    }

    private void revelarCelda(int x, int y) {
        if (revelado[x][y] || marcado[x][y]) return;
        revelado[x][y] = true;
        celdasReveladas++;

        if (esMina[x][y]) {
            mostrarMinas();
            JOptionPane.showMessageDialog(this, translationService.translate("{MINESWEEPER.LOSE}"));
            iniciarJuego();
            return;
        }

        int minasCerca = contarMinasCercanas(x, y);
        if (minasCerca > 0) {
            botones[x][y].setText(String.valueOf(minasCerca));
        } else {
            botones[x][y].setBackground(Color.LIGHT_GRAY);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nx = x + i, ny = y + j;
                    if (nx >= 0 && nx < filas && ny >= 0 && ny < columnas) {
                        revelarCelda(nx, ny);
                    }
                }
            }
        }

        if (celdasReveladas == (filas * columnas - minas)) {
            JOptionPane.showMessageDialog(this, translationService.translate("{MINESWEEPER.WIN}"));
            iniciarJuego();
        }
    }

    private void marcarCelda(int x, int y) {
        if (revelado[x][y]) return;

        if (marcado[x][y]) {
            botones[x][y].setText("");
            botones[x][y].setBackground(null);
        } else {
            botones[x][y].setBackground(Color.GREEN);
        }
        marcado[x][y] = !marcado[x][y];
    }

    private void mostrarMinas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (esMina[i][j]) {
                    botones[i][j].setText("*");
                    botones[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    private int contarMinasCercanas(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < filas && ny >= 0 && ny < columnas && esMina[nx][ny]) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenuNavigator.setText("Navigator");

        jMenuItem3Raya.setText("null");
        jMenuItem3Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3RayaActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItem3Raya);

        jMenuItem4Raya.setText("null");
        jMenuItem4Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4RayaActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItem4Raya);

        jMenuItemMineSweeper.setText("null");
        jMenuItemMineSweeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMineSweeperActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItemMineSweeper);

        jMenuItemLeaderboard.setText("null");
        jMenuItemLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLeaderboardActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItemLeaderboard);

        jMenuBar1.add(jMenuNavigator);

        jMenuLanguage.setText("Idioma");
        jMenuLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLenguage(evt);
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

        jMenuBar1.add(jMenuLanguage);

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

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3RayaActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(LoginGUI.getInstance(), translationService, user, true);
        elegirSimbolo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3RayaActionPerformed

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
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jMenuItemLeaderboardActionPerformed

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

    private void translatePage() {
        setTitle(translationService.translate("{TITLE.MINESWEEPER}"));
        
        //Traducción MenuBar
        jMenuNavigator.setText(translationService.translate("{TOPBAR.NAVIGATOR}"));
        jMenuItem3Raya.setText(translationService.translate("{TICTACTOE}"));
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
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButton5;
    private javax.swing.JRadioButtonMenuItem jRadioButton6;
    private javax.swing.JRadioButtonMenuItem jRadioButton7;
    // End of variables declaration//GEN-END:variables
}
