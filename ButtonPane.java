package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonPane extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("OKKKKKK"));
		pane.setRotate(45);
		pane.setStyle("-fx-border-color: black");
		
		Scene scene = new Scene(pane, 200, 250);
		stage.setTitle("Button in Pane");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String args[]) {
		Application.launch(args);
	}
}
