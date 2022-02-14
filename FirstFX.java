package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstFX extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Button btnOk = new Button("Ok");
		Scene scene = new Scene(btnOk, 200, 250);
		stage.setScene(scene);
		stage.setTitle("First JavaFX");
		stage.show();
		
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("Second Stage");
		secondaryStage.setScene(new Scene(new Button("Second"), 200, 250));
		secondaryStage.show();
		
		CustomPane cus = new CustomPane("This is a message");
		Stage stage3 = new Stage();
		stage3.setTitle("3 Stage");
		stage3.setScene(new Scene(cus, 200, 250));
		stage3.show();
	
	}

	public static void main(String args[]) {
		Application.launch(args);
	}
}
