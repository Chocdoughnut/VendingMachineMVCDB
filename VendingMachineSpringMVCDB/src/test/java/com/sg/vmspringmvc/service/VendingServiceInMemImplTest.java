/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingMachineDao;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughItemException;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughMoneyException;
import com.sg.vmspringmvc.dao.VendingMachineStubDaoInMemImpl;
import com.sg.vmspringmvc.model.Items;
import java.math.BigDecimal;
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
public class VendingServiceInMemImplTest {
    VendingMachineService service;
    
    public VendingServiceInMemImplTest() {
        VendingMachineDao dao = new VendingMachineStubDaoInMemImpl();
        service = new VendingServiceInMemImpl(dao);
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
     * Test of getAllItems method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testGetAllItems() {
    }

    /**
     * Test of updateInventory method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testUpdateInventory(){
    
    }
       

    /**
     * Test of verifyInventory method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testVerifyInventory() throws Exception {
        Items checkInv= service.getItems("1");
        try{
            service.verifyInventory(checkInv);
        }catch(VendingMachineNotEnoughItemException e){
            fail("code is broken");
        }
    
    }

    /**
     * Test of getItems method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testGetItems() {
    }

    /**
     * Test of verifyFunds method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testVerifyFunds() throws Exception {
       Items item = new Items ("4");
       item.setItemPrice(BigDecimal.ONE);
       try{
           service.verifyFunds(item, BigDecimal.TEN);
       }catch(VendingMachineNotEnoughMoneyException ex){
           fail("broken Code");
       }
    }

    /**
     * Test of buyItem method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testBuyItem()throws Exception {
        Items item = new Items("1");
        item.setItemPrice(BigDecimal.ONE);
        BigDecimal buyItem = service.buyItem(item, BigDecimal.ONE);
        try{
            service.buyItem(item, buyItem);
        }catch(Exception ex){
            fail("not subtract fund from price.");
        }
    }

    /**
     * Test of giveChange method, of class VendingServiceInMemImpl.
     */
    @Test
    public void testGiveChange() {
    }
    
}
