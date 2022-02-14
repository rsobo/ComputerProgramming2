package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {

	public static void main(String[] args) {
		try(FileOutputStream output = new FileOutputStream("fileio/temp.dat")){
			for(int i = 0; i <= 10; i++) {
				output.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream input = new FileInputStream("temp.dat")){
			int val = 0;
			while((val = input.read()) != -1) {
				System.out.println(val);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
