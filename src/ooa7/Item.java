/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooa7;

/**
 *
 * @author lt
 */
public class Item{
         private final int itemNumber;
         private final String itemDesc;
         private final float itemPrice;

        public int getItemNumber() {
            return itemNumber;
        }

        public String getItemDesc() {
            return itemDesc;
        }

        public float getItemPrice() {
            return itemPrice;
        }

        public Item(int itemNumber, String itemDesc, float itemPrice) {
            this.itemNumber = itemNumber;
            this.itemDesc = itemDesc;
            this.itemPrice = itemPrice;
        }
        public Item(Item otherItem) {
            this.itemNumber = otherItem.itemNumber;
            this.itemDesc = otherItem.itemDesc;
            this.itemPrice = otherItem.itemPrice;
        }
         
         
    }