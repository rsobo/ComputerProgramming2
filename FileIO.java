package fileio;

import java.io.File;
import java.util.Date;

public class FileIO {
	
	public static void main(String[] args) {
		File file = new File("fileio/cats.txt");
		System.out.println("File Exist? " + file.exists());
		System.out.println("The file has: " + file.length() + " bytes");
		System.out.println("Directory: " + file.isDirectory());
		System.out.println("Abs path: " + file.getAbsolutePath());
		System.out.println("Modified last: " + new Date(file.lastModified()));
	}

}
