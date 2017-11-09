/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;


import com.sg.vmspringmvc.model.Items;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ritheenhep
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

   Map<String, Items> itemsList = new HashMap();

    public VendingMachineDaoInMemImpl() {

        Items item1 = new Items("1");
        item1.setInventory(1);
        item1.setItemName("DOTS");
        item1.setItemPrice(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("1" ,item1);

        Items item2 = new Items("2");
        item2.setInventory(4);
        item2.setItemName("Gummy Worms");
        item2.setItemPrice(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("2", item2);

        Items item3 = new Items("3");
        item3.setInventory(4);
        item3.setItemName("KitKat");
        item3.setItemPrice(new BigDecimal(3.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("3", item3);

        Items item4 = new Items("4");
        item4.setInventory(4);
        item4.setItemName("HERSEY'S");
        item4.setItemPrice(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("4", item4);

        Items item5 = new Items("5");
        item5.setInventory(0);
        item5.setItemName("Twix");
        item5.setItemPrice(new BigDecimal(2.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("5", item5);

        Items item6 = new Items("6");
        item6.setInventory(4);
        item6.setItemName("LIFESAVERS");
        item6.setItemPrice(new BigDecimal(2.00).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("6" , item6);

        Items item7 = new Items("7");
        item7.setInventory(4);
        item7.setItemName("CRUNCH");
        item7.setItemPrice(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("7", item7);

        Items item8 = new Items("8");
        item8.setInventory(4);
        item8.setItemName("HamBurger");
        item8.setItemPrice(new BigDecimal(9.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("8", item8);

        Items item9 = new Items("9");
        item9.setInventory(4);
        item9.setItemName("BBQ Ribs");
        item9.setItemPrice(new BigDecimal(5.50).setScale(2, RoundingMode.HALF_UP));
        itemsList.put("9", item9);

    }
    
    
    @Override
    public List<Items> getAllItems() {
        Collection<Items> allItems= itemsList.values();
        return new ArrayList(allItems);
    }

    @Override
    public Items getItem(String itemNumber) {
      return itemsList.get(itemNumber);
     
    }
   
    @Override
    public void updateInventory(Items item) {  
    Items currentItem = itemsList.get(item.getItemNumber());
    currentItem.setInventory(currentItem.getInventory()-1);
    }

    
    
}
