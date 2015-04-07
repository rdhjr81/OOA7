/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tax;

import java.util.GregorianCalendar;
import ooa7.PurchasedItems;

/**
 *
 * @author lt
 */
public class MATax extends Tax {
    private double taxRate;
    private double taxTotal;
    
    public MATax(PurchasedItems p){
        double subTotal = p.getSubtotal();
        
        GregorianCalendar d = p.getTodaysDate();
        this.taxRate = 0.07;
        if(d.get(d.MONTH) == 8){
            if(d.get(d.DAY_OF_MONTH) == 8 || d.get(d.DAY_OF_MONTH) == 9){
                this.taxRate = 0.0;
                System.out.println("Tax Holiday Engaged");
            }
        }
        
        this.taxTotal = subTotal * taxRate;
    }
    
    @Override
    public double getTax(){
        return taxTotal;
    }
}
