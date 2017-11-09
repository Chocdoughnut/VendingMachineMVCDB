/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

/**
 *
 * @author ritheenhep
 */
public class VendingMachineNotEnoughItemException extends Exception {
   
    public VendingMachineNotEnoughItemException(String message) {
        super(message);
    }
    
     public VendingMachineNotEnoughItemException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
