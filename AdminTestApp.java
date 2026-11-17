package cinebook;

public class AdminTestApp extends Application  {
	
	@Override public void start(Stage stage) {
		new AdminPanel().showAdminDashboard();
	
	
	}
	
	public static void main(String [] args) {
		launch(args);
	}

}
