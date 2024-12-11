/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

import java.awt.Canvas;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.*;

/**
 *
 * @author XaKit0340
 */
public class Display extends JFrame {

    private Canvas canvas;

    public Display(int width, int height) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Canvas(); // Start the canvas
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}
