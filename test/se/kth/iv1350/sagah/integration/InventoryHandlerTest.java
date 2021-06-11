/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Epic
 */
public class InventoryHandlerTest {
    private InventoryHandler instance;
    
    public InventoryHandlerTest() {
    }
    @Before
    public void setUp() {
        instance = new InventoryHandler();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of external system error handling, of class InventoryHandler.
     */
    @Test
    public void testConnectionError() throws InvalidItemException {
        int id = 13;
        ItemDTO result = null;
        try{
            result = instance.searchForItem(id);
            fail("Could connect to registry");
        }
        catch(ExternalSystemException e){
            
        }
    }
    
}
