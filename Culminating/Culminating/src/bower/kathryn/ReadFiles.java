package bower.kathryn;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class ReadFiles {
	
	public static ArrayList<String> returnArray(File fn, ArrayList<String> array) {

		Scanner in;
		try {
			in = new Scanner(fn);

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
