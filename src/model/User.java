package model;
import	data.DataInputOutput;
import view.UserInterface;

 // initializing the variables for User object

public class User {

	
	private String firstName;
	private String lastName;
	private String cpr;
	private String address;
	private String dateOfBirth;
	private String creditCard;
	private String username;
	private String password;
	private String phoneNumber;
	
	
	public User() {
		
	}
	
	// constructor for the user object, defines the information a user object can store
	
	public User(String firstName, String lastName, String cpr, String phoneNumber, int zipCode, String address, String dateOfBirth, String creditCard) {
		
	//This section includes the Getters and Setters for the customer constructor, and how username and password are generated
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpr = cpr;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.creditCard = creditCard;
		generateUsername();
		generatePassword();

	}

	
			public String getFirstName() {
				return firstName;
			}
			
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			
			public String getLastName() {
				return lastName;
			}
			
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
	
			public String getCpr() {
			return cpr;
			}
			
			public void setCpr(String cpr) {
				this.cpr = cpr;

			}
					
			
 			public String getPhoneNumber() {
 				return phoneNumber;
			}
 			
 			public void setPhoneNumber(String phoneNumber) {
 				this.phoneNumber = phoneNumber;
 			}
 			
			private int zipCode;
			
 			public int getZipCode() {
 				return zipCode;
 			}
 			public void setZipCode(int zipCode) {
 				this.zipCode = zipCode;
 			}
			
 			public String getAddress() {
 				return address;
 			}
 			
 			public void setAddress(String address) {
 				this.address = address;
 			}
 			
 			public String getDateOfBirth() {
 				return dateOfBirth;
 			}
 			public void setDateOfBirth(String dateOfBirth) {
 				this.dateOfBirth = dateOfBirth;
 			}
 			
 			public String getCreditCard() {
 				return creditCard;
 			}
 			
 			public void setCreditCard(String creditCard) {
 				this.creditCard = creditCard;
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
			
			
			private void generateUsername() {
				
				this.username = firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase()+ lastName.substring(1, 3).toLowerCase();	
			}

			private void generatePassword() {
				
				this.password = lastName.substring(lastName.length() -3) + cpr.substring(cpr.length() -4);
				
			}
					
			
			
			// this method takes the user input during the user registration process and shows the user the format restrictions
			public void takeInput(){
				
				
				this.firstName = UserInterface.inputDetails("First Name");
				this.lastName = UserInterface.inputDetails("Last Name");
				this.phoneNumber = UserInterface.inputDetails("Phone Number");
				this.dateOfBirth = UserInterface.inputDetails("Date of birth", "\\d{2}.\\d{2}.\\d{4}");
				this.cpr = UserInterface.inputDetails("CPR number","\\d{6}-\\d{4}");
				this.address = UserInterface.inputDetails("Address");
				this.zipCode = UserInterface.inputZipCode();
				this.creditCard = UserInterface.inputCreditCard();
				
				// here, username and password are generated from the input that has been provided by the user
				// the user registration process is complete, and the user is shown his username and password
				generateUsername();
				generatePassword();
				System.out.println("------------------------------------------");
				System.out.println("You have successfully created your account. Enjoy shopping in our store!");
				System.out.println("------------------------------------------");
				System.out.println("Your username is: " + username + " and your password is: " + password);
			}
			
			
			// toString allows to print out a string representation of the user object
			public String toString() {
				return "User [firstName= " + firstName + ", lastName=" + lastName + ",Username=" + username + ",Password=" + password + ",Address=" + address + ",CPR=" + cpr + ",PhoneNumber=" + phoneNumber + ",creditCard=" + creditCard + "]";
			}
			
			// this method writes the details of the individual users to the text file user2.txt
			public void writeUsertoFile() {
				String details = firstName + ";" + lastName + ";" + getUsername() + ";" + getPassword() + ";" + address + ";" + cpr + ";" + phoneNumber +  ";" + creditCard;
				DataInputOutput.WriteDetails("user2.txt", details);
			}
}

