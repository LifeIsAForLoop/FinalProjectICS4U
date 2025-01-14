/*
 * ICS4U Final Project - GymSim
 * Minato Sato, Malin Meyer, Xavier Kitching
 * December 2024 - January 2025
 * 
 * (Class Description)
 */
package gymsim;

import javax.swing.JFrame;
import java.io.IOException;

public class Main extends JFrame {

    /**
     * 
     * @throws IOException 
     */
    public Main() throws IOException {

        // JFrame setup
        setTitle("GymSim");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Game Panel setup
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        pack();

        setLocationRelativeTo(null); // Center the window on screen
        setVisible(true);

        // Start the game
        gamePanel.startGame();
        
    }

    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        new Main();
        
    }
    
}
