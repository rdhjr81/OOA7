/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import ooa7.Item;

/**
 *
 * @author Robert
 */
public class ItemList {
        
        private ArrayList<Item> itemList; 
        
        private ItemList(){
            
            itemList = new ArrayList<>();
            
            try{
            Scanner fileReader = new Scanner(new File(".\\config\\item_list.TXT"));
            
            int itemNumber;
            String itemDesc, a, b;
            float itemPrice;
            
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                
                Scanner rdr = new Scanner(line).useDelimiter(";");
                a = rdr.next();
                
                b = rdr.next();
                
                itemDesc = rdr.next(); 
                
                //System.out.println(a + " " + b + " " + itemDesc);
                itemNumber = Integer.parseInt(a);
                itemPrice = Float.parseFloat(b);
                
                
                Item newItem = new Item(itemNumber,itemDesc,itemPrice);
                
                itemList.add(newItem);
                
                
            }
            }
            catch(FileNotFoundException e){
                System.err.println("config file not found");
            }
        }
        
        public static ItemList getItemList(){
            return new ItemList();
        }
        public ArrayList<Item> getItemListForIterator(){
            return itemList;
        }
    
    
    public void displayItems(){
        String itemNumberLabel ="Item Number";
        String itemPriceLabel ="Item Price";
        String itemDescLabel ="Item Description";
        int lenOfItemNumLabel = itemNumberLabel.length();
        int lenOfItemPriceLabel = itemPriceLabel.length();
        int lenOfItemDescLabel = itemDescLabel.length();
        
        
        System.out.println("\n\n\n************************************************");
        System.out.println("****************ITEM LIST***********************");
        System.out.printf("%" + lenOfItemNumLabel + "s %" + lenOfItemPriceLabel + "s %" + 
                lenOfItemDescLabel + "s\n", itemNumberLabel, itemPriceLabel, itemDescLabel);
        for(Item x: itemList){
            System.out.printf("%-" + lenOfItemNumLabel + "d $%-" + lenOfItemPriceLabel + 
                    ".2f %-25s\n",x.getItemNumber(),( x.getItemPrice()),x.getItemDesc());    
        }
        System.out.println("************************************************");
        System.out.println("************************************************\n\n\n");
        
    }
}
