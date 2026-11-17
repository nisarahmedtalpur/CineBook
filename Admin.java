package cinebook;

public class Admin  extends User{
	//constructor
	public Admin(int id, String name, String email) {
		// parent class constructor
		super(id, name, email);
	}
	@Override
	public String getRole() {
		return "Admin";
	}
	@Override
	public String toString() {
		return "Admin ID: " + getId() + " | Name: " + getName() + " | Email: " + getEmail() + " | Role: " + getRole();
	}

}
