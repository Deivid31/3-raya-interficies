package vista.modeloTabla;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuari;

//Configuracion del modelo de la tabla
public class LeaderboardTableModel extends AbstractTableModel {
    private List<Usuari> leaderboardDelModel;
    private final String[] titolsColumnes = {"Puesto", "Jugador", "% Victorias", "Victorias totales", "Partidas totales"};
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public LeaderboardTableModel(List<Usuari> leaderboard)
    {
        leaderboard.sort(Comparator.comparing(Usuari::getPorcentaje).reversed());
        this.leaderboardDelModel = leaderboard;
    }
    
    @Override
    public int getRowCount() {
        return leaderboardDelModel.size();
    }

    @Override
    public int getColumnCount() {
        return titolsColumnes.length;
    }

    @Override
    public Object getValueAt(int iFila, int iColumna) {
        switch (iColumna) {
            case 0:
                return iFila + 1;
            case 1:
                return leaderboardDelModel.get(iFila).getNick();
            case 2:
                return df.format(leaderboardDelModel.get(iFila).getPorcentaje());
            case 3:
                return leaderboardDelModel.get(iFila).getVict();
            case 4:
                return leaderboardDelModel.get(iFila).getPartidas();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return titolsColumnes[column];
    }
}
