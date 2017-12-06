package model;

import model.Product;

public class Clothes extends Product {
//Extends function connects subclass Clothes with Product-Superclass
   
	private  String color;
	private double price;
	
	public Clothes() {
	}
	// this is the Constructor for objects of the clothes type

    public Clothes(int id, String type, String name, double price,  boolean available, String color) { 
        super(id, type, name, price, available);

        // Clothes have an additional argument for color
        this.color = color;

    }
    
    public  String getColor(){
    	return color;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }

}

