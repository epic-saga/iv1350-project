package se.kth.iv1350.sagah.model;

/**
 * Represents the payment for the sale
 * @author Epic
 */
public class PaymentDTO {
    private double amountPaid;
    private double change;
    
    /**
     * Creates a new instance, representing the amount paid and the change
     * @param amountPaid The amount paid by the customer
     * @param totalPrice The total cost of the sale
     */
    public PaymentDTO(double amountPaid, double totalPrice){
        this.amountPaid = amountPaid;
        change = Math.round((amountPaid - totalPrice)*100)/100.0d;
    }
    /**
     * Get the amount paid by the customer
     * @return Amount paid
     */
    public double getAmountPaid(){
        return amountPaid;
    }
    /**
     * Get the change for the sale
     * @return Change
     */
    public double getChange(){
        return change;
    }
}
