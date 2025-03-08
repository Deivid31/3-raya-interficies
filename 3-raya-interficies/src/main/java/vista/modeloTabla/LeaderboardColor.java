package vista.modeloTabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LeaderboardColor extends DefaultTableCellRenderer {
    
    /* Funcion la cual, dependiendo el valor de puesto que encuentre en la primera columna, cambia los colores de fondo
       de las lineas correspondientes (Para simbolizar las medallas de oro, plata y bronce, tambien especifica el color
       de la letra*/
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int pos = Integer.parseInt(table.getValueAt(row, 0).toString());
        if (pos == 1) {
            cell.setBackground(Color.YELLOW);
            cell.setForeground(Color.BLACK);
        } else if (pos == 2) {
            cell.setBackground(Color.LIGHT_GRAY);
            cell.setForeground(Color.BLACK);
        } else if (pos == 3) {
            cell.setBackground(new Color(139, 69, 19));
            cell.setForeground(Color.WHITE);
        } else {
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
}
