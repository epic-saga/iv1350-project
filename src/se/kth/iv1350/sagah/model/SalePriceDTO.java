package se.kth.iv1350.sagah.model;

/**
 * Represents the price for the ongoing sale
 * @author sagah
 */
public class SalePriceDTO {
    private double total;
    private double itemPrice;
    private double vatPrice;
    
    /**
     * Creates a new instance representing the current state of the cost of the sale
     * @param itemPrice Total cost of the items that have been added
     * @param vatPrice Total cost of taxes for the sale
     */
    public SalePriceDTO(double itemPrice, double vatPrice){
        this.itemPrice = itemPrice;
        this.vatPrice = Math.round((vatPrice)*100)/100.0d;
        this.total = this.itemPrice + this.vatPrice;
    }
    /**
     * Get total cost of sale
     * @return Total cost
     */
    public double getTotal(){
        return total;
    }
    /**
     * Get total cost of items
     * @return Item cost
     */
    public double getItemPrice(){
        return itemPrice;
    }
    /**
     * Get total cost of taxes
     * @return Tax cost
     */
    public double getVatPrice(){
        return vatPrice;
    }
}
