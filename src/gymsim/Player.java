/*
 * ICS4U Final Project - GymSim
 * Minato Sato, Malin Meyer, Xavier Kitching
 * December 2024 - January 2025
 * 
 * (Class Description)
 */
package gymsim;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    // Attributes 
    private Image playerImg;
    private int xPos;
    private int yPos;
    private int playerLvl;
    private int backLvl;
    private int bicepLvl;
    private int calvesLvl;
    private int chestLvl;
    private int coreLvl;
    private int enduranceLvl;
    private int forearmLvl;
    private int legsLvl;
    private int shoulderLvl;
    private int tricepLvl;
    private int playerSpeed = 5;
    private boolean moveUp, moveDown, moveLeft, moveRight;

    /**
     *
     */
    public Player() {
        playerImg = null;
        xPos = 0;
        yPos = 0;
        playerLvl = 0;
        backLvl = 0;
        bicepLvl = 0;
        calvesLvl = 0;
        chestLvl = 0;
        coreLvl = 0;
        enduranceLvl = 0;
        forearmLvl = 0;
        legsLvl = 0;
        shoulderLvl = 0;
        tricepLvl = 0;
    }

    /**
     *
     * @param playerImg
     * @param xPos
     * @param yPos
     * @param playerLvl
     * @param backLvl
     * @param bicepLvl
     * @param calvesLvl
     * @param chestLvl
     * @param coreLvl
     * @param enduranceLvl
     * @param forearmLvl
     * @param legsLvl
     * @param shoulderLvl
     * @param tricepLvl
     */
    public Player(Image playerImg,
            int xPos,
            int yPos,
            int playerLvl,
            int backLvl,
            int bicepLvl,
            int calvesLvl,
            int chestLvl,
            int coreLvl,
            int enduranceLvl,
            int forearmLvl,
            int legsLvl,
            int shoulderLvl,
            int tricepLvl) {
        this.playerImg = playerImg;
        this.xPos = xPos;
        this.yPos = yPos;
        this.playerLvl = playerLvl;
        this.backLvl = backLvl;
        this.bicepLvl = bicepLvl;
        this.calvesLvl = calvesLvl;
        this.chestLvl = chestLvl;
        this.coreLvl = coreLvl;
        this.enduranceLvl = enduranceLvl;
        this.forearmLvl = forearmLvl;
        this.legsLvl = legsLvl;
        this.shoulderLvl = shoulderLvl;
        this.tricepLvl = tricepLvl;
    }

    /**
     *
     * @return
     */
    public int getPlayerLvl() {
        return playerLvl;
    }

    /**
     *
     * @param playerLvl
     */
    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

    /**
     *
     * @return
     */
    public int getxPos() {
        return xPos;
    }

    /**
     *
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     *
     * @return
     */
    public int getyPos() {
        return yPos;
    }

    /**
     *
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     *
     * @return
     */
    public int getBackLvl() {
        return backLvl;
    }

    /**
     *
     * @param backLvl
     */
    public void setBackLvl(int backLvl) {
        this.backLvl = backLvl;
    }

    /**
     *
     * @return
     */
    public int getBicepLvl() {
        return bicepLvl;
    }

    /**
     *
     * @param bicepLvl
     */
    public void setBicepLvl(int bicepLvl) {
        this.bicepLvl = bicepLvl;
    }

    /**
     *
     * @return
     */
    public int getCalvesLvl() {
        return calvesLvl;
    }

    /**
     *
     * @param calvesLvl
     */
    public void setCalvesLvl(int calvesLvl) {
        this.calvesLvl = calvesLvl;
    }

    /**
     *
     * @return
     */
    public int getChestLvl() {
        return chestLvl;
    }

    /**
     *
     * @param chestLvl
     */
    public void setChestLvl(int chestLvl) {
        this.chestLvl = chestLvl;
    }

    /**
     *
     * @return
     */
    public int getCoreLvl() {
        return coreLvl;
    }

    /**
     *
     * @param coreLvl
     */
    public void setCoreLvl(int coreLvl) {
        this.coreLvl = coreLvl;
    }

    /**
     *
     * @return
     */
    public int getEnduranceLvl() {
        return enduranceLvl;
    }

    /**
     *
     * @param enduranceLvl
     */
    public void setEnduranceLvl(int enduranceLvl) {
        this.enduranceLvl = enduranceLvl;
    }

    /**
     *
     * @return
     */
    public int getForearmLvl() {
        return forearmLvl;
    }

    /**
     *
     * @param forearmLvl
     */
    public void setForearmLvl(int forearmLvl) {
        this.forearmLvl = forearmLvl;
    }

    /**
     *
     * @return
     */
    public int getLegsLvl() {
        return legsLvl;
    }

    /**
     *
     * @param legsLvl
     */
    public void setLegsLvl(int legsLvl) {
        this.legsLvl = legsLvl;
    }

    /**
     *
     * @return
     */
    public int getShoulderLvl() {
        return shoulderLvl;
    }

    /**
     *
     * @param shoulderLvl
     */
    public void setShoulderLvl(int shoulderLvl) {
        this.shoulderLvl = shoulderLvl;
    }

    /**
     *
     * @return
     */
    public int getTricepLvl() {
        return tricepLvl;
    }

    /**
     *
     * @param tricepLvl
     */
    public void setTricepLvl(int tricepLvl) {
        this.tricepLvl = tricepLvl;
    }

    /**
     *
     */
    public void update() {

        if (moveUp) {
            yPos -= playerSpeed;
        }
        if (moveDown) {
            yPos += playerSpeed;
        }
        if (moveLeft) {
            xPos -= playerSpeed;
        }
        if (moveRight) {
            xPos += playerSpeed;
        }

        if (yPos <= 5) {
            moveUp = false;
        } else if (yPos >= 565) {
            moveDown = false;
        }
        if (xPos <= 5) {
            moveLeft = false;
        } else if (xPos >= 865) {
            moveRight = false;
        }

    }

    /**
     *
     * @param g
     */
    public void draw(Graphics g) {
        // Draw player character 
        g.drawImage(playerImg, xPos, yPos, 62, 100, null);
    }

    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (yPos >= 5) {
            if (key == KeyEvent.VK_W) {
                moveUp = true;
            }
        }
        if (yPos <= 563) {
            if (key == KeyEvent.VK_S) {
                moveDown = true;
            }
        }
        if (xPos >= 5) {
            if (key == KeyEvent.VK_A) {
                moveLeft = true;
            }
        }
        if (xPos <= 863) {
            if (key == KeyEvent.VK_D) {
                moveRight = true;
            }
        }

    }

    /**
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            moveUp = false;
        }
        if (key == KeyEvent.VK_S) {
            moveDown = false;
        }
        if (key == KeyEvent.VK_A) {
            moveLeft = false;
        }
        if (key == KeyEvent.VK_D) {
            moveRight = false;
        }

    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "";
    }

}
