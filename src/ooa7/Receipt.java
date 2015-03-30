package ooa7;

import java.util.ArrayList;
import ooa7.ItemList.Item;
public class Receipt extends Component{
    private ArrayList<Item> purchasedList;
    private float subtotal;
    private float total;

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getTotal() {
        return total;
    }
    
    public Receipt(){
        purchasedList = new ArrayList<>();
        subtotal = 0;
        total = 0;
    }
    @Override
    public void printTicket(){
        if(purchasedList.isEmpty()){
            
        }
        
        else{
            
        }    
    }
    
    public void addToPurchasedList(Item i){
        purchasedList.add(i);
        subtotal += i.getItemPrice();
    }
}