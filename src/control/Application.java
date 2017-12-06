package control;

import model.*;
import view.*;
import data.*;

// This class includes all the methods for the Kids With Us Webshop
public class Application {

    public Application() {
    }


    // The Shopping method starts the program and runs while the boolean "shopping" is true. Once "shopping" is false, the method ends and the program ends as well
    public void Shopping() {


// initialize objects of the Type Shopping Cart, User, Admin and ProductDatabase
// Allows the program to store information in these objects and access the respective files

        ShoppingCart cart = new ShoppingCart();
        User user = new User();
        Admin admin = new Admin();
        ProductDatabase productArrayList = new ProductDatabase();


        boolean shopping = true;
        while (shopping) {

            Menu();
        }

    }

    public boolean Menu() {

//	The main menu for the Kids With Us Webshop. The user gets to see menuChoice1 once he accesses the site 
// 	The while loop for the menu is executed as long as "shopping" is true, meaning that the user can stay in the system after completing one of the steps

        int choice = UserInterface.menuChoice1();
        boolean shopping = true;
        while (shopping) {
// Switch for the menu options
            switch (choice) {

// Case 1 includes the setup process for new accounts, which can be either for regular users or administratiors (admins)

                case 1:

                    int choicenext = UserInterface.registrationChoice();
                    switch (choicenext) {

// Switch within the switch allows user to choose between setting up a regular User or administrator account
                        //!!!!! Note: The default Employee ID for admins is 5 !!!!!!

                        case 1:

// creates a regular user and writes the information into a file

                            User user = new User();
                            user.takeInput();
                            user.writeUsertoFile();
                            shopping = false;
                            break;

// creates an admin and writes the information into a file

                        case 2:
                            Admin admin = new Admin();
                            admin.takeInput();
                            admin.writeAdmintoFile();
                            shopping = false;
                            break;

                    }

// Case 2 invokes method Menu2(), which includes the menu behin the |2| Button

                case 2:
                    Menu2();
                    break;

// Case 3 allows existing users (users that are stored in the user text file) to login and immediately place an order			

                case 3:

                    Login login = new Login();
                    login.loginUser();


                    boolean continueShopping;
                    while (continueShopping = true) {

// General method flow for placing an order
// All available products in the Product Databse are printed/shown to the user
// The User is presented with a screen that allws him to choose a product and at it to his cart
// once the purchase is completed, the Product Database is updated and the sold product deleted from the text file

                        ProductDatabase.printProducts();
                        ShoppingCart.chooseProduct();
                        ProductDatabase.writeUpdatedProductListToFile();
                        continueShopping = false;
                        break;
                    }
                    UserInterface.thanksForVisit();
                    System.exit(0);

// Case 4 allows user to immediately exit the system without any other action			

                case 4:
                    UserInterface.thanksForVisit();
                    System.exit(0);

            }

        }
        return shopping;

    }

// Menu2 Method leads the user deeper into the Webshop, includes possibility to login as either user or admin

    public boolean Menu2() {

// menuChoice2 is the Interface for choosing between login options
        int choice2 = UserInterface.menuChoice2();
        Login login = new Login();
        boolean shopping = true;

        switch (choice2) {

// switch to let user login as regular user (case 1) or admin (case 2), or leave the Webshop (case 3)
            case 1:

                login.loginUser();
                boolean amendingCart;
                while (amendingCart = true) {
                    int i = UserInterface.userChoice();


                    // Switch that allows user to choose between Showing all products (case 1), showing all products of a specific category (case 2),
                    //sell a product (case 3), see their account info (case 4) or exit the system (case 5)

                    switch (i) {

                        case 1:

                            // starts the regular process for buying products (see comment line 93)

                            ProductDatabase.printProducts();
                            ShoppingCart.chooseProduct();
                            ProductDatabase.writeUpdatedProductListToFile();
                            amendingCart = false;
                            break;

                        case 2:

                            // allows to filter for Clothes or SoftToys, then buy products

                            int filterChoice = UserInterface.filterChoice();
                            if (filterChoice == 1) {
                                ProductDatabase.printClothes();
                                ShoppingCart.chooseProduct();
                                ProductDatabase.writeUpdatedProductListToFile();

                            } else {
                                ProductDatabase.printSoftToys();
                                ShoppingCart.chooseProduct();
                                ProductDatabase.writeUpdatedProductListToFile();

                            }

                        case 3:

                        case 4:

                        case 5:
                            UserInterface.thanksForVisit();
                            System.exit(0);
                    }

                }

            case 2:

                // allows the user to login as an administrator for Kids With Us
                //!!!!! Note: The default Employee ID for admins is 5 !!!!!!

                login.loginAdmin();
                boolean amending;
                while (amending = true) {

                    // Screen for the admins choices

                    int adminChoice = AdminInterface.adminChoice();


                    switch (adminChoice) {

                        case 1:

                            // Shows all products that are in the Kids With Us Product Database, and allows admin to delete individual products

                            ProductDatabase.printProducts();
                            AdminInterface.deleteProductfromDatabase();
                            amending = false;
                            break;


                        case 2:

                            // Shows a list of all regular Users that are currently registered with Kids with Us

                            UserDatabase userList = new UserDatabase();
                            UserDatabase.printUsers();
                            amending = false;
                            break;


                        case 3:

                            // Allows admin to add a product to the Database

                            Product product = new Product();
                            boolean addProduct;
                            while (addProduct = true) {
                                AdminInterface.addToDatabase();
                                product.takeProductInput();
                                product.writeProductToFile();
                                AdminInterface.continueAdding();
                                return addProduct;
                            }
                            amending = false;
                            break;

                        case 4:
                            UserInterface.thanksForVisit();
                            System.exit(1);

                    }
                }

            case 3:
                UserInterface.thanksForVisit();
                System.exit(0);
        }

        return shopping;

    }
}
