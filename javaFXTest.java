package cinebook;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class javaFXTest extends Application{
	
	@Override
	public void start(Stage stage) {
		Label label = new Label("CineBook JavaFX is Working!");
		
		Scene scene = new Scene(label,500,300);
		
		stage.setTitle("CineBook");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String [] args) {
		launch(args);
	}
	
}
