package javafx;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageExample extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		HBox pane = new HBox();
		pane.setPadding(new Insets(5, 5, 5, 5));
		
		String path = new File("").toURI().toURL().toExternalForm();
		String path2 = new File("C:\\posty.jpg").toURI().toURL().toExternalForm();
		
		Image image = new Image(path);
		Image image2 = new Image(path2);
		
		ImageView imageView = new ImageView(image);
		ImageView imageView2 = new ImageView(image2);
		
		pane.getChildren().add(imageView2);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Image Example");
		stage.show();
	
	}

	public static void main(String args[]) {
		Application.launch(args);
	}
}
