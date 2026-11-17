package cinebook;

public class Customer extends User {
	public Customer(int id, String name, String email) {
		// parent class constructor call.
		// Inheritance.
		super(id, name, email);
		
	}
   // methode Overriding 
	//User class main getRole() abstract.
	// customer use implement this methode.
	
	@Override
	public String getRole() {
		return "Customer";
		
	}
	// use this display object information.
	@Override
	public String toString() {
		return "Customer ID: " + getId() + " | Name: " + getName() + " | Email: " + getEmail() + " | Role: " + getRole();
		
		
		
	}

}
