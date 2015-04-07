/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

/**
 *
 * @author Robert
 */
public abstract class ReceiptDecorator extends Receipt{
    private Receipt trailReceipt;
    
    public ReceiptDecorator(Receipt trail){
        this.trailReceipt = trail;    
    }
    public void callTrail(){
        if(trailReceipt != null){
            trailReceipt.printReceipt();
        }
    }
}
