package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CirclePane extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Circle circle = new Circle();
		circle.setRadius(50);
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle.setStroke(Color.BLANCHEDALMOND);
		circle.setStrokeWidth(5);
		circle.setFill(Color.CORNFLOWERBLUE);
		
		pane.getChildren().add(circle);
		
		Scene scene = new Scene(pane, 250, 200);
		stage.setTitle("Circle");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String args[]) {
		Application.launch(args);
	}

}
