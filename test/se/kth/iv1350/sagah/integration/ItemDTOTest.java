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
public class ItemDTOTest {
    private ItemDTO testItem;
    
    public ItemDTOTest() {
    }
    
    @Before
    public void setUp() {
        testItem = new ItemDTO("TestName","TestDescription",1,1,1);
    }
    
    @After
    public void tearDown() {
        testItem = null;
    }

    /**
     * Test of getName method, of class ItemDTO.
     */
    @Test
    public void testGetName() {
        String expResult = "TestName";
        String result = testItem.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ItemDTO.
     */
    @Test
    public void testGetDescription() {
        ItemDTO instance = testItem;
        String expResult = "TestDescription";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class ItemDTO.
     */
    @Test
    public void testGetPrice() {
        ItemDTO instance = testItem;
        double expResult = 1;
        double result = instance.getPrice();
        assertEquals(expResult, result,0.0);
    }

    /**
     * Test of getIdentifier method, of class ItemDTO.
     */
    @Test
    public void testGetIdentifier() {
        ItemDTO instance = testItem;
        int expResult = 1;
        int result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVAT method, of class ItemDTO.
     */
    @Test
    public void testGetVAT() {
        ItemDTO instance = testItem;
        double expResult = 1;
        double result = instance.getVAT();
        assertEquals(expResult, result, 0.0);
    }
    
}
