package gymsim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener, Runnable {
    private Thread animator;
    private final int DELAY = 35;
    private Map map;

    public GamePanel() {
        this.setFocusable(true);
        this.requestFocus();
        this.addMouseListener(this);

        // Initialize the map
        map = new Map("src\\gymsim\\sprites\\gym_map.gif", 1920, 1080);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Draw the map
        map.draw(g2d);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();

        while (true) {
            repaint();

            long timeDiff = System.currentTimeMillis() - beforeTime;
            long sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
