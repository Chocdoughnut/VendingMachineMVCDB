/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.model.Items;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

/**
 *
 * @author ritheenhep
 */
public class VendingMachineStubDaoInMemImpl implements VendingMachineDao {

    Items item;
    List<Items> allItems = new ArrayList<>();

    public VendingMachineStubDaoInMemImpl() {
        item = new Items("1");
        item.setItemName("DOTS");
        item.setItemPrice(new BigDecimal(1.00));
        item.setInventory(1);
        allItems.add(item);
    }

    @Override
    public List<Items> getAllItems() {

        return allItems;

    }

    @Override
    public Items getItem(String itemNumber) {
        if (itemNumber.equals(item.getItemNumber())) {
            return item;
        } else {
            return null;
        }
    }

    @Override
    public void updateInventory(Items item) {

        allItems.get(0).setInventory(item.getInventory() - 1);
    }

}
