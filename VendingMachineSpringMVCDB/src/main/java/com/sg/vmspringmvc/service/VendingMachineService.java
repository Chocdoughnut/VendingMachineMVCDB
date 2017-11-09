/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingMachineNotEnoughItemException;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughMoneyException;
import com.sg.vmspringmvc.model.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ritheenhep
 */
public interface VendingMachineService {
     
    List<Items> getAllItems();

    Items getItems(String itemNumber);

    void updateInventory(Items item);

    BigDecimal buyItem(Items item, BigDecimal funds);

    int[] giveChange(BigDecimal balance);

    int verifyInventory(Items item)throws VendingMachineNotEnoughItemException ;

    BigDecimal verifyFunds(Items item, BigDecimal funds)throws VendingMachineNotEnoughMoneyException;

    
}
