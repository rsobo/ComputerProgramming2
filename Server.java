package FinalExam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

public class Server{

	static int clientCount = 0;
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				ServerSocket ss = new ServerSocket(8000);
				System.out.println("Server started at " + new Date());

				while (true) {
					// Listen for connection request
					Socket s = ss.accept(); // blocked
					clientCount++;

					InetAddress addy = s.getInetAddress();
					System.out.println("Client " + clientCount + " Connected: " + addy.getHostAddress() + ".");

					new Thread(() -> {
						try {
							DataInputStream fromClient = new DataInputStream(s.getInputStream());
							DataOutputStream toClient = new DataOutputStream(s.getOutputStream());
							while (true) {
								double side = fromClient.readDouble();
								double area = side * side;
								toClient.writeDouble(area);
								System.out.println("Received side length: " + side + ". Area is: " + area + ".");
							}
						} catch(SocketException ex) {
							System.out.println("Client disconnected");
						}catch (IOException ex) {
							ex.printStackTrace();
						}
					}).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
