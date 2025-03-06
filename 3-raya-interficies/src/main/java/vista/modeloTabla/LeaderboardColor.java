package vista.modeloTabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LeaderboardColor extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Call parent method to get default rendering
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set colors for the top 3 rows
        if (row == 0) {
            cell.setBackground(Color.YELLOW); // Gold
        } else if (row == 1) {
            cell.setBackground(Color.LIGHT_GRAY); // Silver
        } else if (row == 2) {
            cell.setBackground(new Color(139, 69, 19)); // Brown (Bronze)
            cell.setForeground(Color.WHITE); // Improve contrast
        } else {
            cell.setBackground(Color.WHITE); // Default for other rows
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
}
