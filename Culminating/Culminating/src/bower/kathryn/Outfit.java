package bower.kathryn;

import java.util.ArrayList;

/**
 * 
 * @author Kathryn Class sets the clothing items and creates the outfit
 */
public class Outfit {
	private static String top = " ";
	private static String bottom = " ";
	private static String ankles = "N/A";// default set as N/A in the case of dresses and stockings where there would be no socks
	private static String feet = " ";

	/**
	 * sets the clothing item for the top - calls random class method
	 * 
	 * @param Shirts - arraylist containing list of shirts
	 */
	public static void setTop(ArrayList<String> Shirts) {
		top = Random.getItem(Shirts);

	}

	/**
	 * sets the clothing item for the bottom - calls random class method
	 * 
	 * @param Pants - arraylist containing list of pants
	 */
	public static void setBottom(ArrayList<String> Pants) {
		bottom = Random.getItem(Pants);

	}

	/**
	 * sets the clothing item for the ankles - calls random class method
	 * 
	 * @param Socks - arraylist containing list of socks
	 */
	public static void setAnkles(ArrayList<String> Socks) {
		ankles = Random.getItem(Socks);

	}

	/**
	 * sets the clothing item for the feet - calls random class method
	 * 
	 * @param Shoes - arraylist containing list of shoes
	 */
	public static void setFeet(ArrayList<String> Shoes) {
		feet = Random.getItem(Shoes);

	}

	/**
	 * 
	 * @return the complete outfit with all 4 components
	 */
	public static String getOutfit() {
		return (top + ", " + bottom + ", " + ankles + ", " + feet);
	}
}