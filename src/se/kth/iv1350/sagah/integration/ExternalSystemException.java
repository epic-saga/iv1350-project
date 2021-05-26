/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.integration;

/**
 *
 * @author sagah
 */
public class ExternalSystemException extends RuntimeException {
    /**
     * Is thrown when there is an issue with the external systems
     * @param msg 
     */
    public ExternalSystemException(String msg){
        super(msg);
    }
    
}
