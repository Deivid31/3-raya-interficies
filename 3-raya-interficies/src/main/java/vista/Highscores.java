package vista;

import java.awt.Component;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
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

public class Highscores extends javax.swing.JFrame {
    private JFrame parent;
    private TranslationService translationService;
    private GameDAO gameDAO;

    public Highscores(JFrame parent, TranslationService translationService) throws SQLException {
        initComponents();
        this.parent = parent;
        this.translationService = translationService;
        gameDAO = new GameDAO();
        jLabelNick.setName(translationService.translate("{NICKNAME}") + ":");
        jTaLeaderboard.setModel(new LeaderboardTableModel(gameDAO.getUsers()));
        adjustColumnWidths(jTaLeaderboard);
        LeaderboardColor leaderboardColor = new LeaderboardColor();
        for (int i = 0; i < jTaLeaderboard.getColumnCount(); i++) {
            jTaLeaderboard.getColumnModel().getColumn(i).setCellRenderer(leaderboardColor);
        }
    }
    
    public void adjustColumnWidths(JTable table) {
        JTableHeader header = table.getTableHeader();
        TableColumnModel columnModel = table.getColumnModel();

        for (int col = 0; col < columnModel.getColumnCount(); col++) {
            TableColumn column = columnModel.getColumn(col);
            TableCellRenderer renderer = header.getDefaultRenderer();
            Component comp = renderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, col);

            int headerWidth = comp.getPreferredSize().width + 10; // Minimum width based on title
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNick)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNickActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((LeaderboardTableModel) jTaLeaderboard.getModel())); 
        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + jTextFieldNick.getText(), 1));
        jTaLeaderboard.setRowSorter(sorter);
    }//GEN-LAST:event_jTextFieldNickActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguage;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTaLeaderboard;
    private javax.swing.JTextField jTextFieldNick;
    // End of variables declaration//GEN-END:variables
}
