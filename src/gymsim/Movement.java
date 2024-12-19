/* Movement Class
 */
package gymsim;


public class Movement {
    // Attributes 
    Sprite sprite; 
    String name; 
    int weight; 
    int repCount; 
    int xPos; 
    int yPos; 

    public Movement() {
    }

    public Movement(Sprite sprite, String name, int weight, int repCount, int xPos, int yPos) {
        // Constructor chaining 
        this();
        this.sprite = sprite;
        this.name = name;
        this.weight = weight;
        this.repCount = repCount;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
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
