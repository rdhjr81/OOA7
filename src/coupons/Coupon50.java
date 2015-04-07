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
public class Coupon50 extends ooa7.ReceiptDecorator{
    
    private Receipt r;
    private static final double couponThreshold = 50.00;
    
    public Coupon50(Receipt r){
        super(r);
    }
    
    public static boolean couponApplies(Double subtotal){
        return subtotal > couponThreshold;
    }
    
    @Override
    public void printReceipt(){
        callTrail();
        //coupon code
        System.out.println("************************");
        System.out.println("*********Coupon*********");
        System.out.println("$5.00 off next purchase");    
        System.out.println("************************");
    }
}
