/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc;

;

import com.sg.vmspringmvc.dao.VendingMachineDao;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughItemException;
import com.sg.vmspringmvc.dao.VendingMachineNotEnoughMoneyException;
import com.sg.vmspringmvc.model.Items;
import com.sg.vmspringmvc.service.VendingMachineService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ritheenhep
 */


@Controller
public class VendingController {

    VendingMachineService service;

    @Inject
    public VendingController(VendingMachineService service) {

        this.service = service;
    }
    int[] change;
    
    String giveChange;
    String message = "";//formessage
    BigDecimal moneyInput;
    String itemId;//for button
    double userMoney = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayAllItems(HttpServletRequest request, Model model) {
        List<Items> itemList = service.getAllItems();
        model.addAttribute("itemList", itemList);
        model.addAttribute("itemId", itemId);
        model.addAttribute("giveChange", giveChange );
        model.addAttribute("change", change);
        model.addAttribute("message", message);
        model.addAttribute("displayMoney", userMoney);
        return "VendingMachine";

    }

    @RequestMapping(value = "/getItem", method = RequestMethod.POST)
    public String itemSelection(HttpServletRequest request) {
        itemId = request.getParameter("selectedItem");

        return "redirect:/";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public String money(HttpServletRequest request) {
        String addMoney = request.getParameter("money");

        if (addMoney.equals("one")) {
            userMoney += 1.00;
        }
        if (addMoney.equals("qrtr")) {
            userMoney += 0.25;
        }
        if (addMoney.equals("dime")) {
            userMoney += 0.10;
        }
        if (addMoney.equals("nickel")) {
            userMoney += 0.05;
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/buyItem", method = RequestMethod.POST)
    public String buyItem(HttpServletRequest request, Model model) {
       // String checkIdParameter = request.getParameter("item"); //get string ID
       // String checkMoneyParameter = request.getParameter("checkMoney");
        BigDecimal money = new BigDecimal(userMoney);
        Items currentItem = service.getItems(itemId);//getting item from service and pass in the ID

         if (userMoney == 0){
            message ="Please insert Money";
            return "redirect:/";
        }
         
        if(currentItem.equals("")){
            message = "please select an item";
            return "redirect:/";
            
        }
       
        
        try {
            service.verifyFunds(currentItem, money);
            service.verifyInventory(currentItem);

            BigDecimal buyItem = service.buyItem(currentItem, money);
           // change = Arrays.toString(service.giveChange(buyItem));
            change = service.giveChange(buyItem);
            service.updateInventory(currentItem);
            message=" Thank you! Item " + itemId + "| Despensed ";
            giveChange = "quarter " + change[0] 
                    + "| Dime " + change[1] 
                    +"| Nickle " + change[2]
                    +"| Pennies " + change[3];
            itemId="";
            userMoney = 0;
            
        } catch (VendingMachineNotEnoughMoneyException ex) {
            
            BigDecimal itemPrice = currentItem.getItemPrice();
            BigDecimal amountToAdd = itemPrice.subtract(money);
            message = "Not Enough Money" + amountToAdd;
            
        } catch (VendingMachineNotEnoughItemException ex) {
            message = "Not Enough Money";
        }
        
        
        return "redirect:/";
    }

    @RequestMapping(value = "/returnchange", method = RequestMethod.POST)
    public String returnChange(HttpServletRequest request, Model model) {
        BigDecimal money = new BigDecimal(userMoney);
         giveChange = "Money returned " + "$"+money;
         userMoney = 0;
      
     return "redirect:/";
    }
}
