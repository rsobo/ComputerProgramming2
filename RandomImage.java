package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RandomImage extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		Button random = new Button("Click me");
		hbox.getChildren().add(random);
		pane.setTop(hbox);
		Image car = new Image("/Resources/car.jpg");
		Image posty = new Image("Resources/posty.jpg");
		Image map = new Image("Resources/hvzMap.jpg");
		HBox hboxPic = new HBox();
		hboxPic.setAlignment(Pos.CENTER);
		ImageView pics = new ImageView(car);
		pics.setPreserveRatio(true);
		pics.setFitHeight(200);
		hboxPic.getChildren().add(pics);
		pane.setBottom(hboxPic);
		
		stage.setScene(new Scene(pane, 300, 300));
		stage.setTitle("Random Pictures");
		stage.show();
	}
	

}
