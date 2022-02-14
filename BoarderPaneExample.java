package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoarderPaneExample extends Application{

	public HBox getHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(5, 5, 5, 5));
		Image posty = new Image("/Resources/posty.jpg");
		ImageView imageview = new ImageView(posty);
		hbox.getChildren().add(imageview);
		return hbox;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		pane.setTop(getHBox());
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Flow Pane Example");
		stage.show();
	}

}
