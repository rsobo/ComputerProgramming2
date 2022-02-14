package fileio;

import java.io.IOException;
import java.util.Scanner;
import java.net.URL;

public class ReadFromURL {

	public static void main(String[] args) {
		System.out.println("Enter a Url: ");
		try(Scanner in = new Scanner(System.in)){
			String urlStr = in.next();
			URL url = new URL(urlStr);
			int count = 0;
			Scanner urlInput = new Scanner(url.openStream());
			while(urlInput.hasNext()) {
				String line = urlInput.nextLine();
				count += line.length();
				System.out.println(line);
			}
			System.out.println("The file has " + count + " characters");
			urlInput.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
