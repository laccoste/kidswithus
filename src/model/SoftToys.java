package model;

import model.Product;
/*The import of this is needed in order to work with productclass in
this class */

public class SoftToys extends Product {  
///Extends function connects subclass SoftToys with Product-Superclass
    
	private  String ageGroup;

public SoftToys() {
}

    public SoftToys(int id, String type, String name, double price,  boolean available, String ageGroup) {  //This is a constructor//
    	// Super lists the arguments that are inherited from the Product superclass     
    	super(id, type, name, price, available);
        
     
         // SoftToys have the additional argument for animalType
         this.ageGroup = ageGroup;
    }
public String getAgeGroup() {
	return ageGroup;
}

public void setAgeGroup(String ageGroup) {
	this.ageGroup = ageGroup;



}

}

