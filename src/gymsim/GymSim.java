package gymsim;

import javax.swing.*;
import java.awt.*;

public class GymSim extends JFrame {
    public GymSim() {
        setTitle("GymSim");
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Add the game panel
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(GymSim::new);
    }
}
