package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FlowPlaneExample extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setHgap(5);
		pane.setVgap(5);
		Label firstName = new Label("First Name");
		TextField firstNameField = new TextField();
		Label lastName = new Label("Last Name");
		TextField lastNameField = new TextField();
		//pane.getChildren().addAll(firstName, firstNameField, lastName, lastNameField);
		pane.add(firstName, 0, 0);
		pane.add(firstNameField, 1, 0);
		pane.add(lastName, 0, 1);
		pane.add(lastNameField, 1, 1);
		Scene scene = new Scene(pane, 300, 300);
		stage.setScene(scene);
		stage.setTitle("Flow Pane Example");
		stage.show();
	}

}
