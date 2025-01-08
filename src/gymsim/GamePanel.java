/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

/**
 *
 * @author XaKit0340
 */
/*
 * B Cutten
    May 2022
    A class which allows drawing, because it extends JPanel, by way of the 
    Graphics2D classc
    A timer is added to the constructor so that the panel is repainted regulary
    and can be animated
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener, Runnable {

    //an arraylist grows as we add items to it
    private Thread animator;
    private final int DELAY = 35;

    public GamePanel() { //constructor for the panel      


        //attach the mouse listener to the panel and give it "focus"
        this.addMouseListener(this);
        this.setFocusable(true);
        this.requestFocus();

    }

    //does the actual drawing
    private void doDrawing(Graphics g) {
        //the Graphics2D class is the class that handles all the drawing
        //must be casted from older Graphics class in order to have access to some newer methods
        Graphics2D g2d = (Graphics2D) g;
        //draw each ball in the list


    }

    //overrides paintComponent in JPanel class
    //performs custom painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//does the necessary work to prepare the panel for drawing
        doDrawing(g);
    }

    //update the position of the ball and make it bounce
   
    //this method is called after the JPanel is added to the JFrame
    //we can perform start up tasks here
    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    //this method is called only once, when the Thread starts
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;
        //get the current time
        beforeTime = System.currentTimeMillis();

        while (true) { //this loop runs once ever 25 ms (the DELAY)
            //update the balls position   
            //redraws the screen (calling the paint component method)
            repaint();

            //calculate how much time has passed since the last call
            //this allows smooth updates and our ball will move at a constant speed (as opposed to being dependent on processor availability)
            timeDiff = System.currentTimeMillis() - beforeTime;

            //calculate how much time to wait before the next call
            sleep = DELAY - timeDiff;

            //always wait at least 2 ms
            if (sleep < 0) {
                sleep = 2;
            }

            //try to actually wait
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                //threads can be interrupted from other threads
                JOptionPane.showMessageDialog(this, "Thread interrupted: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //get the new current time
            beforeTime = System.currentTimeMillis();
            
            
            //Call drawing methods here
            
            
        }
    }
    
    //Keyboard and Mouse Inputs

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { //left click?

        } else { //any other click removes the last ball
            //only try to remove if the list contains a ball
         

        }

    }

    //the methods below are required by the MouseListener interface, but we aren't adding any actions to them
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


