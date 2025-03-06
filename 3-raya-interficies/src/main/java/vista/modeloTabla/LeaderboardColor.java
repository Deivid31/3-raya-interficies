package vista.modeloTabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LeaderboardColor extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int pos = Integer.parseInt(table.getValueAt(row, 0).toString());
        if (pos == 1) {
            cell.setBackground(Color.YELLOW); // Gold
        } else if (pos == 2) {
            cell.setBackground(Color.LIGHT_GRAY); // Silver
        } else if (pos == 3) {
            cell.setBackground(new Color(139, 69, 19)); // Brown (Bronze)
            cell.setForeground(Color.WHITE); // Improve contrast
        } else {
            cell.setBackground(Color.WHITE); // Default for other rows
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
}
