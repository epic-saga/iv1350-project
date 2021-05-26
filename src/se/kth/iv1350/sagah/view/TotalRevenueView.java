/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.view;

import se.kth.iv1350.sagah.model.SaleObserver;
import se.kth.iv1350.sagah.model.SalePriceDTO;

/**
 *
 * @author Epic
 */
public class TotalRevenueView implements SaleObserver{
    private double total;

    @Override
    public void completedSale(SalePriceDTO totalPrice) {
        total = total + totalPrice.getTotal();
        System.out.println(String.format("Total revenue is %.2f SEK", total));
    }
    
}
