/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.model.Items;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ritheenhep
 */
public class VendingMachineDaoInMemImplTest {
    
   private static  VendingMachineDao dao;
    
    public VendingMachineDaoInMemImplTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
         dao = new VendingMachineDaoInMemImpl();
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
     * Test of getAllItems method, of class VendingMachineDaoInMemImpl.
     */
    @Test
    public void testGetAllItems() {
        assertEquals(9, dao.getAllItems().size());
        
    }

    /**
     * Test of getItem method, of class VendingMachineDaoInMemImpl.
     */
    @Test
    public void testGetItem() {
        Items getItem = dao.getItem("1");
        assertNotNull(getItem);
    }

    /**
     * Test of updateInventory method, of class VendingMachineDaoInMemImpl.
     */
    @Test
    public void testUpdateInventory() {
        dao.updateInventory(dao.getItem("2"));
        assertEquals(3, dao.getItem("2").getInventory());
    }
    
}
