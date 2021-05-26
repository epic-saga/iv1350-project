package se.kth.iv1350.sagah.integration;

import se.kth.iv1350.sagah.model.Receipt;

class InventoryHandler {
    private ItemRegistry reg;
    InventoryHandler(){
        reg = new ItemRegistry();
    }
    ItemDTO searchForItem(int itemIdentifier) throws InvalidItemException{
        if(itemIdentifier == 13){
            throw new ExternalSystemException("Could not connect to database");
        }
        return reg.searchForItem(itemIdentifier);
    }
    void updateInventory(Receipt saleInfo){
        
    }
}