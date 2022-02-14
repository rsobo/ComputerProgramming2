import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {
	String text = "";

	@Override
	public void start(Stage stage) throws Exception {
		StackPane pane = new StackPane();
		Label lbl = new Label("Dogs are awesome");
		pane.getChildren().add(lbl);

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						if (lbl.getText().length() == 0) {
							text = "Dogs are awesome";
						} else {
							text = "";
						}
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								lbl.setText(text);
							}

						});
						Thread.sleep(200);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		stage.setTitle("Flashing Text");
		stage.setScene(new Scene(pane, 200, 50));
		stage.show();
	}

	public static void main(String args[]) {
		Application.launch(args);
	}

}
