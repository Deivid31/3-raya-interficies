/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Usuari;
import persistence.GameDAO;
import services.TranslationService;
import vista.GameSelectorGUI;

/**
 *
 * @author Admin
 */
public class CuatroEnRaya extends javax.swing.JDialog implements ActionListener{
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
        
        setTitle("4 en Raya");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(FILAS, COLUMNAS));

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(80, 80));
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setBorder(new LineBorder(Color.BLACK, 1));
                botones[i][j].addActionListener(this);
                add(botones[i][j]);
            }
        }
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = FILAS - 1; i >= 0; i--) {
                if (e.getSource() == botones[i][j] && botones[i][j].getText().isEmpty()) {
                    botones[i][j].setText(turnoX ? "X" : "O");
                    botones[i][j].setForeground(Color.WHITE);
                    botones[i][j].setBackground(turnoX ? Color.RED : Color.BLUE);
                    //botones[i][j].setBorder(new LineBorder(turnoX ? Color.RED : Color.BLUE, 1));
                    if (hayGanador()) {
                        JOptionPane.showMessageDialog(this, "¡Gana " + (turnoX ? "X" : "O") + "!");
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
