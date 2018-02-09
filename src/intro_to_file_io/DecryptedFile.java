package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class DecryptedFile {
	public static void main(String[] args) {

		String decode = "";

		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);

			try {
				FileReader fr = new FileReader("src/intro_to_file_io/test3.txt");
				int c = fr.read();
				while (c != -1) {
					// turn it back to code

					System.out.println(c);

					c -= 1;

					decode += (char) c;
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		System.out.println("decoded " + decode);

	}
}
