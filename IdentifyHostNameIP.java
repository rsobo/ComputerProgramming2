import java.net.InetAddress;
import java.net.UnknownHostException;

public class IdentifyHostNameIP {

	public static void main(String[] args) {
		try {
			InetAddress addy = InetAddress.getByName("google.com");
			System.out.println("Host Name: " + addy.getHostName());
			System.out.println("IP Address: " + addy.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
