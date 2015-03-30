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
public abstract class TicketDecorator extends Component{
    private Component trailComponent;
    
    public TicketDecorator(Component trail){
        trailComponent = trail;    
    }
    public void callTrail(){
        if(trailComponent != null){
            trailComponent.printTicket();
        }
    }
}
