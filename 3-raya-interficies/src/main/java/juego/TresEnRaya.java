package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.LineBorder;
import model.Usuari;
import org.openide.util.Exceptions;
import persistence.GameDAO;
import services.TranslationService;
import vista.GameSelectorGUI;
import vista.Highscores;
import vista.LoginGUI;

public class TresEnRaya extends javax.swing.JFrame implements ActionListener {

    private final Usuari user;
    private GameDAO dao = new GameDAO();
    private JFrame parent;
    private TranslationService translationService;
    private boolean symbol;
    private boolean turnoX = true;
    JButton[][] botones = new JButton[3][3];

    private ArrayList<JButton> fila1 = new ArrayList<>();
    private ArrayList<JButton> fila2 = new ArrayList<>();
    private ArrayList<JButton> fila3 = new ArrayList<>();

    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setText("");
                botones[i][j].setBackground(Color.white);
                botones[i][j].setForeground(Color.black);
                botones[i][j].setBorder(new LineBorder(Color.BLACK, 1));
            }
        }
        turnoX = true;
        cambiarTexto();
        if (turnoX != symbol) {
            hacerMovimientoIA();
        }
    }

    private void cambiarTexto() {
        if (turnoX) {
            jLabel_Turno.setText(translationService.translate("{TICTACTOE.ISTURN}") + " X");
        } else {
            jLabel_Turno.setText(translationService.translate("{TICTACTOE.ISTURN}") + " O");
        }
    }

    /**
     * Constructor
     */
    public TresEnRaya(JFrame parent, TranslationService translationService, Usuari user, boolean symbol) {
        this.parent = parent;
        this.translationService = translationService;
        this.user = user;
        this.symbol = symbol;

        initComponents();
        botones[0][0] = jButton1;
        botones[0][1] = jButton2;
        botones[0][2] = jButton3;
        botones[1][0] = jButton4;
        botones[1][1] = jButton5;
        botones[1][2] = jButton6;
        botones[2][0] = jButton7;
        botones[2][1] = jButton8;
        botones[2][2] = jButton9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].addActionListener(this);
            }
        }
        reiniciar_jButton.addActionListener(this);
        cerrar_jButton.addActionListener(this);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setPreferredSize(new Dimension(500, 500)); // Tamaño de 100x100 píxeles
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
        reiniciarJuego();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jLabel_Turno = new javax.swing.JLabel();
        reiniciar_jButton = new javax.swing.JButton();
        cerrar_jButton = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        jButton2.setText("jButton1");

        jButton3.setText("jButton1");

        jButton4.setText("jButton1");

        jButton5.setText("jButton1");

        jButton6.setText("jButton1");

        jButton7.setText("jButton1");

        jButton8.setText("jButton1");

        jButton9.setText("jButton1");

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Tres en raya:");

        jLabel_Turno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Turno.setText("Turno de: ");

        reiniciar_jButton.setText("Reiniciar Partida");

        cerrar_jButton.setText("Cerrar juego");

        jMenuNavigator2.setText("Navegador");

        jMenuItem3Raya2.setText("3 en Raya...");
        jMenuItem3Raya2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3Raya2ActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItem3Raya2);

        jMenuItem4Raya.setText("Conecta 4...");
        jMenuItem4Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4RayaActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItem4Raya);

        jMenuItemMineSweeper.setText("Buscaminas...");
        jMenuItemMineSweeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMineSweeperActionPerformed(evt);
            }
        });
        jMenuNavigator2.add(jMenuItemMineSweeper);

        jMenuItemLeaderboard.setText("Clasificación...");
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
                translatePage(evt);
            }
        });

        buttonGroupLanguage.add(jRadioButton1);
        jRadioButton1.setText("ARB| Árabe");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton1);

        buttonGroupLanguage.add(jRadioButton2);
        jRadioButton2.setText("CAT| Catalán");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton2);

        buttonGroupLanguage.add(jRadioButton3);
        jRadioButton3.setText("ENG| Inglés");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton3);

        buttonGroupLanguage.add(jRadioButton4);
        jRadioButton4.setText("ESP| Español");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton4);

        buttonGroupLanguage.add(jRadioButton5);
        jRadioButton5.setText("FRE| Francés");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton5);

        buttonGroupLanguage.add(jRadioButton6);
        jRadioButton6.setText("GER| Alemán");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton6);

        buttonGroupLanguage.add(jRadioButton7);
        jRadioButton7.setText("RUS| Ruso");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translatePage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton7);

        jMenuBar3.add(jMenuLanguage);

        jMenuAccount.setText("Cuenta");

        jMenuItemLogOut.setText("Cerrar sesión...");
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogOut);

        jMenuItemDeleteAccount.setText("Borrar cuenta");
        jMenuItemDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteAccountActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemDeleteAccount);

        jMenuBar3.add(jMenuAccount);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Turno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrar_jButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reiniciar_jButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Turno)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reiniciar_jButton)
                    .addComponent(cerrar_jButton))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3Raya2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3Raya2ActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(this, translationService, user, true);
        elegirSimbolo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3Raya2ActionPerformed

    private void jMenuItem4RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4RayaActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(this, translationService, user, false);
        elegirSimbolo.setVisible(true);
    }//GEN-LAST:event_jMenuItem4RayaActionPerformed

    private void jMenuItemMineSweeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMineSweeperActionPerformed
        Buscaminas ventana = new Buscaminas(this, translationService, user);
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItemMineSweeperActionPerformed

    private void jMenuItemLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLeaderboardActionPerformed
        try {
            Highscores leaderboard = new Highscores(this, translationService, user);
            this.setVisible(false);
            leaderboard.setVisible(true);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jMenuItemLeaderboardActionPerformed

    private void translatePage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translatePage

        Object source = evt.getSource();
        if (source instanceof JRadioButtonMenuItem menuItem) {
            String[] temp = menuItem.getText().split("\\|");
            translationService.setLanguage(temp[0]);
            translatePage();
        }
    }//GEN-LAST:event_translatePage

    private void changeLenguage(java.awt.event.ActionEvent evt) {
        Object source = evt.getSource();
        if (source instanceof JRadioButtonMenuItem menuItem) {
            String[] temp = menuItem.getText().split("\\|");
            translationService.setLanguage(temp[0]);
            translatePage();
        }
    }
    
    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        LoginGUI loginGUI = LoginGUI.getInstance();
        loginGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    private void jMenuItemDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteAccountActionPerformed
        int res = JOptionPane.showConfirmDialog(null, translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNTCONF}"), translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNT}"), JOptionPane.YES_NO_OPTION); 
        if (res == JOptionPane.YES_OPTION) {
            try {
                dao.delUser(user);
                LoginGUI loginGUI = LoginGUI.getInstance();
                loginGUI.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_jMenuItemDeleteAccountActionPerformed

    /**
     * @param args the command line arguments
     */
    private boolean hayGanador() {
        // Revisar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (verificarLinea(botones[i][0], botones[i][1], botones[i][2])
                    || // Filas
                    verificarLinea(botones[0][i], botones[1][i], botones[2][i])) { // Columnas
                return true;
            }
        }
        // Revisar diagonales
        return verificarLinea(botones[0][0], botones[1][1], botones[2][2])
                || verificarLinea(botones[0][2], botones[1][1], botones[2][0]);
    }

    private boolean verificarLinea(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().equals("")
                && b1.getText().equals(b2.getText())
                && b2.getText().equals(b3.getText());
    }

    private boolean esEmpate() {
        for (JButton[] fila : botones) {
            for (JButton boton : fila) {
                if (boton.getText().equals("")) {
                    return false; // Todavía hay espacios vacíos
                }
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JButton cerrar_jButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabel_Turno;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem3Raya2;
    private javax.swing.JMenuItem jMenuItem4Raya;
    private javax.swing.JMenuItem jMenuItemDeleteAccount;
    private javax.swing.JMenuItem jMenuItemLeaderboard;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenuItem jMenuItemMineSweeper;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuNavigator2;
    private javax.swing.JRadioButtonMenuItem jRadioButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButton5;
    private javax.swing.JRadioButtonMenuItem jRadioButton6;
    private javax.swing.JRadioButtonMenuItem jRadioButton7;
    private javax.swing.JButton reiniciar_jButton;
    // End of variables declaration//GEN-END:variables
    private void hacerMovimientoIA() {
        if (esEmpate() || hayGanador()) {
            return;
        }

        Random random = new Random();
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!botones[fila][columna].getText().equals(""));

        botones[fila][columna].setText(turnoX ? "X" : "O");
        botones[fila][columna].setBorder(new LineBorder(turnoX ? Color.RED : Color.BLUE, 2));
        botones[fila][columna].setForeground(turnoX ? Color.RED : Color.BLUE);

        if (hayGanador()) {
                JOptionPane.showMessageDialog(this, translationService.translate("{TICTACTOE.WIN}") + " " + (turnoX ? "X" : "O") + "!");
                try {
                    if (turnoX == symbol) {
                        dao.result(user, 1);
                    } else {
                        dao.result(user, 0);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.RESSQL}"));
                }
                reiniciarJuego();
                return;
            }

        // Verificar si hay empate
        if (esEmpate()) {
            JOptionPane.showMessageDialog(this, "¡Empate!");
            try {
                dao.result(user, 0);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.RESSQL}"));
            }
            reiniciarJuego();
            return;
        }

        turnoX = !turnoX;
        cambiarTexto();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();

        // Si el botón de reinicio fue presionado
        if (botonPresionado == reiniciar_jButton) {
            reiniciarJuego();
            return;
        }
        if (botonPresionado == cerrar_jButton) {
            reiniciarJuego();
            this.setVisible(false);
            return;
        }
        // Para evitar que se sobrescriban jugadas
        if (!botonPresionado.getText().equals("")) {
            return;
        }

        // Colocar "X" o "O" según el turno
        botonPresionado.setText(turnoX ? "X" : "O");
        if (turnoX) {
            botonPresionado.setBorder(new LineBorder(Color.RED, 2));
            botonPresionado.setForeground(Color.red);
        } else {
            botonPresionado.setBorder(new LineBorder(Color.BLUE, 2));
            botonPresionado.setForeground(Color.blue);
        }
        if (hayGanador()) {
            JOptionPane.showMessageDialog(this, translationService.translate("{TICTACTOE.WIN}") + " " + (turnoX ? "X" : "O") + "!");
            try {
                if (turnoX == symbol) {
                    dao.result(user, 1);
                } else {
                    dao.result(user, 0);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.RESSQL}"));
            }
            reiniciarJuego();
            return;
        }

        // Verificar si hay empate
        if (esEmpate()) {
            JOptionPane.showMessageDialog(this, "¡Empate!");
            try {
                dao.result(user, 0);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, translationService.translate("{ERROR.RESSQL}"));
            }
            reiniciarJuego();
            return;
        }
        
        // Cambiar turno
        turnoX = !turnoX;
        cambiarTexto();
        if (turnoX != symbol) {
            hacerMovimientoIA();
        }
    }

    private void translatePage() {
        setTitle(translationService.translate("{TITLE.TICTACTOE}"));
        jLabelTitle.setText(translationService.translate("{TITLE.TICTACTOE}") + ":");
        
        cambiarTexto();
        cerrar_jButton.setText(translationService.translate("{TICTACTOE.CLOSE}"));
        reiniciar_jButton.setText(translationService.translate("{TICTACTOE.RESTART}"));
        
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
