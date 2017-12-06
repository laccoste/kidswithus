package data;

import model.Admin;

import java.util.ArrayList;

// Stores the login information of Administrators (admins). 
// Only Administrators can change Product/Customer Information, since they have access to the databases (.txt files with data)
// Technically, they can also change the available products and user information (e.g. for a password reset) by manipulating the text files
// that are stored on the HDD


public class AdminDatabase {

    // create an empty ArrayList that is called adminDatabase and holds object of the Admin type
    private static ArrayList <Admin> adminDatabase = new ArrayList <Admin>();

    //gets the information that is stored in the admin text file and copies it into the ArrayList to make it accessible for the program
    public AdminDatabase() {
        adminDatabase = DataInputOutput.getAllAdminDetails();
    }

    // function that allows the registration process to add admin to the ArrayList
    public void addAdmin(Admin newAdmin) {
        adminDatabase.add(newAdmin);
    }

    // allows other methods to access the ArrayList in order to work with the data (e.g. for login of admin)
    public ArrayList <Admin> getDatabase() {
        return adminDatabase;
    }

}
