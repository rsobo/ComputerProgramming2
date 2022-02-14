package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {

	public static void main(String[] args) {
		File file = new File("fileio/scores2.txt");
		if(file.exists()) {
			System.out.println("File Already Exists");
			System.exit(1);
		}
		try(PrintWriter output = new PrintWriter(file)){
			output.print("John Smith ");
			output.println(90);
			output.println("John Doe " + 85);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
