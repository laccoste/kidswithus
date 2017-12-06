package model;
import data.ProductDatabase;
import view.*;
import java.util.ArrayList;
import java.util.Scanner;



public class ShoppingCart {

	// creating a new ArrayList that is called shoppingCart and that holds product objects

	private static ArrayList<Product> shoppingCart;
	
	public ShoppingCart() {
		
		shoppingCart = new ArrayList<Product>();
	}
	
	// this method allows you to choose a product from the product database and add it to the shopping cart by copying from one ArrayList to the other
	public static boolean chooseProduct() {
		
		// if the product database stores products (there are products that can be sold), the user can add the product
		// if there are no products in the databse, he will see that Kids With Us is out of stock and exit the store
		
		if (ProductDatabase.productArrayList.size() > 0) {
		
		// initialize an integer choice from an input in the User Interface	
			int choice = UserInterface.addToCart();		
			System.out.println("------------------------------------------------------------------------------");	
			System.out.println("You have added a " + " " + ProductDatabase.productArrayList.get(choice).getName() + " to your shopping cart");
			System.out.println("------------------------------------------------------------------------------");
			addToCart(ProductDatabase.productArrayList.get(choice));
			ProductDatabase.buyProduct(choice);
			
		}else { System.out.println("We are so sorry, but we are out of Stock. Thanks for visiting Kids With Us!");
			System.exit(0);
			}
		
		// after the user has added a product, he can add another product by pressing 1, or proceed to buying his shopping cart by pressing any other number
		
		System.out.println("Please press 1 if you want to continue shopping, or any other number if you want to show your Cart and proceed to payment");
		
		// while the boolean amendCart is true, the user can add products to shopping cart. 
		// once he presses any other number than one, he will be directed to the payment process
		boolean amendCart;
		Scanner input = new Scanner(System.in);
		int toggle = input.nextInt();

		while(amendCart = true)

		if (toggle == 1) {		
			ProductDatabase.printProducts();
			chooseProduct();
			amendCart = true;
			break;
			
			}	else {
				ShoppingCart.showCart();
				Payment.paymentOption();
				UserInterface.printReceipt();
				amendCart = false;	
				break;
	
	}
		return false;
		}

	
	// method to add products to the ArrayList shoppingCart
	public static void addToCart(Product product) {
		shoppingCart.add(product);
		
	}
	
	// method to delete products from the ArrayList shoppingCart (currently not used)

	public static void deleteProduct(Product product) {
		shoppingCart.remove(product);
		
		
	}
	
	// method to show the shopping cart to the user
	public static void showCart() {

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("\n  These are the products that are currently in your shopping cart: \n");		
		System.out.println("------------------------------------------------------------------------------");
		System.out.printf("  | %-8s | %-15s | %-8s | \n", "Quantity", "Model", "Price");
		
	// for every element in the shopping cart, print quantity 1, the elements name and price	
		for ( int i = 0; i < shoppingCart.size(); i++) {
		
		System.out.printf("  | %-8s | %-15s | %-8s | \n",
					"1", shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice());
	}
	
//		method to calculate the total price of the goods in the shopping cart
 			}
	public static double calculateTotalPrice() {
		double sum = 0;
		// sum up the prize for every element in the shopping cart
		for (int i = 0; i < shoppingCart.size(); i++) {
			
			sum += shoppingCart.get(i).getPrice();
			
		}
	return sum;
			
	// method to print out the receipt. Similar to printing the shopping cart, but different headline
	
	}
	public static void showReceipt() {
	System.out.println("------------------------------------------------------------------------------");
	System.out.printf("  | %-8s | %-15s | %-8s | \n", "Quantity", "Model", "Price");
	for ( int i = 0; i < shoppingCart.size(); i++) {
	
	System.out.printf("  | %-8s | %-15s | %-8s | \n",
				"1", shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice());
	
}}}