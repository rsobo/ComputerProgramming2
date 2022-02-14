package fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		File srcFile = new File("fileio/meow.txt");
		if(!srcFile.exists()) {
			System.out.println("File DNE");
			System.exit(0);
		}
		
		File tgtFile = new File("fileio/meow2.txt");
		//should put another check to make sure meow2 DNE so you dont over write an existing file
		try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(srcFile));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(tgtFile))){
			int b, numOfBytes = 0;
			while((b= input.read()) != -1) {
				output.write((byte) b);
				numOfBytes++;
			}
			System.out.println(numOfBytes + " bytes copied");
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
