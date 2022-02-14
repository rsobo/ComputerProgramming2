package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestObjectStream {

	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fileio/object.dat"))){
			oos.writeUTF("John");
			oos.writeDouble(85.5);
			oos.writeObject(new Date());
			oos.writeObject(new Cat(1, "Kitty"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fileio/object.dat"))){
			String name = ois.readUTF();
			double score = ois.readDouble();
			Date date = (Date) ois.readObject();
			Cat cat = (Cat) ois.readObject();
			System.out.println(name + " " + score + " " + date + " " + cat.name);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
