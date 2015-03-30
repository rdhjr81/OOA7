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
            storeAddress = storeConfig.next();
            storeNumber = storeConfig.next();
            storeTelephone = storeConfig.next();
            storeState = storeConfig.next();
            
            System.out.println(storeAddress + storeNumber + storeTelephone + storeState);
            
            todaysDate = new GregorianCalendar();
        }
        catch(FileNotFoundException e){
            System.err.println("config file not found");
        }
    }
    
    public StoreClient(String configFileLocation){ //allow user to enter a specfic config file for test purposes
        try{
            Scanner storeConfig = new Scanner(new File(configFileLocation)).useDelimiter(";");
            storeAddress = storeConfig.next();
            storeNumber = storeConfig.next();
            storeTelephone = storeConfig.next();
            storeState = storeConfig.next();
            
            System.out.println(storeAddress + storeNumber + storeTelephone + storeState);
        }
        catch(FileNotFoundException e){
            System.err.println("config file not found");
        }
    }
    
    public GregorianCalendar setTodaysDate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter todays date: Day Month Year");
        System.out.println("Ex: 9 12 2015");
        int day = 0, month = 0, year = 0;
        
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();
        
        GregorianCalendar todaysDate = new GregorianCalendar(year, month, day);
        return todaysDate;
    }
    
    public void displayMenu(){
        System.out.println("1 - Start new Receipt");
        System.out.println("2 - Add Sales Items");
        System.out.println("3 - Display Receipt");
    }
    
    public void startTransaction(){
        
        GregorianCalendar todaysDate = setTodaysDate();
        
        Scanner in = new Scanner(System.in);
        int menuNumber;
        displayMenu();
        menuNumber = in.nextInt();
        
        switch(menuNumber){
            case 1:
                Receipt r = new Receipt();
            break;
            case 2:
                int itemNumber;
                
                if (r == null){
                     r = new Receipt();
                } 
                else{
                    ItemList y = ItemList.getItemList();
                    y.displayItems();
                    System.out.println("Enter item numbers to add to receipt");
                    while(in.hasNextInt()){
                        itemNumber = in.nextInt();
                        for(Iterator<Item> iter = y.iterator(); iter.hasNext();){
                            Job y = iter.next();
                            if(y.getArrival_time() == currentTime){
                                rrQueue.add(new Job(y));
                                System.out.println("Current time: " + currentTime);
                                System.out.println("Job arrived at " + y.getArrival_time() + " with burst time of " + y.getBurst_time());
                                iter.remove();
                        }
            }
    }
                    }
                }
            break;
            case 3:
            break;    
            default:
            
        }
    }
}
