package cinebook;
import java.util.ArrayList;

public class UserManager {
	
	private ArrayList<User>users;
	
	public UserManager() {
		users = new ArrayList<>();
	}
	
	public void addUser(User user) {
		users.add(user);
		
		System.out.println("User added successfully.");
	}
	public void displayAllUsers() {
		System.out.println();
		
		System.out.println("=================================");
		System.out.println("CINEBOOK USERS");
		System.out.println("===================================");
		 if(users.isEmpty()) {
			 System.out.println("No users avilable.");
			 return;
		 }
		 for (User user : users) {
			 System.out.println(user);}
			 System.out.println("================================");
			 System.out.println("Total Users: " + users.size());
		 }
		 
		 public int getUserCount() {
			 return users.size();
		 }
		 
		 public boolean removeUser(User user) {
			 if (users.remove(user)) {
				 System.out.println("User removed successfully.");
				 return true;
			 }
			 System.out.println("User not found.");
			 return false;
		 }
	
	

}
