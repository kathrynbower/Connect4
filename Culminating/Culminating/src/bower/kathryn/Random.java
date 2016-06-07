package bower.kathryn;

import java.util.ArrayList;
import java.lang.Math;
/**
 * 
 * @author Kathryn
 *Class generates random numbers
 */
public class Random {
	/**
	 * Method randomly picks an item from the array - randomly picks an article of clothing
	 * @param array - clothes arraylist
	 * @returns the arraylist at the index of the random number - (returns a randomly article of clothing)
	 */
	public static String getItem(ArrayList<String> array) {
		int num = (int) (Math.random() * (((array.size() - 1) - 0) + 1));
		return array.get(num);
	}
	/**
	 * Method picks randomly either the number 1 or 2 - used to choose between dress or no dress clothing combinations
	 * @returns a random number (either 1 or 2)
	 */
	public static int getNumber() {
		int num = (int) (Math.random() * ((2 - 1) + 1));
		return num;

	}
}
