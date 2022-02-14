import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class PokemonDayCare extends Application {
    private TextArea textArea = new TextArea();
    private int connections = 0;

    @Override
    public void start(Stage stage) {
        constructDayCare(stage);
        constructServer();
    }

    private void constructDayCare(Stage stage) {
        stage.setScene(new Scene(new ScrollPane(textArea)));
        stage.setTitle("Pokemon Day Care");
        stage.show();
    }

    private void constructServer() {
        new Thread(()-> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> {
                    textArea.appendText(("Server started at " + new Date() + '\n'));
                });

                while(true) {
                    //Listen for new connection request
                    Socket socket = serverSocket.accept();
                    connections++;
                    Platform.runLater(() -> {
                        textArea.appendText(("New connection made with trainer. Total connections " + connections + '\n'));
                    });
                    // Spins up new thread to handle trainer
                    new Thread(() -> handleClient(socket)).start();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleClient(Socket socket) {
    	try {
    		InetAddress inetaddy = socket.getInetAddress();
    		Platform.runLater(() -> {
                textArea.appendText(("Trainer's IP is " + inetaddy.getHostAddress() + ".\n"));
            });
    		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
    		while(true) {
    			Object obj = input.readObject();
    			if(obj instanceof Pokemon) {
    				Pokemon p = (Pokemon)obj;
    				Platform.runLater(() -> {
    					String pstate = p.isCheckedIn() ? "checked in" : "checked out";
                        textArea.appendText(("Pokemon " + p.getName() + " has been " + pstate + ".\n"));
                    });
    			}else {
    				System.out.println("Not a valid Pokemon");
    			}
    		}
    	}catch(IOException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
		Application.launch(args);
	}
}
