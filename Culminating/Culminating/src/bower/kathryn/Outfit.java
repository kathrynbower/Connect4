package bower.kathryn;

import java.util.ArrayList;

public class Outfit {
	private static String top = " ";
	private static String bottom = " ";
	private static String ankles = "N/A";
	private static String feet = " ";

	public static void setTop(ArrayList<String> Shirts) {
		top = Random.getItem(Shirts);

	}

	public static void setBottom(ArrayList<String> Pants) {
		bottom = Random.getItem(Pants);

	}

	public static void setAnkles(ArrayList<String> Socks) {
		ankles = Random.getItem(Socks);

	}

	public static void setFeet(ArrayList<String> Shoes) {
		feet = Random.getItem(Shoes);

	}

	public static String getOutfit() {
		return (top + ", " + bottom + ", " + ankles + ", " + feet);
	}
}
