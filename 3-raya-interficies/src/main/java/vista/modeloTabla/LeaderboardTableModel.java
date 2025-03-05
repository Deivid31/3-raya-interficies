package vista.modeloTabla;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuari;


public class LeaderboardTableModel extends AbstractTableModel {
    private List<Usuari> leaderboardDelModel;
    private String[] titolsColumnes = {"Puesto", "Jugador", "% Victorias", "Victorias totales", "Partidas totales"};

    public LeaderboardTableModel(List<Usuari> leaderboard)
    {
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
        int pos = 0;
        switch (iColumna) {
            case 0:
                pos++;
                return pos;
            case 1:
                return leaderboardDelModel.get(iFila).getNick();
            case 2:
                return leaderboardDelModel.get(iFila).getVict() / leaderboardDelModel.get(iFila).getPartidas() * 100;
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
