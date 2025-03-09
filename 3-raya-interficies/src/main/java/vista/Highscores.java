package vista;

import java.awt.Component;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import persistence.GameDAO;
import services.TranslationService;
import vista.modeloTabla.LeaderboardColor;
import vista.modeloTabla.LeaderboardTableModel;
import juego.ElegirSimbolo;
import juego.Buscaminas;
import model.Usuari;
import org.openide.util.Exceptions;

public class Highscores extends javax.swing.JFrame {
    private JFrame parent;
    private Usuari user;
    private TranslationService translationService;
    private GameDAO gameDAO;

    public Highscores(JFrame parent, TranslationService translationService, Usuari user) throws SQLException {
        initComponents();
        this.parent = parent;
        this.user = user;
        this.translationService = translationService;
        gameDAO = new GameDAO();
        ImageIcon img = new ImageIcon("src\\main\\java\\images\\icon.png");
        setIconImage(img.getImage());
        jTaLeaderboard.setModel(new LeaderboardTableModel(gameDAO.getUsers()));
        jTaLeaderboard.setAutoCreateRowSorter(true); // Indicacion para poder ordenar por las diferentes columnas clicando en su cabecera
        colAncho(jTaLeaderboard); //Ajuste de ancho inicial
        LeaderboardColor leaderboardColor = new LeaderboardColor();
        for (int i = 0; i < jTaLeaderboard.getColumnCount(); i++) { // Recorrido de las filas, para marcar los colores de los Top 3
            jTaLeaderboard.getColumnModel().getColumn(i).setCellRenderer(leaderboardColor);
        }
    }
    
    /*Funcion para ajustar el ancho de las columnas clasificatorias, respecto al texto de la cabecera inicialmente, y
      posteriormente de las otras celdas (Principalmente por los nicks largos)*/
    public void colAncho(JTable table) {
        JTableHeader cab = table.getTableHeader();
        TableColumnModel columnModel = table.getColumnModel();

        for (int col = 0; col < columnModel.getColumnCount(); col++) {
            TableColumn column = columnModel.getColumn(col);
            TableCellRenderer renderer = cab.getDefaultRenderer();
            Component comp = renderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, col);

            int headerWidth = comp.getPreferredSize().width + 10; // Ancho minimo
            int maxWidth = headerWidth;

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, col);
                comp = table.prepareRenderer(cellRenderer, row, col);
                maxWidth = Math.max(comp.getPreferredSize().width + 10, maxWidth);
            }

            column.setMinWidth(headerWidth);
            column.setPreferredWidth(maxWidth);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLanguage = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTaLeaderboard = new javax.swing.JTable();
        jLabelNick = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNavigator = new javax.swing.JMenu();
        jMenuItem3Raya = new javax.swing.JMenuItem();
        jMenuItem4Raya = new javax.swing.JMenuItem();
        jMenuItemMineSweeper = new javax.swing.JMenuItem();
        jMenuItemMain = new javax.swing.JMenuItem();
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
        setTitle("Leaderboard");

        jTaLeaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Posició", "Jugador", "% Victories", "Total de victories", "Partides"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTaLeaderboard);

        jLabelNick.setText("jLabel1");

        jTextFieldNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNickActionPerformed(evt);
            }
        });

        jMenuNavigator.setText("Navegador");

        jMenuItem3Raya.setText("3 en Raya...");
        jMenuItem3Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3RayaActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItem3Raya);

        jMenuItem4Raya.setText("Conecta 4...");
        jMenuItem4Raya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4RayaActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItem4Raya);

        jMenuItemMineSweeper.setText("Buscaminas...");
        jMenuItemMineSweeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMineSweeperActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItemMineSweeper);

        jMenuItemMain.setText("Menu principal");
        jMenuItemMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMainActionPerformed(evt);
            }
        });
        jMenuNavigator.add(jMenuItemMain);

        jMenuBar1.add(jMenuNavigator);

        jMenuLanguage.setText("Idioma");
        jMenuLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });

        buttonGroupLanguage.add(jRadioButton1);
        jRadioButton1.setText("ARB| Árabe");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton1);

        buttonGroupLanguage.add(jRadioButton2);
        jRadioButton2.setText("CAT| Catalán");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton2);

        buttonGroupLanguage.add(jRadioButton3);
        jRadioButton3.setText("ENG| Inglés");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton3);

        buttonGroupLanguage.add(jRadioButton4);
        jRadioButton4.setText("ESP| Español");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton4);

        buttonGroupLanguage.add(jRadioButton5);
        jRadioButton5.setText("FRE| Francés");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton5);

        buttonGroupLanguage.add(jRadioButton6);
        jRadioButton6.setText("GER| Alemán");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
        jMenuLanguage.add(jRadioButton6);

        buttonGroupLanguage.add(jRadioButton7);
        jRadioButton7.setText("RUS| Ruso");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLanguage(evt);
            }
        });
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
        jMenuItemDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteAccountActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemDeleteAccount);

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Funcion para filtrar la tabla segun el contenido de la caja de texto
    private void jTextFieldNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNickActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((LeaderboardTableModel) jTaLeaderboard.getModel())); 
        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + jTextFieldNick.getText(), 1)); //Con ^ se indica que busque a partir del inicio, y con (?i) que no sea case sensitive
        jTaLeaderboard.setRowSorter(sorter);
    }//GEN-LAST:event_jTextFieldNickActionPerformed
    
    // Funcion para acceder al juego de 3 en raya, cerrando por completo la instancia de pestaña de la tabla clasificatoria
    private void jMenuItem3RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3RayaActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(this, translationService, user, true);
        elegirSimbolo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3RayaActionPerformed
    
    // Funcion para acceder al juego de 4 en raya, cerrando por completo la instancia de pestaña de la tabla clasificatoria
    private void jMenuItem4RayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4RayaActionPerformed
        ElegirSimbolo elegirSimbolo = new ElegirSimbolo(this, translationService, user, false);
        elegirSimbolo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4RayaActionPerformed
    
    // Funcion para acceder al juego del buscaminas, cerrando por completo la instancia de pestaña de la tabla clasificatoria
    private void jMenuItemMineSweeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMineSweeperActionPerformed
        Buscaminas ventana = new Buscaminas(this, translationService, user);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemMineSweeperActionPerformed

    // Funcion para "regresar" al menu principal, cerrando por completo la instancia de pestaña de la tabla clasificatoria
    private void jMenuItemMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMainActionPerformed
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemMainActionPerformed

    // Funcion para recoger el idioma seleccionado y cambiar los textos, ademas de recalcular el ancho de las columnas
    private void changeLanguage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLanguage
        Object source = evt.getSource();
        if (source instanceof JRadioButtonMenuItem menuItem) {
            String[] temp = menuItem.getText().split("\\|");
            translationService.setLanguage(temp[0]);
            translatePage();
            colAncho(jTaLeaderboard);
        }
    }//GEN-LAST:event_changeLanguage

    // Funcion para cerrar sesion
    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        LoginGUI loginGUI = LoginGUI.getInstance();
        loginGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    // Funcion para borrar la cuenta
    private void jMenuItemDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteAccountActionPerformed
        int res = JOptionPane.showConfirmDialog(null, translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNTCONF}"), translationService.translate("{TOPBAR.ACCOUNT.DELETEACCOUNT}"), JOptionPane.YES_NO_OPTION); 
        if (res == JOptionPane.YES_OPTION) {
            try {
                gameDAO.delUser(user);
                LoginGUI loginGUI = LoginGUI.getInstance();
                loginGUI.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_jMenuItemDeleteAccountActionPerformed

    // Funcion para cambiar el texto de los diversos campos/componentes
    private void translatePage() {
        this.setTitle(translationService.translate("{TITLE.GAMESELECTOR}"));

        jMenuNavigator.setText(translationService.translate("{TOPBAR.NAVIGATOR}"));
        jMenuItem3Raya.setText(translationService.translate("{TICTACTOE}"));
        jMenuItem4Raya.setText(translationService.translate("{CONNECTFOUR}"));
        jMenuItemMineSweeper.setText(translationService.translate("{MINESWEEPER}"));
        jMenuItemMain.setText(translationService.translate("{TOPBAR.NAVIGATOR.MAIN}"));

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
        
        jTaLeaderboard.getColumnModel().getColumn(0).setHeaderValue(translationService.translate("{LEADERBORD.POSITION}"));
        jTaLeaderboard.getColumnModel().getColumn(1).setHeaderValue(translationService.translate("{LEADERBORD.PLAYER}"));
        jTaLeaderboard.getColumnModel().getColumn(2).setHeaderValue(translationService.translate("{LEADERBORD.PERCENTAGE}"));
        jTaLeaderboard.getColumnModel().getColumn(3).setHeaderValue(translationService.translate("{LEADERBORD.VICTORIES}"));
        jTaLeaderboard.getColumnModel().getColumn(4).setHeaderValue(translationService.translate("{LEADERBORD.GAMES}"));
        jLabelNick.setText(translationService.translate("{NICKNAME}") + ":");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3Raya;
    private javax.swing.JMenuItem jMenuItem4Raya;
    private javax.swing.JMenuItem jMenuItemDeleteAccount;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenuItem jMenuItemMain;
    private javax.swing.JMenuItem jMenuItemMineSweeper;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JMenu jMenuNavigator;
    private javax.swing.JRadioButtonMenuItem jRadioButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButton3;
    private javax.swing.JRadioButtonMenuItem jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButton5;
    private javax.swing.JRadioButtonMenuItem jRadioButton6;
    private javax.swing.JRadioButtonMenuItem jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTaLeaderboard;
    private javax.swing.JTextField jTextFieldNick;
    // End of variables declaration//GEN-END:variables
}
