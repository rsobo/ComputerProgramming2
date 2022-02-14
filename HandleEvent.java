package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HandleEvent extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		HBox pane = new HBox();
		pane.setAlignment(Pos.CENTER);
		
		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");
		
		Circle circ = new Circle();
		circ.setRadius(10);
		circ.setFill(Color.CORNFLOWERBLUE);
		
		//ok.setOnAction(new OkHandler());
		//cancel.setOnAction(new CancelHandler());
		
		ok.setOnAction(e -> printAction("Ok"));
		
		cancel.setOnAction(e -> {
			System.out.println(e.getSource().toString());
		});
		circ.setOnMouseClicked(e -> printAction("Circle"));
		
		pane.getChildren().addAll(circ, ok, cancel);
		
		stage.setScene(new Scene(pane, 250, 250));
		stage.setTitle("Handle Event");
		stage.show();		
	}
	
	public void printAction(String action) {
		System.out.println(action + " clicked");
	}
	
	/*class OkHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Ok Button Clicked");
		}
	}
	
	class CancelHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Cancel Button Clicked");
		}
	}*/

	public static void main(String args[]) {
		Application.launch(args);
	}
}
