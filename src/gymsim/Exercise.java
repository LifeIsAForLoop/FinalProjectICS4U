/*
 * ICS4U Final Project - GymSim
 * Minato Sato, Malin Meyer, Xavier Kitching
 * December 2024 - January 2025
 * 
 * (Class Description)
 */
package gymsim;

import java.awt.*;

public class Exercise {

    private Image EquipmentImg;
    private String name;
    private int xPos;
    private int yPos;
    private String description;

    /**
     * 
     */
    public Exercise() {
        EquipmentImg = null;
        name = null;
        xPos = 0;
        yPos = 0;
        description = null;
    }

    /**
     * 
     * @param image
     * @param x
     * @param y 
     */
    public Exercise(Image image, String name, int x, int y, String description) {
        this.name = name;
        this.EquipmentImg = image;
        this.xPos = x;
        this.yPos = y;
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public Image getImage() {
        return EquipmentImg;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return 
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * 
     * @param xPos 
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * 
     * @return 
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * 
     * @param yPos 
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * 
     * @param player
     * @return 
     */
    public boolean isPlayerInteracting(Player player) {
        
        // Basic collision detection for interaction
        Rectangle equipmentRect = new Rectangle(xPos, yPos, 100, 100);
        Rectangle playerRect = new Rectangle(player.getxPos(), player.getyPos(), 62, 100);
        
        return equipmentRect.intersects(playerRect);
    
    }
}
