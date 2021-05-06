package se.kth.iv1350.sagah.model;

import se.kth.iv1350.sagah.integration.ItemDTO;

/**
 * Represents an item added to the sale log
 * @author sagah
 */
public class AddedItem {
    private int itemIdentifier;
    private ItemDTO itemDTO;
    private int amountOfItems;
    /**
     * Creates a new instance
     * @param item The item being added
     * @param amount The amount of the item being added
     */
    public AddedItem(ItemDTO item, int amount){
        itemDTO = item;
        amountOfItems = amount;
        itemIdentifier = item.getIdentifier();
    }
    void increaseAmount(int amount){
        amountOfItems = amountOfItems + amount;
    }
    /**
     * Gets the item identifier
     * @return Item identifier
     */
    public int getIdentifier(){
        return itemIdentifier;
    }
    /**
     * Gets the ItemDTO of the added item
     * @return ItemDTO
     */
    public ItemDTO getItemDTO(){
        return itemDTO;
    }
    /**
     * Gets the quantity of items added
     * @return Amount of an item
     */
    public int getAmount(){
        return amountOfItems;
    }
}
