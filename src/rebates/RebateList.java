/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//import ooa7.ItemList;

/**
 *
 * @author Robert
 */
public class RebateList implements Applicable{
    
    public boolean applies(){
        
    }
    
    private ArrayList<Rebate> rebateList; 
        
    private RebateList(){

        rebateList = new ArrayList<>();

        try{
            Scanner fileReader = new Scanner(new File(".\\config\\rebate_list.TXT"));

            int itemNumber;
            String rebateDesc, a;


            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();

                Scanner rdr = new Scanner(line).useDelimiter(";");
                a = rdr.next();

                rebateDesc = rdr.next(); 

                System.out.println(a + rebateDesc);
                itemNumber = Integer.parseInt(a);

                Rebate newItem = new Rebate(itemNumber,rebateDesc);

                rebateList.add(newItem);


            }
        }
        catch(FileNotFoundException e){
            System.err.println("config file not found");
        }
    }

    public static RebateList getRebateList(){
        return new RebateList();
    }
    
    public class Rebate{
         private final int itemNumber;
         private final String rebateDesc;
         

        public int getItemNumber() {
            return itemNumber;
        }

        public String getRebateDesc() {
            return rebateDesc;
        }

       

        public Rebate(int itemNumber, String rebateDesc) {
            this.itemNumber = itemNumber;
            this.rebateDesc = rebateDesc;
        }
         
         
    }
}
