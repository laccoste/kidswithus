package view;

import java.util.*;

import data.DataInputOutput;
import data.UserDatabase;
import model.ShoppingCart;
import model.User;




	public class UserInterface {

		public UserInterface() {

		}

// method that prompts the user for details that are String e.g first name, last name etc.
		public static String inputDetails(String details) {
			Scanner input = new Scanner(System.in);
			System.out.println("\t> Please enter your " + details + ":");
			return (input.nextLine());
		}

// method that prompts the user to enter an integer input of a specific length, e.g. the phone number
		public static int inputDetails(int details, int length) {
			Scanner input = new Scanner(System.in);
			System.out.println("\t> Please enter your " + details + ":");
			int phoneNumber = input.nextInt();
			// Check format of the number
			 {
				System.out.println(
						"Please enter a valid " + details + " number, that consists of exact" + length + " characters.");
				phoneNumber = input.nextInt();
			}
			return phoneNumber;

		}

// method that prompts the user to enter a string with a specific pattern
// the format for the date of birth is \\d{2}.\\d{2}.\\d{4}, meaning 2 digits, followed by a dot, followerd by 2 digits, followed by a dot, followed by 4 digits
// the cpr pattern is\\d{6}-\\d{4}, meaning 6 digits, followed by a minus, followed by 4 digits
		
		public static String inputDetails(String details, String pattern) {
			Scanner input = new Scanner(System.in);
			
			String value = "";
			if (details.toLowerCase().contains("date")) {
				// DOB need exactly 8 digits
				System.out.print("\t> Please enter your Date of birth in the Format: DD.MM.YYYY: ");
				value = input.next();
			}
			if (details.toLowerCase().contains("cpr")) {
				// DOB need exactly 8 digits
				System.out.print("\t> Please enter your CPR number in the Format: 123456-1234: ");
				value = input.next();
			}
			
			while (!value.matches(pattern)) {
				System.out.print("Please enter your " + details + " in the right format");
				value = input.next();
			}
			return value;
		}

// method that prompts the user to enter the zip code within a specified range
		public static int inputZipCode() {
			Scanner input = new Scanner(System.in);
			int value;
			System.out.print("\t> Please enter your Zip code (We only deliver within the Copenhagen area): ");
			value = input.nextInt();
// zip code can only be a digit, max. 4 digits and between 1000 and 2500, because Kids With Us only delivers to Copenhagen
			while (value >= 2501 || value < 1000) {
				System.out.print("Your Zip code needs to be in the Copenhagen area (Zip Code from 1000 to 2500). Please enter a Zip Code: ");
				value = input.nextInt();
			}
			return value;
		}
// method to take input for credit card number (currently only checks for length, which has to be greater than 10
		public static String inputCreditCard() {
			Scanner input = new Scanner(System.in);
			String creditCard;
			System.out.println("\t> Please enter your Credit Card number: ");
			creditCard = input.nextLine();
			while (creditCard.length() < 10) {
				System.out.println("Please enter a valid Credit Card Number with at least 10 figures");
				creditCard = input.nextLine();
			}
			return creditCard;
		}
		
// method that prompts the admin to enter their employee id (could potentially be moved to login class)
		public static int inputEmployeeId() {
			Scanner input = new Scanner(System.in);
			int employeeId;
			System.out.println("\t> Please enter your Employee ID");
			employeeId = input.nextInt();
			while (employeeId != 5) {
				System.out.println("Please ask your boss for your Employee ID");
				employeeId = input.nextInt();
		}
		return employeeId;	
		}
			
// method that shows the user/admin that they are logged in or not logged in

		public static void outPutlogged(boolean login) {

			if (login)
				System.out.println("You are logged in ");
			else
				System.out.println("You are not logged in - you typed a wrong username or password. Please Try again!");
		}

// out(String print) method currently not used

		public static void out(String print) {
			System.out.println(print);
		}
		
// method that prompts the user to enter the details of a new product
		
		public static String inputProductDetails(String productDetails) {
			Scanner input = new Scanner(System.in);
			System.out.println("\t> Please enter the product: " + productDetails);
			
			return input.nextLine();
		}
		
// method that prompts the user to enter the price of a new product
		
		public static double inputProductPrice() {
			Scanner input = new Scanner(System.in);
			System.out.println("\t> Pleaser enter the product price as a double value");
			return input.nextDouble();
		}
		
// method that prompts the user to enter if a product is available or not
		
		public static boolean inputProductAvailability() {
			Scanner input = new Scanner(System.in);
			System.out.println("\t> Please enter the product availability as either true or false");
			return input.nextBoolean();
		}
		
// the method for main menu of the Kids With Us webshop, which is invoked in the application class
		
		public static int menuChoice1(){
			Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------");
			System.out.println("   Welcome to KidsWithUs!   ");
			System.out.println("------------------------------------------");
			System.out.println("");
			System.out.println("What would you like to do? Choose from the menu below by pressing one of the numbers.");
			System.out.println("");
			System.out.println("-----------------------");
			System.out.println("Press |1| if you are a new User or Administrator and would like to set up an account ");
			System.out.println("Press |2| if you have an account with us, and would like to login");
			System.out.println("Press |3| if you would like to to place an order ");
			System.out.println("Press |4| if you want to Leave the Store");
			System.out.println("-----------------------");
			
			int answer = input.nextInt();
		   return answer;
		   
		}
		
//method menuChoice shows the second menu in the application, after the user has stated that he already has an account and wants to sign im
		
		public static int menuChoice2(){
			Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------");
			System.out.println("   Welcome to KidsWithUs!   ");
			System.out.println("------------------------------------------");
			System.out.println("");
			System.out.println("What would you like to do? Choose from the menu below by pressing one of the numbers.");
			System.out.println("");
			System.out.println("-----------------------");
			System.out.println("Press |1| to Login as a user");
			System.out.println("Press |2| to Login as an admin");
			System.out.println("Press |3| if you want to leave the Store");
			System.out.println("-----------------------");
			
			int choice2 = input.nextInt();
		   return choice2;
		}
		
// this method asks the user to either create an admin or regular user account		
		public static int registrationChoice() {
			Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------");
			System.out.println("You have decided to create a new user");
			System.out.println("------------------------------------------");
			System.out.println("Please press 1 to create a normal user, or 2 to create a new admin account");
			System.out.println("------------------------------------------");
			int answer = input.nextInt();
			return answer;
				
			
			}

		
// CHECK use of this method!!!!		
		public static void out(Object printProducts) {
			System.out.println(printProducts);
		}
		
// This method shows the users account information (not finished yet)!!!		
		
		public static void showAccount(String user) {
			System.out.println("You can see your account info below");
			
			}
		
// This method shows the screen that prompts the user to choose if wants to pay with a credit card or per wire transfer		
			
			public static int paymentOptions( ) {
				Scanner input = new Scanner(System.in);
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("How would you like to pay? Press 1 for Credit Card and 2 for WireTransfer");
				System.out.println("------------------------------------------------------------------------------");
				int choice = input.nextInt();
				return choice;
			}
			
// This method shows the user a screen that asks if he wants to add items to his shopping cart			
		public static int menuNextChoice() {
			Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Would you like to add items to your cart? Press 1 to add items or 2 to exit the Store");
			System.out.println("------------------------------------------------------------------------------");
			int choiceNextNext = input.nextInt();
			return choiceNextNext;
		}
		
// this method prints the headline for the shopping cart		
		public static void displayShoppingCart() {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("\n  These are the products that are currently in your shopping cart: \n");		
			System.out.println("------------------------------------------------------------------------------");
			
		}
	
// this method prints a screen that asks the user to enter the ID of a product that he wants to add to their shopping cart
		
		public static int addToCart() {
			Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Please enter the ID of the product you would like to add to your shopping cart");
			System.out.println("------------------------------------------------------------------------------");
			int addChoice = input.nextInt();
			return addChoice;
			}
			
// this method prints a screen that asks the user to enter the ID of a product that he wants to remove to their shopping cart
			
			public static int removeFromCart() {
				Scanner input = new Scanner(System.in);
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Please enter the ID of the product you would like to remove from your shopping cart");
				System.out.println("------------------------------------------------------------------------------");
				int removeChoice = input.nextInt();
				return removeChoice;
			}
			
// this method shows the user a screen that asks him to enter a number that will either lead to him continue shopping or go into the shopping cart			
			
			public static int proceedFromCartToPayment() {
				Scanner input = new Scanner(System.in);
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Please press 1 if you want to continue shopping, or any other number if you want to show your Cart and proceed to payment");
				System.out.println("------------------------------------------------------------------------------");
				int proceedChoice = input.nextInt();
				return proceedChoice;
				
			}
			
// this method prints the receipt with the total price of the items in the shopping cart
// needs to be amended by shipping address etc.!!!!!
			
			public static void printReceipt() {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Thanks for buying from Kids With Us - Here is your Receipt");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("You have bought: ");
				ShoppingCart.showReceipt();
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("For a total price of:" + ShoppingCart.calculateTotalPrice());
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("We will ship to:");
				
				
			}
			
// final screen of the program, saying goodbye to the user			
			
		public static void thanksForVisit() {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Thanks for visiting Kids With Us. Hope to see you again soon!");		
			System.out.println("------------------------------------------------------------------------------");
		}
		
// needs to be moved / checked for what it is used
	public static int numberChoice() {
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;
	}
	
// this method shows the menu screen for the user once he has logged in
// note: option 3 and 4 currently do not work!!!!!!
	
	public static int userChoice() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("  Hello User   ");
		System.out.println("------------------------------------------");
		System.out.println("");
		System.out.println("What would you like to do? Choose from the menu below by pressing one of the numbers.");
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Press |1| If you want to browse all our available products ");
		System.out.println("Press |2| If you want to see all products of a specific category");
		System.out.println("Press |3| If you want to sell a product through Kids With Us");
		System.out.println("Press |4| If you want to see your account information");
		System.out.println("Press |5| If you want leave the store");
		System.out.println("-----------------------");
		
		int i = input.nextInt();
		return i;
	}
	
// this method shows the screen that prompts the user to filter the available products for Clothes or Toys
	
	public static int filterChoice() {
		Scanner input = new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("Press a number to filter the products in our Store");
		System.out.println("------------------------------------------");
		System.out.println("Press |1| If you want to see all our available Clothes ");
		System.out.println("Press |2| If you want to see all our available Toys");
		System.out.println("------------------------------------------");
		int filterChoice = input.nextInt();
		return filterChoice;
	}
	
	}
	

	

	
	
