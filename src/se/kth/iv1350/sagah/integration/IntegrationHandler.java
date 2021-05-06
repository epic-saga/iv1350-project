/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.integration;

import se.kth.iv1350.sagah.model.Receipt;

/**
 * Handles the communication between the integration layer and other layers
 * @author sagah
 */
public class IntegrationHandler {
    private final InventoryHandler inv;
    private final AccountingHandler acc;
    private final ReceiptPrinter prt;
    /**
     * Creates a new IntegrationHandler instance and makes relevant initializations
     */
    public IntegrationHandler() {
        inv = new InventoryHandler();
        acc = new AccountingHandler();
        prt = new ReceiptPrinter();
    }
    /**
     * Searches the inventory for specific item
     * @param itemIdentifier The identifier for the desired item
     * @return The ItemDTO of the item searched for
     */
    public ItemDTO getItem(int itemIdentifier){
        return inv.searchForItem(itemIdentifier);
    }
    /**
     * Signals completed sale
     * @param saleInfo The information about the completed sale
     */
    public void completedSale(Receipt saleInfo){
        inv.updateInventory(saleInfo);
        acc.updateAccounting(saleInfo);
        prt.printReceipt(saleInfo);
    }
}
