/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

import java.awt.*;

/**
 *
 * @author MiSat0535
 */
public class Item {

    private Image image;
    private int xPos, yPos;
    private String name;
    private double boostMultiplier;

    /**
     *
     */
    public Item() {
        image = null;
        name = null;
        boostMultiplier = 1;
    }

    /**
     *
     * @param image
     * @param name
     * @param boostMultiplier
     */
    public Item(Image image, int xPos, int yPos, String name, double boostMultiplier) {
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        this.boostMultiplier = boostMultiplier;
    }

    /**
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public double getBoostMultiplier() {
        return boostMultiplier;
    }

    /**
     *
     * @param boostMultiplier
     */
    public void setBoostMultiplier(double boostMultiplier) {
        this.boostMultiplier = boostMultiplier;
    }

    public boolean isPlayerInteracting(Player player) {

        // Basic collision detection for interaction
        Rectangle equipmentRect = new Rectangle(xPos, yPos, 100, 100);
        Rectangle playerRect = new Rectangle(player.getxPos(), player.getyPos(), 62, 100);

        return equipmentRect.intersects(playerRect);

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
