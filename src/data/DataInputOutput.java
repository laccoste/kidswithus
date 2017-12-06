package data;
import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
import model.Product;
import model.Clothes;
import model.User;
import model.SoftToys;
import model.Admin;



public class DataInputOutput {

	
	
public static Scanner readDetails( String file){
	Scanner input = new Scanner(System.in);
	
	try {
	File ReadFile = new java.io.File(file);
	
	input = new Scanner(ReadFile);
	
    // Close the file
   
	}
    catch (FileNotFoundException ex){
    	System.out.println("Error reading the file'" + file + "'");
    }
	return input;
}//readDetails

public static User getUser(String line){
	User userFromFile = new User();
	// Look for every ";" and turns the values into strings
		    String[] values = line.split(";");
		   	    	   
		// Change the String type into the correct format
		    userFromFile.setFirstName(values[0]);
		    userFromFile.setLastName(values[1]);
		    userFromFile.setUsername(values[2]);
		    userFromFile.setPassword(values[3]);
		    userFromFile.setAddress(values[4]);
		    userFromFile.setCpr(values[5]);
		    userFromFile.setPhoneNumber(values[6]);
			
     return userFromFile;
     
}

public static ArrayList<User> getAllUserDetails(){
	ArrayList<User> userList = new ArrayList<User>();
	Scanner input = readDetails("user2.txt");
	

	// checking each line 
	while (input.hasNextLine()) {
		userList.add(getUser(input.nextLine()));//passing each line to the method getCustomer which returns a customer
		} 								//then added to a ArrayList
	
	return userList;
	
}

     public static Admin getAdmin(String line) {
			Admin adminFromFile = new Admin();
			// Look for every ";" and turns the values into strings
			String[] values = line.split(";");
			// Change the String type into the correct format
			adminFromFile.setFirstName(values[0]);
			adminFromFile.setLastName(values[1]);
			adminFromFile.setUsername(values[2]);
			adminFromFile.setPassword(values[3]);
			adminFromFile.setEmployeeId(5);
			
			
			return adminFromFile;
		}
			
		// Get all admin details from a file
		public static ArrayList<Admin> getAllAdminDetails() {
			ArrayList<Admin> adminList = new ArrayList<Admin>();
			Scanner input = readDetails("admin2.txt");
			// checking each line
			while (input.hasNextLine()) {
				adminList.add(getAdmin(input.nextLine())); // passing each line to the method getAdmin, which returns an admin
				
			}															
			return adminList;
}

		
public static Product getProduct(String line){
	
	String[] values = line.split(";"); 
	if (values[2].equals("Clothes")) {
	
	int id = Integer.parseInt(values[0]);
	
	double priceDouble = Double.parseDouble(values[3]);
	boolean booleanAvailable = Boolean.parseBoolean(values[4]);
	Clothes clothesFromFile = new Clothes(id, values[1], values[2], priceDouble, booleanAvailable, values[5]);
	clothesFromFile.setName(values[1]);
	clothesFromFile.setType(values[2]);
	clothesFromFile.setColor(values[5]);		
		return clothesFromFile;
		} else   {
			
			int id = Integer.parseInt(values[0]);
			
			double priceDouble = Double.parseDouble(values[3]);
			boolean booleanAvailable = Boolean.parseBoolean(values[4]);
			SoftToys softToyFromFile = new SoftToys(id, values[1], values[2], priceDouble, booleanAvailable, values[5]);
			softToyFromFile.setName(values[1]);
			softToyFromFile.setType(values[2]);
			softToyFromFile.setAgeGroup(values[5]);
			return softToyFromFile;

		}
}
		
		public static ArrayList<Product> getAllProductDetails(){
	ArrayList<Product> productList = new ArrayList<Product>();
	Scanner input = readDetails("products2.txt");

	// checking each line 
	while (input.hasNextLine()) {
		
		productList.add(getProduct(input.nextLine()));//passing each line to the method getProduct which returns a product
			} 								//then added to a ArrayList
	
	return productList;
}





public static void WriteDetails(String file, String input){
	try{
	FileWriter fwriter = new FileWriter(file,true);
	PrintWriter output = new java.io.PrintWriter(fwriter);
	 // Write formatted output to the file
	output.println(input);
    output.close();
	}
	catch (IOException ex) {
		// if the file is not accessible, print this message
		System.out.println("Error writing to file '" + file + "'");
	}
}

	
public static void emptyFile(String file) {
				try {
					// Close the file
					new FileOutputStream(file).close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
}
}