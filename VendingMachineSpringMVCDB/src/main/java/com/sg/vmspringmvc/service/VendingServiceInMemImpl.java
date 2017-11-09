/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingMachineDao;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughItemException;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughMoneyException;
import com.sg.vmspringmvc.model.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ritheenhep
 */
public class VendingServiceInMemImpl implements  VendingMachineService {
   
    private VendingMachineDao dao;
   
//    Change change;

    public VendingServiceInMemImpl(VendingMachineDao dao) {
        this.dao = dao;
       
    }

    @Override
    public List<Items> getAllItems(){
        return dao.getAllItems();

    }

    @Override
    public void updateInventory(Items item){
        dao.updateInventory(item);

    }

 @Override
    public int verifyInventory(Items item) throws
            VendingMachineNotEnoughItemException {

        int availableItem = item.getInventory();
        if (availableItem == 0) {

            throw new VendingMachineNotEnoughItemException("Item out of stuck");

        } else {

        }
        return availableItem;

    }

    @Override
    public Items getItems(String itemNumber) {
        return dao.getItem(itemNumber);
    }

    @Override
    public BigDecimal verifyFunds(Items item, BigDecimal funds) throws VendingMachineNotEnoughMoneyException {

        BigDecimal price = item.getItemPrice();

        if (funds.compareTo(price) <= - 1) {
            throw new VendingMachineNotEnoughMoneyException("Insufficient fund");
        }

        return funds;

    }

    @Override
    public BigDecimal buyItem(Items item, BigDecimal fund){
        BigDecimal price = item.getItemPrice();
        BigDecimal balance;
        balance = fund.subtract(price);
        return balance;

    }

    @Override
    public int[] giveChange(BigDecimal fund){
        double total = Double.valueOf(String.valueOf(fund));

        int quarter, dime, nickel, penny, cent;

        cent = (int) (total * 100);

        quarter = cent / 25;
        cent = cent % 25;

        dime = cent / 10;
        cent = cent % 10;

        nickel = cent / 5;
        cent = cent % 10;

        penny = cent;

        int[] coins = {quarter, dime, nickel, penny};

        return coins;

    }
  
}
