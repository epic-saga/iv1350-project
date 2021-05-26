package se.kth.iv1350.sagah.integration;

/**
 *
 * @author sagah
 */
public class InvalidItemException extends Exception{
     /**
     * Creates a new instance for when something goes wrong with an item
     *
     * @param msg A message that describes what went wrong.
     */
    public InvalidItemException(String msg){
        super(msg);
    }
    
}
