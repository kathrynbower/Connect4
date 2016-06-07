package bower.kathryn;

import javax.swing.*;
/**
 * 
 * @author Kathryn
 *Outfit generator program - program randomly picks an outfit for the user based on txt files scanned into arraylists
 */
public class GenDriver {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Outfit Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GenPanel());        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
