package address;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class AddressServer {

	private ObjectOutputStream toFile;
	private ObjectInputStream fromClient;

	public static void main(String[] args) {
		new AddressServer();
	}

	public AddressServer() {
		new Thread(() -> {
			try {
				System.out.println("Spinning up server...");
				ServerSocket ss = new ServerSocket(9000);
				System.out.println("Server Started.");
				new Thread(() -> {
					try {
						toFile = new ObjectOutputStream(new FileOutputStream("addressbook.dat", true));
						while (true) {
							Socket s = ss.accept();
							System.out.println("Client: " + s.getInetAddress().getHostAddress() + " has connected.");
							fromClient = new ObjectInputStream(s.getInputStream());
							Address addy = (Address) fromClient.readObject();
							toFile.writeObject(addy);
							System.out.println("address name: " + addy.getName() + " was written.");
						}
					} catch (SocketException | EOFException ex) {
						System.out.println("Client has disconnected");
					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}).start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
