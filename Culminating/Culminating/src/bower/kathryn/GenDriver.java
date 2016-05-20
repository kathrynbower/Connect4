package bower.kathryn;

import javax.swing.*;

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
