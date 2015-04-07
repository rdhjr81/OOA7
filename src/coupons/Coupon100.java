/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coupons;
import ooa7.*;
/**
 *
 * @author lt
 */
public class Coupon100 extends ooa7.ReceiptDecorator{
    
    private Receipt r;
    private static final double couponThreshold = 100.00;
    
    public Coupon100(Receipt r){
        super(r);
    }
    
    public static boolean couponApplies(Double subtotal){
        return subtotal > couponThreshold;
    }
    
    
    @Override
    public void printReceipt(){
        callTrail();
        //coupon code
        System.out.println("**********************COUPON********************\n");
        
        System.out.println("            $10.00 off next purchase\n");
        System.out.println("************************************************\n");
    }
}
