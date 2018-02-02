package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EncryptedFile {

	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Type in a message below: ");
		String code = "";
		for (int i = 0; i < message.length(); i++) {

			char c = message.charAt(i);
			int d = (int) c;
			d += 1;
			code += (char) d;

		}
System.out.println(code);
	
	
try {
	FileWriter fw = new FileWriter("src/intro_to_file_io/test3.txt");


	fw.write(code);

	fw.close();
} catch (IOException e) {
	e.printStackTrace();
}
	
	}

}
