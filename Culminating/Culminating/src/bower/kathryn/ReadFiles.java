package bower.kathryn;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class ReadFiles {
	
	public static ArrayList<String> returnArray(String fileName, ArrayList<String> array) {

		File inFile = new File(fileName);

		Scanner in;
		try {
			in = new Scanner(inFile);

			while (in.hasNext()) {
				String word = in.nextLine();
				array.add(word);
			}
		} catch (Exception e) {
			System.out.println("A problem has occurred");
			System.out.println(e.getMessage());
		}
		return array;
	}
}
