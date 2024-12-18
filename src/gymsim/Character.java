/* Character class 
 * Extends abstract class Sprite
 */
package gymsim;

// Imports 
import java.awt.Image;

public class Character extends Sprite {
// Attributes 

    Sprite sprite;
    String name;
    int muscleMass;
    int enduranceLvl;
    int chestLvl;
    int backLvl;
    int tricepLvl;
    int bicepLvl;
    int legsLvl;
    int calvesLvl;
    int shoulderLvl;
    int forearmLvl;
    int absLvl;
    int boostMultiplier1;
    int boostMultiplier2;

// Constructors 
    /**
     * Primary constructor for Character class that accepts no parameters
     */
    public Character() {

    }

    /**
     * Secondary constructor for Character class that accepts all attributes as parameters
     *
     * @param sprite
     * @param name - The name of the character
     * @param muscleMass - The overall level (muscle) that the character has
     * @param enduranceLvl - The endurance level of the character
     * @param chestLvl - The chest level of the character
     * @param backLvl - The back level of the character
     * @param tricepLvl - The tricep level of the character
     * @param bicepLvl - The bicep level of the character
     * @param legsLvl - The leg level of the character 
     * @param calvesLvl - The calves level of the character
     * @param shoulderLvl - The shoulder level of the character
     * @param forearmLvl - The forearm level of the character
     * @param absLvl - The ab level of the character
     */
    public Character(Image sprite, String name, int muscleMass, int enduranceLvl, int chestLvl, int backLvl, int tricepLvl, int bicepLvl, int legsLvl, int calvesLvl, int shoulderLvl, int forearmLvl, int absLvl) {
        // Constructor chaining 
        this(); 
        //this.sprite = sprite; 
        this.name = name; 
        this.muscleMass = muscleMass; 
        this.enduranceLvl = enduranceLvl;
        this.enduranceLvl = chestLvl;
        this.enduranceLvl = backLvl;
        this.enduranceLvl = tricepLvl;
        this.enduranceLvl = bicepLvl;
        this.enduranceLvl = legsLvl;
        this.enduranceLvl = calvesLvl;
        this.enduranceLvl = shoulderLvl;
        this.enduranceLvl = forearmLvl;
        this.enduranceLvl = absLvl;
        // Setting boost multipliers to 1 
        boostMultiplier1 = 1; 
        boostMultiplier2 = 1; 
         
    }
    // Getters and setters 
    
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

    public int getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(int muscleMass) {
        this.muscleMass = muscleMass;
    }

    public int getEnduranceLvl() {
        return enduranceLvl;
    }

    public void setEnduranceLvl(int enduranceLvl) {
        this.enduranceLvl = enduranceLvl;
    }

    public int getChestLvl() {
        return chestLvl;
    }

    public void setChestLvl(int chestLvl) {
        this.chestLvl = chestLvl;
    }

    public int getBackLvl() {
        return backLvl;
    }

    public void setBackLvl(int backLvl) {
        this.backLvl = backLvl;
    }

    public int getTricepLvl() {
        return tricepLvl;
    }

    public void setTricepLvl(int tricepLvl) {
        this.tricepLvl = tricepLvl;
    }

    public int getBicepLvl() {
        return bicepLvl;
    }

    public void setBicepLvl(int bicepLvl) {
        this.bicepLvl = bicepLvl;
    }

    public int getLegsLvl() {
        return legsLvl;
    }

    public void setLegsLvl(int legsLvl) {
        this.legsLvl = legsLvl;
    }

    public int getCalvesLvl() {
        return calvesLvl;
    }

    public void setCalvesLvl(int calvesLvl) {
        this.calvesLvl = calvesLvl;
    }

    public int getShoulderLvl() {
        return shoulderLvl;
    }

    public void setShoulderLvl(int shoulderLvl) {
        this.shoulderLvl = shoulderLvl;
    }

    public int getForearmLvl() {
        return forearmLvl;
    }

    public void setForearmLvl(int forearmLvl) {
        this.forearmLvl = forearmLvl;
    }

    public int getAbsLvl() {
        return absLvl;
    }

    public void setAbsLvl(int absLvl) {
        this.absLvl = absLvl;
    }

    public int getBoostMultiplier1() {
        return boostMultiplier1;
    }

    public void setBoostMultiplier1(int boostMultiplier1) {
        this.boostMultiplier1 = boostMultiplier1;
    }

    public int getBoostMultiplier2() {
        return boostMultiplier2;
    }

    public void setBoostMultiplier2(int boostMultiplier2) {
        this.boostMultiplier2 = boostMultiplier2;
    }

}
