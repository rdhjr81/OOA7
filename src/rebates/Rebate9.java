/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebates;

import ooa7.PurchasedItems;
import ooa7.Item;
import ooa7.Receipt;
/**
 *
 * @author lt
 */
public class Rebate9 extends ooa7.ReceiptDecorator{
    private final String rebateMessage = "$500 Panasonic 50\" HDTV Mail-in rebate\n" +
            "Attach UPC and mail to:\nRebate Center\n10 Rebate Rd\nRebate City, RI 20202";
    private static final int rebateNumber = 9;
    
    public Rebate9(Receipt r){
        super(r);
    }
    
    
    public static boolean applies(PurchasedItems pList){
        for(Item x: pList.getPList()){
            if(x.getItemNumber() == rebateNumber)
                return true;
        }
        return false;
    }
    @Override
    public void printReceipt(){
        callTrail();
        System.out.println("********************REBATE**********************");
        System.out.println(rebateMessage);
        System.out.println("************************************************");
    }
}
