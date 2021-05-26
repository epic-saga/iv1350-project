/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author Epic
 */
public class DateHandler {
    public DateHandler(){
        
    }
    public String createTime() {
        LocalDateTime now = LocalDateTime.now();
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d-%02d-%02d ", now.getYear(), now.getMonthValue(), now.getDayOfMonth()));
        builder.append(String.format("%02d:%02d\n" , now.getHour(), now.getMinute()));
        return builder.toString();
    }
    
}
