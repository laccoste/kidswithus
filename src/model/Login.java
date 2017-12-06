package model;

import java.util.*;

import data.*;
import view.*;

// The login class handles the user/admin login process
	public class Login {

		public Login() {

		}

// method to ask user for Login and check if he logs in right, returns boolean, so that the program  can continue
		public boolean loginUser() {
// creating two empty strings that hold the user input for password and username
			String password = "";
			String username = "";


// creating a counter that limits the number of login attempts to 3
// creating a counter that counts the number of login tries for the loop
// create a boolean that breaks the loop

			
			int numbersOfTries = 3; // The number of tries to log-in.
			int counterTries = 0; // The counter for the loop
			boolean loggedIn = false; // Sentinel value - breaks the loop

// The do-while loops handles the login attempts, ends once user is logged in

			do {
				counterTries++;
// The input of the username and password is prompted by invoking the inputDetails method from the UserInterface class
				username = UserInterface.inputDetails("username");
				password = UserInterface.inputDetails("password");

// if else statement checks if username and password are correct
// the user name is logged in, if both the username and the password are in the ArrayList userDatabase
// The method checkUserLoginCredentialsInArrayList is used to search the ArrayList for the login credentials

				if (checkUserLoginCredentialsInArrayList(username, password)) {
					// If both username and password are correct/ in the text file, the loop is exited and the program continues
					loggedIn = true;
					UserInterface.outPutlogged(loggedIn);
				} else {
					// If username and/or password are not correct/ not in the text file, the user is prompted to type them in again
					UserInterface.outPutlogged(loggedIn);

				}
// The while statement states that the loop is executed as long as the user is not logged in and has not exceeded 3 log in tries
				
			} while (counterTries < numbersOfTries && !loggedIn);
			return loggedIn;
		}
			

// This method checks if the username and password of the user are in the ArrayList for users
// First, a new ArrayList database with User objects is created
// Second, the database is overwritten the existing databse that has the user infos
// Third for every element in the Array list, the for loop checks if it includes the password and username, and returns found = true to the loginUser method

		private boolean checkUserLoginCredentialsInArrayList(String username, String password) {
			boolean found = false;
			UserDatabase database = new UserDatabase();
			ArrayList<User> details = database.getDatabase();

			for (int i = 0; i < details.size(); i++) {
				if (username.equals(details.get(i).getUsername())) {
					if (password.equals(details.get(i).getPassword())) {
						found = true;
					}
					break;
				}
			}
			return found;
		}
		
		

// The loginAdmin method follows the same logic as the loginUser method, but checks for the employeeId to authenticate the administrator
// Note that the employeeId is the same for every Admin object and hardcoded 
		
		public boolean loginAdmin() {
			
			String password = "";
			String username = "";
// initialize int employeeId, so that it can be checked against the users input
			int employeeId;
		
			int numbersOfTries = 3; // The number of tries to log-in.
			int counterTries = 0; // The counter for the loop
			boolean loggedIn = false; // Sentinel value - breaks the loop
		

			do {
				counterTries++;
				// Prompt the user for username, password and employeeId
				username = UserInterface.inputDetails("username");
				password = UserInterface.inputDetails("password");
				employeeId = UserInterface.inputEmployeeId();
				// Check the username, password and employeeId for being correct.

				if (checkAdminLoginCredentialsInArrayList(username, password, 5)) {
					
					loggedIn = true;
					UserInterface.outPutlogged(loggedIn);
				} else {
					
					UserInterface.outPutlogged(loggedIn);

				}
				
			} while (counterTries < numbersOfTries && !loggedIn);
			return loggedIn;
			
		}
		
	
		
		
// This is the same process as for a regular user, only that it also checks for the employeeId to make sure an actual employee of Kids With Us tries to log in.
		
				private boolean checkAdminLoginCredentialsInArrayList(String username, String password, int employeeId) {
					boolean found = false;
					AdminDatabase database = new AdminDatabase();
					ArrayList<Admin> details = database.getDatabase();

					for (int i = 0; i < details.size(); i++) {
						if (username.equals(details.get(i).getUsername())) {
							if (password.equals(details.get(i).getPassword())) {
								if (employeeId == 5 ){
								found = true;
							}
							break;
						}
					}
				

	}
					return found;
		}
			}