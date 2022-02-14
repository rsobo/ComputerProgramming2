import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;

public class ServerChat {

	static ArrayList<ObjectOutputStream> oos = new ArrayList<ObjectOutputStream>();

	public static void main(String[] args) {
		runServer();
	}

	private static void runServer() {
		new Thread(() -> {
			try {
				// Create a server socket
				ServerSocket ss = new ServerSocket(8001);
				System.out.println("Server started at " + new Date());
				while (true) {
					// Listen for new connection request
					Socket s = ss.accept();
					InetAddress inetaddy = s.getInetAddress();
					System.out.println("Connection from IP address " + inetaddy.getHostAddress() + " at " + new Date());
					// Spins up new thread to handle clients
					Thread t = new Thread(() -> clientHandler(s));
					t.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private static void clientHandler(Socket s) {
		String name = "";
		try {
			// gets input and output streams
			ObjectInputStream fromClient = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream toClient = new ObjectOutputStream(s.getOutputStream());
			oos.add(toClient);
			s.setTcpNoDelay(true);
			// gets name from client, prints to console, and then sends it to other clients
			name = (String) fromClient.readObject();
			System.out.println(name + " has connected");
			sendMessages(name + " has connected");
			while (true) {
				// gets messages from clients and sends them to the other clients
				String msg = (String) fromClient.readObject();
				System.out.println(name + ": " + msg);
				sendMessages(name + ": " + msg);
			}
		} catch (SocketException exe) {
			System.out.println(name + " has disconnected");
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void sendMessages(String msg) {
		oos.forEach(o -> {
			try {
				o.reset();
				o.writeObject(msg);
				o.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
	}

}

