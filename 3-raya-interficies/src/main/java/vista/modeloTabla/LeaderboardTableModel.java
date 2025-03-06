package vista.modeloTabla;

import static java.lang.Math.round;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuari;


public class LeaderboardTableModel extends AbstractTableModel {
    private List<Usuari> leaderboardDelModel;
    private String[] titolsColumnes = {"Puesto", "Jugador", "% Victorias", "Victorias totales", "Partidas totales"};
    private static final DecimalFormat df = new DecimalFormat("0.00");

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
        switch (iColumna) {
            case 0:
                return iFila + 1;
            case 1:
                return leaderboardDelModel.get(iFila).getNick();
            case 2:
                return leaderboardDelModel.get(iFila).getPartidas() == 0 ? 0 :
                        df.format((double) leaderboardDelModel.get(iFila).getVict() / leaderboardDelModel.get(iFila).getPartidas() * 100);
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
