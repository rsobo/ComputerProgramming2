package address;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddressClient extends Application {

	TextField tfName = new TextField();
	TextField tfStreet = new TextField();
	TextField tfCity = new TextField();
	TextField tfState = new TextField();
	TextField tfZip = new TextField();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		GridPane pane = new GridPane();
		pane.add(new Label("Name"), 0, 0);
		pane.add(tfName, 1, 0);
		pane.add(new Label("Street"), 0, 1);
		pane.add(tfStreet, 1, 1);
		pane.add(new Label("City"), 0, 2);
		pane.add(tfCity, 1, 2);
		pane.add(new Label("State"), 0, 3);
		pane.add(tfState, 1, 3);
		pane.add(new Label("Zip"), 0, 4);
		pane.add(tfZip, 1, 4);
		Button btnReg = new Button("Register to Server");
		pane.add(btnReg, 1, 5);
		stage.setScene(new Scene(pane));
		stage.setTitle("Client Address");
		stage.show();
		try {
			Socket s = new Socket("localhost", 9000);
			btnReg.setOnAction(e -> handleButtonEvent(s));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void handleButtonEvent(Socket s) {
		try {
			ObjectOutputStream toServer = new ObjectOutputStream(s.getOutputStream());
			String name = tfName.getText().trim();
			String street = tfStreet.getText().trim();
			String city = tfCity.getText().trim();
			String state = tfState.getText().trim();
			String zip = tfZip.getText().trim();
			Address addy = new Address(name, street, city, state, zip);
			toServer.writeObject(addy);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
