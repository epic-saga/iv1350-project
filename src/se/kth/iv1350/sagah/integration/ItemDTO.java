package se.kth.iv1350.sagah.integration;

/**
 * Data transfer object for store items
 * @author sagah
 */
public class ItemDTO {
    private final String itemName;
    private final String itemDescription;
    private final double itemPrice;
    private final int itemIdentifier;
    private final double VAT;
    
    /**
     * Creates a new instance
     * @param name The item name
     * @param description The item description
     * @param price The item price
     * @param identifier The item identifier
     * @param taxRate The item tax rate
     */
    public ItemDTO(String name, String description, double price, int identifier, double taxRate){
        itemName = name;
        itemDescription = description;
        itemPrice = price;
        itemIdentifier = identifier;
        VAT = taxRate;
    }
    /**
     * Gets the name of the item
     * @return Item name
     */
    public String getName(){
        return itemName;
    }
    /**
     * Gets the description of the item
     * @return Item description
     */
    public String getDescription(){
        return itemDescription;
    }
    /**
     * Gets the price of the item
     * @return Item price
     */
    public double getPrice(){
        return itemPrice;
    }
    /**
     * Gets the identifier of the item
     * @return Item identifier
     */
    public int getIdentifier(){
        return itemIdentifier;
    }
    /**
     * Gets the tax rate of the item
     * @return Item VAT
     */
    public double getVAT(){
        return VAT;
    }
}
