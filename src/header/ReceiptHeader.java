/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package header;

import ooa7.ReceiptDecorator;
import ooa7.Receipt;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 *
 * @author lt
 */
public class ReceiptHeader extends ReceiptDecorator{
    
    
    
    public ReceiptHeader(Receipt r){
        
        super(r);
    }
    @Override
    public void printReceipt(){
        try{
            Scanner in = new Scanner(new File(".\\config\\normal_header.TXT"));
            String greeting = in.nextLine();
            System.out.println(greeting);
        }
        catch(FileNotFoundException e){
            System.err.println("Regular header not found");}
        callTrail();
    }
}
