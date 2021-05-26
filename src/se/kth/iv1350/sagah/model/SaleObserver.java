/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.model;

/**
 * A listener interface for receiving notifications about sales
 */
public interface SaleObserver {
    
    /**
     * Invoked when a sale has been completed
     * @param totalPrice The total price for the sale
     */
    void completedSale(SalePriceDTO totalPrice);
}
