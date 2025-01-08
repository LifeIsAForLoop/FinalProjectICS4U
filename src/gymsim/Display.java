/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

import java.awt.*;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Display extends JFrame {


    public Display(int width, int height) {
        JFrame frame = new JFrame("Gym Sim");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Gym Sim");
        frame.setLocationRelativeTo(null);
    }
}
