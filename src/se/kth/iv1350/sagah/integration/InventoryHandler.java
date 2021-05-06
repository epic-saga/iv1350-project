package se.kth.iv1350.sagah.integration;

import se.kth.iv1350.sagah.model.Receipt;

class InventoryHandler {
    private ItemRegistry reg;
    InventoryHandler(){
        reg = new ItemRegistry();
    }
    ItemDTO searchForItem(int itemIdentifier){
        return reg.searchForItem(itemIdentifier);
    }
    void updateInventory(Receipt saleInfo){
        
    }
}