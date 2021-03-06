package data;

import model.User;

import java.util.ArrayList;

//Same logic as for admin database, but with additional methods. Stores the login information of regular users. 


public class UserDatabase {
    public static ArrayList <User> userDatabase = new ArrayList <User>();

    //method that gets the user information from a textfile and copies it into the ArrayList that stores the user information
    public UserDatabase() {
        userDatabase = DataInputOutput.getAllUserDetails();
    }

    // allows to print a specific user (curretnly not used)
    public static String printUser(User user) {

        String details = "";


        details += user.receiptToString();

        return details;

    }

    // allows admins to print all users that are currently registered in the user database text file
    public static void printUsers() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\n  These are the users that are currently registered at Kids With Us \n");
        System.out.printf("  | %-10s | %-10s | %-10s | %-10s | %-15s | %-12s | %-10s | %-15s \n", "First Name", "Last Name", "Username", "Password", "Address", "CPR", "Phone Number", "Credit Card");
        for (User thisObject : userDatabase) { //for each object in productArrayList
            User thisUser = (User) thisObject; // changing to type Product
            System.out.printf("  | %-10s | %-10s | %-10s | %-10s | %-15s | %-12s | %-10s | %-15s \n",
                    thisUser.getFirstName(), thisUser.getLastName(), thisUser.getUsername(), thisUser.getPassword(), thisUser.getAddress(), thisUser.getCpr(), thisUser.getPhoneNumber(), thisUser.getCreditCard());

        }
        System.out.println("------------------------------------------------------------------------------");
    }

    // the addUser and removeUser allow to add/remove users from the ArrayList, but are currently not used
    public void addUser(User newUser) {
        userDatabase.add(newUser);
    }

    public void removeUser(User user) {
        userDatabase.remove(user);
    }

    // allows other methods to access the database by returning the userDatabase
    public ArrayList <User> getDatabase() {
        return userDatabase;
    }

    // this method writes the details of the individual users to the text file user2.txt
    public void writeUsertoFile(User user) {
        String details = user.getFirstName() + ";" + user.getLastName() + ";" + user.getUsername() + ";" + user.getPassword() + ";" + user.getAddress() + ";" + user.getCpr() + ";" + user.getPhoneNumber() + ";" + user.getCreditCard();
        DataInputOutput.WriteDetails("user2.txt", details);
    }
}
