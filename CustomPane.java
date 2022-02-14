package javafx;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CustomPane extends StackPane{

	public CustomPane(String text) {
		getChildren().add(new Label(text));
		setStyle("-fx-border-color: blue");
		setPadding(new Insets(5, 5, 5, 5));
	}

}
