package fileio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String[] args) {
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream("fileio/temp.dat"))){
			output.writeUTF("John");
			output.writeDouble(85.5);
			output.writeUTF("Jim");
			output.writeDouble(90.5);
			output.writeUTF("Jane");
			output.writeDouble(92.1);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		try(DataInputStream input = new DataInputStream(new FileInputStream("fileio/temp.dat"))){
			while(true) {
				System.out.println(input.readUTF() + " " + input.readDouble());
			}
		}catch(EOFException ex) {
			System.out.println("All data was read");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}