package se.kth.iv1350.sagah.model;

import se.kth.iv1350.sagah.integration.ItemDTO;

/**
 * Represent the most recently added item and the current state of the sale
 * @author sagah
 */
public class CurrentItem {
    private ItemDTO currentItem;
    private double runningTotal;
    /**
     * Creates a new instance
     * @param item The item that has been added
     * @param total The object containing the running total
     */
    public CurrentItem(ItemDTO item, SalePriceDTO total ){
        currentItem = item;
        runningTotal = total.getTotal();
    }
    /**
     * Gets the item name
     * @return Current item name
     */
    public String getName(){
        return currentItem.getName();
    }
    /**
     * Gets the item description
     * @return Current item description
     */
    public String getDescription(){
        return currentItem.getDescription();
    }
    /**
     * Gets the item price
     * @return Current item price
     */
    public double getPrice(){
        return currentItem.getPrice();
    }
    /**
     * Gets the running total
     * @return The running total
     */
    public double getRunningTotal(){
        return runningTotal;
    }
}
