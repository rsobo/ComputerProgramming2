package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) {
		File file = new File("fileio/scores.txt");
		try {
			Scanner in = new Scanner(file);
			while(in.hasNext()) {
				String firstName = in.next();
				String lastName = in.next();
				int score = in.nextInt();
				System.out.println(firstName + " " + lastName + " " + score);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}