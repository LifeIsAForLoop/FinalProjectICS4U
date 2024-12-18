/* Equipment Class 
 * Subclass of item and extends item
 */
package gymsim;

public class Equipment extends Item {
// Attributes 

    int weight;
// Constructors

    public Equipment() {
    }

    public Equipment(int weight) {
        // Constructor Chaining 
        this();
        this.weight = weight;
    }
// Getter and setter for weight

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
