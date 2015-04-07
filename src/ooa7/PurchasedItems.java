/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author lt
 */
public final class PurchasedItems {
    private double subtotal;
    private double total;
    private double tax;
    private GregorianCalendar todaysDate;
    private ArrayList<Item> purchasedList;
    private String state;
    
    //private Tax

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
    
    public ArrayList<Item> getPList(){
        return purchasedList;
    }
    
    public void setState(String s){
        this.state = s;
    }
    
    public String getState(){
        return state;
    }
    
    public PurchasedItems(){
        purchasedList = new ArrayList<>();
        subtotal = 0;
        total = 0;
        
    }
    public void addToPurchasedList(Item i){
        purchasedList.add(i);
        subtotal += i.getItemPrice();
    }
    
    public void setTodaysDate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter todays date: Day Month Year");
        System.out.println("Ex: 9 12 2015");
        int day = 0, month = 0, year = 0;
        
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();


        this.todaysDate = new GregorianCalendar(year, month, day);
        
        //this.todaysDate = new GregorianCalendar(1, 13, 2015);
        
    }
    public GregorianCalendar getTodaysDate(){
        return todaysDate;
    }
}
