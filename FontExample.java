package javafx;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FontExample extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		StackPane pane = new StackPane();
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(50);
		rectangle.setWidth(210);
		rectangle.setFill(Color.MAGENTA);
		
		Label label = new Label("Spare Cootchie Ma'am?");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		pane.getChildren().addAll(rectangle, label);
		
		stage.setScene(new Scene(pane, 250, 250));
		stage.setTitle("Font Example");
		stage.show();
	}

}
