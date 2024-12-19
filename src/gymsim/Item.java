/* Item class for GymSim (abstract)
 */
package gymsim;

abstract public class Item {
    // Attributes 
    Sprite sprite; 
    String name; 
    int boostMultiplier; 
    // Constructors 
    public Item() {
        
    }
    
    public Item(Sprite sprite, String name, int boostMultiplier) {
        
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

    public int getBoostMultiplier() {
        return boostMultiplier;
    }

    public void setBoostMultiplier(int boostMultiplier) {
        this.boostMultiplier = boostMultiplier;
    }
    
    
    
    
    
}
