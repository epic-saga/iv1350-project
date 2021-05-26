/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.util;

import java.io.IOException;
import se.kth.iv1350.sagah.model.SaleObserver;
import se.kth.iv1350.sagah.model.SalePriceDTO;

/**
 *
 * @author Epic
 */
public class TotalRevenueFileOutput implements SaleObserver{
    private final FileLogger revenueLog;
    private double total;
    
    public TotalRevenueFileOutput() throws IOException{
        revenueLog = new FileLogger("revenue-log.txt");
    }
    @Override
    public void completedSale(SalePriceDTO totalPrice) {
        total = total + totalPrice.getTotal();
        revenueLog.logRevenue(total);
        //System.out.println("observer notified" + total);
    }
}
