package FinalExam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Client extends Application{

	DataInputStream fromServer;
	DataOutputStream toServer;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		HBox hbox = new HBox();
		TextField tf = new TextField();
		hbox.getChildren().addAll(new Label("Enter Side"), tf);
		pane.setTop(hbox);
		TextArea textarea = new TextArea();
		pane.setCenter(new ScrollPane(textarea));
		stage.setScene(new Scene(pane, 450, 200));
		stage.setTitle("Client");
		stage.show();
		
		//connect to server
		try {
			Socket s = new Socket("localhost", 8000);
			fromServer = new DataInputStream(s.getInputStream());
			toServer = new DataOutputStream(s.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
		tf.setOnAction(e -> {
			try {
				double side = Double.parseDouble(tf.getText().trim());
				toServer.writeDouble(side);
				toServer.flush();
				double area = fromServer.readDouble();
				textarea.appendText("Area received from the server for side " + side + " is " + area);
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		});
	}

}

