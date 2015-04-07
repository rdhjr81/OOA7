/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import ooa7.ItemList;
import ooa7.Item;
import java.util.ArrayList;
/**
 *
 * @author Robert
 */
public class StoreClient {
    private String storeAddress;
    private String storeNumber;
    private String storeTelephone;
    private String storeState;
    private Calendar todaysDate;
    
    public StoreClient(){
        try{
            Scanner storeConfig = new Scanner(new File(".\\config\\store_config.TXT")).useDelimiter(";");
            storeState = storeConfig.next();
            storeNumber = storeConfig.next();
            storeAddress = storeConfig.next();
            storeTelephone = storeConfig.next();
            
            
            System.out.println("Store state: " + storeState);
            System.out.println("Store Number: " + storeNumber);
            System.out.println("Store Address: " + storeAddress);
            System.out.println("Store Telephone: " + storeTelephone);
            System.out.println("\n\n\n");
            todaysDate = new GregorianCalendar();
        }
        catch(FileNotFoundException e){
            System.err.println("config file not found");
        }
    }
    
    public StoreClient(String configFileLocation){ //allow user to enter a specfic config file for test purposes
        try{
            Scanner storeConfig = new Scanner(new File(configFileLocation)).useDelimiter(";");
            storeState = storeConfig.next();
            storeNumber = storeConfig.next();
            storeAddress = storeConfig.next();
            storeTelephone = storeConfig.next();
            
            /*
            System.out.println("Store state: " + storeState);
            System.out.println("Store Number: " + storeNumber);
            System.out.println("Store Address: " + storeAddress);
            System.out.println("Store Telephone: " + storeTelephone);
            */
        }
        catch(FileNotFoundException e){
            System.err.println("config file not found");
        }
    }
    

    
    public void displayMenu(){
        System.out.println("1 - Start new Receipt");
        System.out.println("2 - Add Sales Items");
        System.out.println("3 - Display Receipt");
    }
    
    public void startTransaction(){
        
        Scanner in = new Scanner(System.in);
        
        //get todays date
        PurchasedItems pList = new PurchasedItems();
        pList.setTodaysDate();
        pList.setState(storeState);
        
        //System.out.println("Store state set to: " + storeState);
        
        int itemNumber;
                
        ItemList y = ItemList.getItemList();

        y.displayItems();
        
        System.out.println("Enter item numbers to add to receipt, q to exit");
        
        while(in.hasNextInt()){
            //get item number
            itemNumber = in.nextInt();
            for(Iterator<Item> iter = y.getItemListForIterator().iterator(); iter.hasNext();){
                Item x = iter.next();
                if(x.getItemNumber()== itemNumber){
                    pList.addToPurchasedList(new Item(x));
                    //System.out.println("Added item: " + x.getItemDesc() + " to receipt"); 
                }

            }

        }
        //System.out.println("Subtotal: " + pList.getSubtotal());
            
        ReceiptFactory r = new ReceiptFactory(pList);
        Receipt bestBuyReceipt =  r.getReceipt();
        printStoreInfo();
        bestBuyReceipt.printReceipt();
    }
    
    
    public void printStoreInfo(){
        System.out.println("BestBuy Store: " + storeNumber);
        System.out.println(storeAddress + " " + storeState);
        System.out.println("Store Telephone: " + storeTelephone);
    }    
}
