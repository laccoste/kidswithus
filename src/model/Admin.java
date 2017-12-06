package model;


import data.DataInputOutput;
import view.UserInterface;
// This class holds the information for objects of the admin type
// admins have deeper access to the Kids With Us shop
// Superclasse/inheritance is not used, because admins need to provide less and different information than users for better usability

public class Admin {

// initializing variables for the Admin object	

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int employeeId = 5;


    public Admin() {

    }

    // constructor for the object of the Admin type, each admin has a first and last name and a hard coded employee Id, which is 5
    public Admin(String firstName, String lastName, int employeeId) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;

// methods that automatically generate username and password from the admins first and last name	
        generateUsername();
        generatePassword();


// getters and setters for the object of admin type, which make the information accessible for other classes
    }

    public String getfirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

// Method to generate the Username (first letter of first and last name as upper case letter, letter 2 and 3 of last name as lower case 

    private void generateUsername() {

        this.username = firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase() + lastName.substring(1, 3).toLowerCase();
    }

    //Method to generate the Password (last to letters of first and last name as lower case letter)
    private void generatePassword() {

        this.password = firstName.substring(firstName.length() - 2) + lastName.substring(lastName.length() - 2);

    }

// method that creates a news administrator by taking input from the user and generating username/password

    public void takeInput() {


        this.firstName = UserInterface.inputDetails("First Name");
        this.lastName = UserInterface.inputDetails("Last Name");


        generateUsername();
        generatePassword();
        System.out.println("------------------------------------------");
        System.out.println("You have successfully created your admin account. Enjoy working for Kids with Us!");
        System.out.println("Your username is: " + username + " and your password is: " + password);
        System.out.println("------------------------------------------");
        System.out.println("!!!! Please Note: Your employeeId will be communicated to you by your boss!!!!");

// method to override the default toString()	
    }

    public String toString() {
        return "User [firstName= " + firstName + ", lastName=" + lastName + ",Username=" + getUsername() + ",Password=" + getPassword() + ",EmployeeId=" + getEmployeeId();
    }

    // method to write the generated info for a new admin to the file admin2.txt.
// Each info string is separated by a semicolon ;
    public void writeAdmintoFile() {
        // initialize a String details and write it to file admin2.txt
        String details = firstName + ";" + lastName + ";" + getUsername() + ";" + getPassword() + ";" + getEmployeeId();
        DataInputOutput.WriteDetails("admin2.txt", details);


    }
}


