/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

import java.awt.*;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author 
 */
public class Display extends JFrame {

    private Canvas canvas;

    public Display(int width, int height) {
        JFrame frame = new JFrame("Gym Sim");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        Canvas canvas = new Canvas(); // Start the canvas
        canvas.setPreferredSize(new Dimension(width, height)); //Must create a new dimension object for the height and width
        canvas.setFocusable(false);
        add(canvas);
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
