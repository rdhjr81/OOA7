/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ooa7;

/**
 *  Robert Horner
 * 
 */
import java.util.Scanner;
public class OOA7 {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Select state:");
        System.out.println("1.  MD\n2.  MA\n3.  DE\n4.  CA");
        
        int state = input.nextInt();
        
        StoreClient x;
        switch(state){
            case 1:
                 x = new StoreClient(".\\config\\MD_store_config.TXT");
                 x.startTransaction();
                break;
            case 2:
                 x = new StoreClient(".\\config\\MA_store_config.TXT");
                 x.startTransaction();
                break;
            case 3:
                x = new StoreClient(".\\config\\DE_store_config.TXT");
                x.startTransaction();
                break;
            case 4:
                x = new StoreClient(".\\config\\CA_store_config.TXT");
                x.startTransaction();
                break;
            default: 
                System.out.println("State code not recognized");
        }
        
        
    }    

}
