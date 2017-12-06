package data;

import model.Product;

import java.util.ArrayList;


public class ProductDatabase {

	
	public static ArrayList<Product> productArrayList = new ArrayList<Product>();

    public  ProductDatabase() {

        
        productArrayList = DataInputOutput.getAllProductDetails();

    }
    




    public void addProduct(Product product) {

        productArrayList.add(product);

    }
   //This method allows you to remove products from the ArrayList
    public static void buyProduct(int i) {		
    
    	productArrayList.remove(i);
            }
    
        public static void writeUpdatedProductListToFile() {
        	DataInputOutput.emptyFile("products2.txt");
        	for (int i = 0; i < productArrayList.size(); i++) {
        		productArrayList.get(i).writeProductToFile();
        	}
        }

    

    public void setAvailableProducts(ArrayList <Product> productArrayList) {
    	this.productArrayList = productArrayList;
    }
    
    public ArrayList <Product> getAvailableProducts() {
        return productArrayList;
    
    }
    
 // Formatted Printing (Amended Example from Lecture)

 	/**
 	 * This method prints out a table of all available Products/Toys from the passed 
 	 * ArrayList called productArrayList. It is passed an ArrayList of generic Objects. 
 	 * Firstly, it is checked if the passed ArrayList is an instance of Products. 
 	 * If true, then there is a different printout Format compared to SoftToys.
 	 * A second check is if the Product is available. Only available Product are printed.
 	 * 
 	 */
 	public static void printProducts() {
 		System.out.println("\n  These are the products that are currently available: \n");		
 		System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", "ID" , "Product Name", "Type", "Price");
 		for (Product thisObject : productArrayList) { //for each object in productArrayList
				Product thisProduct = (Product)thisObject; // changing to type Product 
				if (thisProduct.getAvailable()){ // If true, then it is printed out. 
				System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", 
						productArrayList.indexOf(thisProduct), thisProduct.getName(), thisProduct.getType(), thisProduct.getPrice());
				}		
 			}
 	}
 		
 	public static void printClothes() {
 	 		System.out.println("\n  These are the products that are currently available: \n");		
 	 		System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", "ID" , "Product Name", "Type", "Price");
 	 		for (Product thisObject : productArrayList) { //for each object in productArrayList
 					Product thisProduct = (Product)thisObject; // changing to type Product 
 					if (thisProduct.getType().equals("Clothes")){ // If true, then it is printed out. 
 					System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", 
 							productArrayList.indexOf(thisProduct), thisProduct.getName(), thisProduct.getType(), thisProduct.getPrice());
 		
 		}
 					}
 	 		}
 		
 					public static void printSoftToys() {
 			 	 		System.out.println("\n  These are the products that are currently available: \n");		
 			 	 		System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", "ID" , "Product Name", "Type", "Price");
 			 	 		for (Product thisObject : productArrayList) { //for each object in productArrayList
 			 					Product thisProduct = (Product)thisObject; // changing to type Product 
 			 					if (thisProduct.getType().equals("SoftToys")){ // If true, then it is printed out. 
 			 					System.out.printf("  | %-2s | %-15s | %-8s | %-9s | \n", 
 			 							productArrayList.indexOf(thisProduct), thisProduct.getName(), thisProduct.getType(), thisProduct.getPrice());
 			 		

				
				
				
			}
 			 	 		}
 		}
}