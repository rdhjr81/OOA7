/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tax;

import ooa7.PurchasedItems;

/**
 *
 * @author lt
 */
public class MDTax extends Tax {
    private double taxRate = 0.06;
    private double taxTotal;
    
    
    public MDTax(PurchasedItems p){
        this.taxRate = 0.06;
        double subTotal = p.getSubtotal();
        this.taxTotal = subTotal * taxRate;
    }
    
    public double getTax(){
        return taxTotal;
    }
}
