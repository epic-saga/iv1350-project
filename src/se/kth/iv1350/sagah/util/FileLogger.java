/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.sagah.model.SalePriceDTO;

/**
 *
 * @author Epic
 */
public class FileLogger {
    private final PrintWriter logFile;
    private final DateHandler dateHandler;
    
    public FileLogger(String fileName) throws IOException{
        logFile = new PrintWriter(new FileWriter(fileName, true));
        dateHandler = new DateHandler();
    }
    public void logException(Exception e){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(dateHandler.createTime());
        logMsgBuilder.append("Exception was thrown: ");
        logMsgBuilder.append(e.getMessage());
        logFile.println(logMsgBuilder);
        e.printStackTrace(logFile);
        logFile.close();
    }
    public void logRevenue(double total){
        //System.out.println("logging revenue " + total);
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(dateHandler.createTime());
        logMsgBuilder.append(String.format(" Total revenue: %.2f SEK", total));
        logFile.println(logMsgBuilder);
        logFile.flush();
        //logFile.close();     
    }
    
}
