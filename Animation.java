package javafx;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle circle = new Circle();
		circle.setRadius(100);
		circle.setCenterX(150);
		circle.setCenterY(135);
		// circle.setFill(Color.BLACK);
		circle.setStrokeWidth(20);
		TranslateTransition translateTransition = new TranslateTransition();
		translateTransition.setDuration(Duration.millis(5000));
		translateTransition.setNode(circle);
		translateTransition.setByX(300);
		translateTransition.setCycleCount(500);
		translateTransition.setAutoReverse(false);
		translateTransition.play();
		Group root = new Group(circle);
		Scene scene = new Scene(root, 600, 300);
		stage.setTitle("Translate transition example");
		stage.setScene(scene);
		//stage.show();

		Circle circle2 = new Circle();
		circle2.setRadius(20);
		circle2.setCenterX(150);
		circle2.setCenterY(135);
		circle2.setFill(Color.BLACK);

		Path path = new Path();
		path.getElements().add(new MoveTo(0, 0));
		path.getElements().add(new CubicCurveTo(0, 0, 250, 300, 600, 0));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(5000));
		pathTransition.setNode(circle2);
		pathTransition.setPath(path);
		pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(4);
		pathTransition.setAutoReverse(false);
		pathTransition.play();
		Group root2 = new Group(circle2);
		Scene scene2 = new Scene(root2, 600, 300);
		Stage stage2 = new Stage();
		stage2.setTitle("Translate transition example");
		stage2.setScene(scene2);
		stage2.show();
		
	}

}
