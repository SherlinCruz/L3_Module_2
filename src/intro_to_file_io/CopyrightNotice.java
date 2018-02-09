package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

public class CopyrightNotice {
public static void main(String[] args) {
	

	
	
	
	
	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/test3.txt", true);

fw.write("\n //Copyright © 2017 by Bill Jobs");

		fw.close();
	} catch (IOException e) {
		// something went wrong
		e.printStackTrace();
		
		
		
		
	}
}
}
