package view;

import java.util.*;

import data.ProductDatabase;

//This class holds the interface methods that are visible for the administrator

public class AdminInterface {

// this is the first menu after the admin logs in. He is provided with options to choose from	

    public static int adminChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("  Hello Administrator   ");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("What would you like to do? Choose from the menu below by pressing one of the numbers.");
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Press |1| If you want to see all products that are currently in the warehouse (and make changes) ");
        System.out.println("Press |2| if you want to see a list of all registered users");
        System.out.println("Press |3| if you want to add a new product to the database");
        System.out.println("Press |4| if you want to leave the System");
        System.out.println("-----------------------");

        int adminChoice = input.nextInt();
        return adminChoice;
    }

// This method shows the process of deleting a product from the product database (should be in the ProductDatabase class)

    public static boolean deleteProductfromDatabase() {

        // if there are products in the databse, the admin can delete them
        // else it is suggested to him that he should look out for new products, because he has nothing to sell

        if (ProductDatabase.productArrayList.size() > 0) {

            // initialize the int choice with the admin´s input from the removeFromDatabase() method
            int choice = removeFromDatabase();
            System.out.println("------------------------------------------------------------------------------");

            // printing out the product that has been deleted based on the input of the admin, which corresponds to the products position in the arrayList
            System.out.println("You have deleted " + " " + ProductDatabase.productArrayList.get(choice).getName() + " from the databse");
            System.out.println("------------------------------------------------------------------------------");
            ProductDatabase.buyProduct(choice);
        } else {
            System.out.println("The product Datbase is empty, you better get some new inventory!");
            System.exit(0);
        }
        // This method follows the same logic as buying a product, meaning that it deletes the product from the product database


        System.out.println("Please press 1 if you want to continue to change the database, or any other number if you want to go back to the menu");
        boolean amendDatabase;
        Scanner input = new Scanner(System.in);
        int toggle = input.nextInt();

        while (amendDatabase = true)

            if (toggle == 1) {

                amendDatabase = true;
                ProductDatabase.printProducts();
                deleteProductfromDatabase();
            } else {
                amendDatabase = false;
                break;
            }
        return false;
    }


// method that shows the admin the screen which prompts him to select an item to delete from the database. 
// the input is retuned to the deleteProductfromDatbase() method

    public static int removeFromDatabase() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Please enter the ID of the product you would like to remove from the Database");
        System.out.println("------------------------------------------------------------------------------");
        int removeChoice = input.nextInt();
        return removeChoice;
    }

    // method that shows the admin the screen before he is promted to add an item to the database
    public static void addToDatabase() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Please follow the next steps to enter a new product into the database");
        System.out.println("------------------------------------------------------------------------------");

    }

    // method that allows the admin to either continue adding products to the database, or go back to the admins menu

    public static boolean continueAdding() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Please press 1 to add another product, or any other number to go back to the menu");
        System.out.println("------------------------------------------------------------------------------");
        boolean continueAdding = true;
        int check = input.nextInt();
        if (check == 1) {
            continueAdding = true;
        } else {
            continueAdding = false;
        }
        return continueAdding;
    }
}