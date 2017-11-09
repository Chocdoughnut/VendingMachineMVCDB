/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;


import com.sg.vmspringmvc.model.Items;
import java.util.List;

/**
 *
 * @author ritheenhep
 */
public interface VendingMachineDao {

    List<Items> getAllItems();

    Items getItem(String itemNumber);
    
    public void updateInventory(Items item);

}
