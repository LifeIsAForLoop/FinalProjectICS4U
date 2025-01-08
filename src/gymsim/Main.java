/* Main class
 */
package gymsim;

import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.EventQueue;
import javax.swing.*;

/**
 *
 * @author XaKit0340
 */
/**
 * @param args the command line arguments
 */
public class Main {

    public static void main(String[] args) {
        //makes sure that GUI updates nicely with the rest of the OS
        EventQueue.invokeLater(() -> {
        Display display = new Display(1200, 1200);
        display.setVisible(true);
        });
    }

}
