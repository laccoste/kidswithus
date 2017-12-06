package model;

import data.DataInputOutput;
import data.ProductDatabase;
import view.UserInterface;

public class Product {


	//Creating variables for the Product Superclass. Every Product has an id, a name, a type, a price and a status (available true/false)
	
    private int id; 
    private String name;
    private String type;
    private double price;
    private boolean available;
   

   public Product() {
	   
   }
    
    public Product(int id, String name, String type, double price, boolean available) { // Creating constructor with variables//
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.available = available;
        
    }
    //Creating Getters for the Product Object//
    public int getId() {
        return id;
    }
    
    public void setId(int Id) {
    this.id = id;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String Name) {
    	this.name = name;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double Price) {
    	this.price = price;
    }
    
    public String getType() {
    	return type;
    }
    
    public void setType(String Type) {
    	this.type = type;
    }
    
    public boolean getAvailable() {
    	return available;
    }
    
    public void setAvailable(boolean Available) {
    	this.available = available;
    }
    
    // This method allows admins to create a new product and save it to the product Database
    public void takeProductInput() {
    	this.id = (ProductDatabase.productArrayList.size() +1);
    	this.name = UserInterface.inputProductDetails("name");
    	this.type = UserInterface.inputProductDetails("type");
    	this.price = UserInterface.inputProductPrice();
    	this.available = UserInterface.inputProductAvailability();
    }
    
    // The toString() allows to write the actual objects to a file, and not just a coded representation of the object
    public String toString() {
    	return "Product [ID= " + getId() + ",Name= " + getName() + ",Type= " + getType() + ",Price= " + getPrice() + ",Available= " + getAvailable() +"]"; 
    }
    
    // This method writes the product to the file products2.txt
    public void writeProductToFile() {
		String productDetails = id + ";" + name +";" + type + ";" + price + ";" + available;
		DataInputOutput.WriteDetails("products2.txt", productDetails);
}
}