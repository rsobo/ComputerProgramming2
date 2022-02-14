import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TrainerClient extends Application {
    private String[] pokemonTypes = {"Bulbasaur", "Charmander", "Squirtle", "Pikachu"};
    private ComboBox<String> comboPokemon = new ComboBox<>(FXCollections.observableArrayList(pokemonTypes));
    private TextField tfName = new TextField();
    private Button buttonSend = new Button("Send to Daycare");
    private Button buttonPickUp = new Button("Pick Up From Daycare");
    private ObjectOutputStream toServer;
    Pokemon pokemon;

    @Override
    public void start(Stage stage) {
        createStage(stage);
        connectToServer();
    }

    private void createStage(Stage stage) {
        GridPane pane = new GridPane();
        pane.add(new Label("Chose a Pokemon Type"), 0, 0);
        pane.add(comboPokemon, 1,0);
        pane.add(new Label("Pokemon's Name"), 0, 1);
        pane.add(tfName, 1, 1);
        pane.add(buttonSend, 0, 2);
        pane.add(buttonPickUp, 1, 2);

        stage.setScene(new Scene(pane));
        stage.setTitle("Trainer Client");
        stage.show();

        buttonSend.setOnAction(e -> {
        	sendToDayCare(); 
        	buttonSend.setDisable(true);
        	buttonPickUp.setDisable(false);
        });
        buttonPickUp.setOnAction(e -> {
        	pickFromDayCare();
        	buttonSend.setDisable(false);
        	buttonPickUp.setDisable(true);
        });
        buttonPickUp.setDisable(true);
    }

    private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            // Create an output stream to send data to the server
            toServer = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToDayCare() {
        try {
        	pokemon = new Pokemon(comboPokemon.getValue(), tfName.getText().trim());
            pokemon.checkIn();
            toServer.writeObject(pokemon);
            toServer.flush();
            toServer.reset();

            tfName.setDisable(true);
            comboPokemon.setDisable(true);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private void pickFromDayCare() {
        try {
            pokemon = new Pokemon(comboPokemon.getValue(), tfName.getText().trim());
            pokemon.checkOut();
            toServer.writeObject(pokemon);
            toServer.flush();
            toServer.reset();

            tfName.setDisable(false);
            comboPokemon.setDisable(false);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		Application.launch(args);
	}
}
