/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

import Tax.MATax;
import Tax.MDTax;
import header.ReceiptHeader;
import header.ReceiptHolidayHeader;
import header.SummerHeader;
import java.util.GregorianCalendar;
import rebates.Rebate1;
import rebates.Rebate9;
import Tax.*;
import coupons.Coupon100;
import coupons.Coupon50;

/**
 *
 * @author lt
 */
public class ReceiptFactory {
    
    private PurchasedItems pList;
    private Receipt r;
    
    public ReceiptFactory(PurchasedItems pList){
        this.pList =  pList;
        this.r = constructReceipt(pList);
    }
    
    public Receipt constructReceipt(PurchasedItems pList){
        
        r = new BasicReceipt(pList); 
        getTax();
        r = getHeader(r);
        r = getRebate(r);
        r = getCoupon(r);
        return r;    
    }
    
            
            
    public Receipt getReceipt(){
        
        return r;
    }
    
    
    public void getTax(){
        
        Tax t;
        if(pList.getState().equals("MD")){
                t = new MDTax(pList);
                System.out.println("MD TAX applying");
        }
        else if(pList.getState().equals("MA")){
            t = new MATax(pList);
            System.out.println("MA TAX applying");
        }
        else if(pList.getState().equals("CA")){
            t = new CATax(pList); 
            System.out.println("CA TAX applying");
        }
        else
            t = null;
        
        if(t !=null)
            pList.setTax(t.getTax());
        else
            pList.setTax(0.00);
        
        pList.setTotal(pList.getSubtotal() + pList.getTax());
    }
    
    public Receipt getHeader(Receipt r){
        GregorianCalendar d = pList.getTodaysDate();
        int month = d.get(d.MONTH);
        if(month > 10){
            r = new ReceiptHolidayHeader(r);
        }
        else if(month > 6){
            r = new SummerHeader(r);
        }
        else{
            r = new ReceiptHeader(r);
        }
        return r;
    }
    
    public Receipt getRebate(Receipt r){
        if(rebates.Rebate1.applies(pList))
            r = new Rebate1(r);
        if(rebates.Rebate9.applies(pList))
            r = new Rebate9(r);
        return r;
    }
    public Receipt getCoupon(Receipt r){
        if(coupons.Coupon100.couponApplies(pList.getSubtotal()))
            r = new Coupon100(r);
        else if(coupons.Coupon50.couponApplies(pList.getSubtotal()))
            r = new Coupon50(r);
        return r;
    }
}
