package se.kth.iv1350.sagah.model;

import se.kth.iv1350.sagah.integration.ItemDTO;
import java.util.*;

class SaleLog {
    private List<AddedItem> listOfItems;
    private final SalePrice salePrice;
    private CurrentItem currentItem;
    
    SaleLog(SalePrice salePrice){
        listOfItems = new ArrayList<>();
        this.salePrice = salePrice;
    }
    boolean itemAlreadyAdded(int identifier){
        boolean listContains = false;
        for (AddedItem item:listOfItems){
            if(item.getIdentifier() == identifier)
                listContains = true;
        }
        return listContains;
    }
    CurrentItem increaseAmount(int identifier, int amount){
        SalePriceDTO runningTotal;
        for (AddedItem item:listOfItems){
            if(item.getIdentifier() == identifier){
                item.increaseAmount(amount);
                runningTotal = salePrice.updatePrice(item.getItemDTO(), amount);
                currentItem = new CurrentItem(item.getItemDTO(), runningTotal);
            }
            
        }
        return currentItem;
    }
    CurrentItem addItem(ItemDTO item, int amount){
        SalePriceDTO runningTotal;
        AddedItem addedItem = new AddedItem(item, amount);
        listOfItems.add(addedItem);
        runningTotal = salePrice.updatePrice(item, amount);
        currentItem = new CurrentItem(item, runningTotal);
        return currentItem;
    }
    List<AddedItem> getItemList(){
        return listOfItems;
    }
    
}
