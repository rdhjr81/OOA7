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
public class Rebate1 extends ooa7.ReceiptDecorator{
    private final String rebateMessage = "1 $20 Ballistix SDRAM Mail-in "
            + "rebate\nAttach UPC and mail to:\nRebate Center\n10 Rebate Rd\nRebate City, RI 20202";
    private static final int rebateNumber = 1;
    
    public Rebate1(Receipt r){
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
