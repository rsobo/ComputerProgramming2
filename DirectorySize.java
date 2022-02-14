package recursion;

import java.io.File;

public class DirectorySize {

	public static long getSize(File file) {
		long size = 0;
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(int i = 0; files != null && i < files.length; i++) {
				size += getSize(files[i]);
			}
		}else {
			size += file.length();
		}
		return size;
	}
	
	public static void main(String[] args) {
		File file = new File("Fileio/"); //doesnt work
		System.out.println(getSize(file));
	}

}
