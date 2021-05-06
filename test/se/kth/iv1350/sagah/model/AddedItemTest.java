/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.sagah.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.sagah.integration.ItemDTO;

/**
 *
 * @author Epic
 */
public class AddedItemTest {
    private AddedItem addedItem;
    private ItemDTO testItem;
    
    public AddedItemTest() {
    }
    
    @Before
    public void setUp() {
        testItem = new ItemDTO("TestName","TestDescription",1,1,1);
        addedItem = new AddedItem(testItem, 1);
    }
    
    @After
    public void tearDown() {
        testItem = null;
        addedItem = null;
    }

    /**
     * Test of increaseAmount method, of class AddedItem.
     */
    @Test
    public void testIncreaseAmount() {
        int amount = 1;
        AddedItem instance = addedItem;
        instance.increaseAmount(amount);
        int expResult = 2;
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }
    @Test
    public void testIncreaseAmountWithZero() {
        int amount = 0;
        AddedItem instance = addedItem;
        int expResult = instance.getAmount();
        instance.increaseAmount(amount);
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }    

    /**
     * Test of getIdentifier method, of class AddedItem.
     */
    @Test
    public void testGetIdentifier() {
        AddedItem instance = addedItem;
        int expResult = 1;
        int result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemDTO method, of class AddedItem.
     */
    @Test
    public void testGetItemDTO() {
        AddedItem instance = addedItem;
        ItemDTO expResult = testItem;
        ItemDTO result = instance.getItemDTO();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmount method, of class AddedItem.
     */
    @Test
    public void testGetAmount() {
        AddedItem instance = addedItem;
        int expResult = 1;
        int result = instance.getAmount();
        assertEquals(expResult, result);
    }
    
}
