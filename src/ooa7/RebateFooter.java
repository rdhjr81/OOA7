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
public class RebateFooter extends TicketDecorator{
    public RebateFooter(Component c){
        super(c);
    }
    
    public void printTrail(){
        callTrail();
        //print rebate stuff
    }
            
}
