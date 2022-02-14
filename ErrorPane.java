/**
 * Course: COP 3809C.02
 * @author Ryan Sobolewski 
 * Purpose: Programming Assignment 2
 */

package panes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorPane extends VBox{

	public ErrorPane(String message) {
		setAlignment(Pos.CENTER);
		Button ok = new Button("Ok");
		getChildren().add(new Label(message));
		getChildren().add(ok);
		ok.setOnAction(e -> System.exit(0));		
	}
}