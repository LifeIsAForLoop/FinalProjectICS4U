/* GymSim class
 */
package gymsim;

import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;

/**
 *
 * @author XaKit0340
 */
/**
 * @param args the command line arguments
 */
public class GymSim extends JFrame {

    public GymSim() {

        super("Gym Sim");

        new Dimension(300, 300);
        setMaximumSize(new Dimension(300, 300));
        setMinimumSize(new Dimension(300, 300));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    
    public void startGame(boolean start) {
       setVisible(start);
    }
    
    public static void main(String[] args) {
        //makes sure that GUI updates nicely with the rest of the OS
        EventQueue.invokeLater(() -> {
            GymSim gameFrame = new GymSim();
            startGame(true);
            });
                
    }
}
