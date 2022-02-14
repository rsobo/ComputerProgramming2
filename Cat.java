package fileio;

import java.io.Serializable;

public class Cat implements Serializable{

	public int id = 0;
	public String name;
	
	public Cat(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
