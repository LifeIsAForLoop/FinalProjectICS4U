/* CharacterMovement Class
 */
package gymsim;


public class CharacterMovement {
    // Attributes 
    Sprite sprite; 
    String name; 
    int xPos; 
    int yPos; 



    public CharacterMovement(Sprite sprite, String name, int xPos, int yPos) {
        // Constructor chaining 
        this.sprite = sprite;
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public String toString() {
        return "Unfinished"; 
    }
    
    
}
