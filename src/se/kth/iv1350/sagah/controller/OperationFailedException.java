package se.kth.iv1350.sagah.controller;

/**
 *
 * @author sagah
 */
public class OperationFailedException extends Exception{
     /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param msg A message that describes what went wrong.
     * @param e The exception which caused the operation to fail
     */
    public OperationFailedException(String msg, Exception e){
        super(msg, e);
    }
    
}
