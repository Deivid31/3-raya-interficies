package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Random;
import persistence.GameDAO;
import services.TranslationService;

public class Buscaminas extends JDialog {
    private JFrame parent;
    private TranslationService translationService;
    private final String user;
    private GameDAO dao = new GameDAO();
    private final int filas = 8;
    private final int columnas = 8;
    private final int minas = 10;
    private JButton[][] botones;
    private boolean[][] esMina;
    private boolean[][] revelado;
    private boolean[][] marcado;
    private int celdasReveladas;
    
    public Buscaminas(JFrame parent, TranslationService translationService, String user) {
        super(parent, "Buscaminas", true);
        this.parent = parent;
        this.translationService = translationService;
        this.user = user;
        
        setSize(400, 400);
        setLayout(new GridLayout(filas, columnas));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        iniciarJuego();
        setVisible(true);
    }
    
    private void iniciarJuego() {
        botones = new JButton[filas][columnas];
        esMina = new boolean[filas][columnas];
        revelado = new boolean[filas][columnas];
        marcado = new boolean[filas][columnas];
        celdasReveladas = 0;
        
        getContentPane().removeAll();
        setLayout(new GridLayout(filas, columnas));
        inicializarTablero();
        colocarMinas();
        revalidate();
        repaint();
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
                add(botones[i][j]);
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
    
    private void revelarCelda(int x, int y){
        if (revelado[x][y] || marcado[x][y]) return;
        revelado[x][y] = true;
        celdasReveladas++;
        
        if (esMina[x][y]) {
            mostrarMinas();
            try {
                dao.result(user, 0);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar el resultado en la base de datos.");
            }
            JOptionPane.showMessageDialog(this, "¡Has perdido :)!");
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
            JOptionPane.showMessageDialog(this, "¡Has ganado!");
            try {
                dao.result(user, 1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al insertar el resultado en la base de datos.");
            }
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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
