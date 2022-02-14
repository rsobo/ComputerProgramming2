import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ClientChat extends Application {

	private ObjectOutputStream toServer;
	private TextArea ta = new TextArea();
	private TextField tfMsg = new TextField();
	private Button btn = new Button("Send");
	private Button leave = new Button("Leave Chat");
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		createStage(stage);
		connect();
	}

	private void createStage(Stage stage) {
		FlowPane pane;
		Label lbl = new Label("		Username:");
		TextField tfName = new TextField();
		Label name = new Label();
		Button btn1 = new Button("Enter");
		ta.setDisable(true);
		ta.setStyle("-fx-opacity: 1;");
		tfMsg.setDisable(true);
		btn.setDisable(true);
		pane = new FlowPane(lbl, tfName, btn1, ta, tfMsg, btn, leave);
		btn1.setOnAction(e -> {
			try {
				//sends name to server
				toServer.writeObject(tfName.getText().trim());
				toServer.flush();
				toServer.reset();
				//resets text up top to the inputed name
				lbl.setText("\t\t\t\tUsername: " + tfName.getText().trim());
				//enables the chat functionality
				btn.setDisable(false);
				tfMsg.setDisable(false);
				pane.getChildren().remove(btn1);
				pane.getChildren().remove(tfName);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
		//creates and displays the pane & stage
		Scene scene = new Scene(pane, 350, 250);
		stage.setScene(scene);
		stage.setTitle("Chat Client");
		stage.show();
	}

	private void connect() {
		new Thread(() -> {
			try {
				// Create a socket to connect to the server
				Socket s = new Socket("localhost", 8001);
				// Create an output stream to send data to the server
				toServer = new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream fromServer = new ObjectInputStream(s.getInputStream());
				ta.appendText((String) fromServer.readObject() + "\n");
				while(true) {
					btn.setOnAction(e -> {
						try {
							toServer.writeObject(tfMsg.getText().trim());
							toServer.flush();
							toServer.reset();
							tfMsg.clear();
						}catch(IOException ex) {
							ex.printStackTrace();
						}
					});
					ta.appendText((String) fromServer.readObject() + "\n");
					leave.setOnAction(e -> System.exit(0));
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
