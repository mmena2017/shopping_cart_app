
package com.cop4331.shopping_cart_app.item;

import java.text.DecimalFormat;

/**
 *
 * @author Justin Ament
 */

public class Item {
    private  String name="";
    private  String item_description="";
    int quantity=0;
    private  int sellerID=-1; 
    private  double price=0;
	private double invPrice=0;
    
    //name, description, quantity, price
    public Item(String name, String item_description, int sellerID, int quantity, double price, double invPrice) {
        this.name=name;
        this.item_description=item_description;
        this.sellerID=sellerID;
        this.quantity=quantity;
        this.price=price;
        this.invPrice=invPrice;
    }
    
    //Item doesn't exist
    public Item() {

    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return item_description;
    }
    
    public int getSellerID() {
        return sellerID;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getPrice() { 
    	DecimalFormat form=new DecimalFormat("0.00");
    	return form.format(price);
    }
    
    public String getInvPrice() {
    	DecimalFormat form=new DecimalFormat("0.00");
    	return form.format(this.invPrice);
    }
    
    public void setQuantity(int q) {
    	this.quantity = q;
    }
    
    //used for testing purposes
    public String print() {
    	return name+" "+ item_description + " " + Integer.toString(quantity) + " " + Double.toString(price);
    }
}
