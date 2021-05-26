package se.kth.iv1350.sagah.integration;

import java.util.ArrayList;
import java.util.List;

class ItemRegistry {
    private List<ItemDTO> itemList;
    ItemRegistry(){
        itemList = new ArrayList();
        createItems();
    }
    private void createItems(){
        itemList.add(new ItemDTO("Tomato", "Technically fruit", 5, 1, 0.12));
        itemList.add(new ItemDTO("Coffee", "Morning brew", 30, 2, 0.25));
        itemList.add(new ItemDTO("Flour", "1kg wheat flour", 9, 3, 0.6));
        itemList.add(new ItemDTO("Bread", "Get that bread", 6, 4, 0.6));
        itemList.add(new ItemDTO("Juice", "When life gives you lemons", 25, 5, 0.12));
        itemList.add(new ItemDTO("Chocolate", "Bitter-sweet", 28, 6, 0.25));
        itemList.add(new ItemDTO("Banana", "I am a banana", 7, 7, 0.12));
        itemList.add(new ItemDTO("Cabbage", "Brought to you by that one merchant", 6, 8, 0.6));
        itemList.add(new ItemDTO("Garlic", "To keep the demons at bay", 20, 9, 0.12));
        itemList.add(new ItemDTO("Bay leaves", "For soup for your family", 12, 10, 0.6));
    }
    ItemDTO searchForItem(int identifier) throws InvalidItemException{
        for (ItemDTO item : itemList){
            if(item.getIdentifier() == identifier)
                return item;
        }
        throw new InvalidItemException("There is no item with identifier " + identifier);
    }
}
