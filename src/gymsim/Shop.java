/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymsim;

import java.awt.*;

public class Shop {
    
    private Image image;
    private int xPos, yPos;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private Item item6;
    
    /**
     * 
     */
    public Shop() {
        
    }

    /**
     * 
     * @param item1
     * @param item2
     * @param item3
     * @param item4
     * @param item5
     * @param item6 
     */
    public Shop(Image image, int xPos, int yPos, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6) {
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
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
    public Item getItem1() {
        return item1;
    }

    /**
     * 
     * @param item1 
     */
    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    /**
     * 
     * @return 
     */
    public Item getItem2() {
        return item2;
    }

    /**
     * 
     * @param item2 
     */
    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    /**
     * 
     * @return 
     */
    public Item getItem3() {
        return item3;
    }

    /**
     * 
     * @param item3 
     */
    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    /**
     * 
     * @return 
     */
    public Item getItem4() {
        return item4;
    }

    /**
     * 
     * @param item4 
     */
    public void setItem4(Item item4) {
        this.item4 = item4;
    }

    /**
     * 
     * @return 
     */
    public Item getItem5() {
        return item5;
    }

    /**
     * 
     * @param item5 
     */
    public void setItem5(Item item5) {
        this.item5 = item5;
    }

    /**
     * 
     * @return 
     */
    public Item getItem6() {
        return item6;
    }

    /**
     * 
     * @param item6 
     */
    public void setItem6(Item item6) {
        this.item6 = item6;
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
