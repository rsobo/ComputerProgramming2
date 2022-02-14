package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWords {
	
	public static int CountWordsFunction(String filename){
		File file = new File(filename);
		try(Scanner sc = new Scanner(new FileInputStream(file))){
		    int count=0;
		    while(sc.hasNext()){
		        sc.next();
		        count++;
		    }
		    return count;	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
			
	}
	// Main provided for testing
	public static void main(String args[]) {
		System.out.println(CountWordsFunction("fileio/meow.txt"));
	}

}
