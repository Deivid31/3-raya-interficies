/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tresenraya tres = new tresenraya("lol");
        //SwingUtilities.invokeLater(() -> new tresenraya().setVisible(true));
        //SwingUtilities.invokeLater(() -> new CuatroEnRaya("").setVisible(true));
        SwingUtilities.invokeLater(() -> new Buscaminas(tres,"").setVisible(true));
    }
    
}
