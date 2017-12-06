package model;
import view.*;

//import java.util.ArrayList;

public class Payment {
	
//	private ShoppingCart cart;

	public  void paymentOption() {
		
		
		// This method shows all elements that are in the shopping cart plus their final price. The 
		// The switch lets the user decide between paying with a credit card or wire transfer
		
		int paymentOption = UserInterface.paymentOptions();
		switch (paymentOption) {
		
		case 1: 
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Please review your shopping cart");
			System.out.println("------------------------------------------------------------------------------");
			break;
		case 2:
			System.out.println("Thanks for your business!");
			break;
			
		default: System.out.println("We only accept CreditCards or WireTransfers");
	}
		
		
}
}