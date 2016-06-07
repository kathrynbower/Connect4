package bower.kathryn;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
/**
 * 
 * @author Kathryn
 *Class created to scan txt files and add the text to an array
 */
public class ReadFiles {
	/**
	 * reads the file, adds each line to the array then returns the filled arraylist
	 * @param fn - file object created in Panel
	 * @param array - arraylist - will be passed a particular clothing arraylist
	 * @return array with text read from file
	 */
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
