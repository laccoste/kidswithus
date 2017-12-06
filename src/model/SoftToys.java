package model;

import model.Product;
/*The import of this is needed in order to work with productclass in
this class */

public class SoftToys extends Product {  
///Extends function connects subclass SoftToys with Product-Superclass
    
	private String animalType;
    

    public SoftToys(int id, String type, String name, double price, String animalType, boolean available) {  //This is a constructor//
    	// Super lists the arguments that are inherited from the Product superclass     
    	super(id, type, name, price, available);
        
     
         // SoftToys have the additional argument for animalType
         this.animalType = animalType;

    }
public String getAnimalType() {
	return animalType;
}

}

