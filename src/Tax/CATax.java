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
public class CATax extends Tax {
    private double taxRate;
    private double taxTotal;
    
    public CATax(PurchasedItems p){
        this.taxRate = 0.07;
        double subTotal = p.getSubtotal();
        this.taxTotal = subTotal * taxRate;
    }
    
    @Override
    public double getTax(){
        return taxTotal;
    }
}
