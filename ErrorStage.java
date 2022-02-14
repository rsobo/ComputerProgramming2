package copy;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorStage extends Stage{

	public ErrorStage(String str) {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		Label lbl = new Label(str);
		Button btn = new Button("Ok");
		btn.setOnAction(e -> this.hide());
		vbox.getChildren().addAll(lbl, btn);
		setTitle("Error");
		setScene(new Scene(vbox, 300, 150));
		show();
	}
}
