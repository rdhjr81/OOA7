package ooa7;


public class BasicReceipt extends Receipt{
    
    private PurchasedItems pList;
    
    public BasicReceipt(PurchasedItems pList){
        this.pList = pList;
    }
    @Override
    public void printReceipt(){
        System.out.println("\n\n********************RECEIPT**********************");
        
        System.out.println("Items Purchased:");
        for(Item x: pList.getPList()){
            System.out.printf("%-10d $%-10.2f %-25s\n",x.getItemNumber(),( x.getItemPrice()),x.getItemDesc());   
        }
        System.out.printf("Subtotal: $%-7.2f\n", pList.getSubtotal());
        
        System.out.printf("Tax:      $%-7.2f\n", pList.getTax());
        System.out.printf("Total:    $%-7.2f\n", pList.getTotal());
        System.out.println("\n************************************************\n");
        
    }
}