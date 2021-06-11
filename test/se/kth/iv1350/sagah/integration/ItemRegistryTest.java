/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Epic
 */
public class ItemRegistryTest {
    
    public ItemRegistryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchForItem method, of class ItemRegistry.
     */
    @Test
    public void testSearchForItemThatDoesNotExist() throws Exception {
        int identifier = 0;
        ItemRegistry instance = new ItemRegistry();
        ItemDTO result = null;
        try{
            result = instance.searchForItem(identifier);
            fail("Could find item that should not exist");
        }
        catch(InvalidItemException e){
        }
        
    }
    
}
