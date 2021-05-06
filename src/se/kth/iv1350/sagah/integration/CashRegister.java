package se.kth.iv1350.sagah.integration;

/**
 * Represents the cash register
 * @author sagah
 */
public class CashRegister {
    private double amountInRegister;
    
    /**
    * Creates a new instance
    */
    public CashRegister(){}
    /**
     * Updates the amount present in the cash register
     * @param amountPaid The amount paid by the customer
     */
    public void updateCashRegister(double amountPaid){
        amountInRegister = amountInRegister + amountPaid;
    }
}