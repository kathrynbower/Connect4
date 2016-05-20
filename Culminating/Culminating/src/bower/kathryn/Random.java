package bower.kathryn;

import java.util.ArrayList;
import java.lang.Math;

public class Random {

    public static String getItem(ArrayList<String> array) {
        int num = (int) (Math.random() * (((array.size() - 1) - 0) + 1));
        return array.get(num);
    }
    
    public static int getNumber() {
        int num = (int) (Math.random() * ((2 - 1) + 1));
        return num;
        
    }
}
