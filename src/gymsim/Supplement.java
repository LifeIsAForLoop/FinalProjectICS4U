/* Supplement Class
 * Extends Item class and is a subclass
 */
package gymsim;

public class Supplement extends Item {

    long duration;

    public Supplement() {
    }

    public Supplement(long duration) {
        // Constructor Chaining 
        this();
        this.duration = duration;
    }
    // Getter and setter for duration
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    
}
