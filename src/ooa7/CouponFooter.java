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
public class CouponFooter extends TicketDecorator {
    
    public CouponFooter(Component c){
        super(c);
    }
    
    public void printTicket(){
       callTrail();
       //printCOupon stuff
    }
}
