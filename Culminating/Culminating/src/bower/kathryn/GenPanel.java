package bower.kathryn;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Main panel for outfit generator
 * 
 * @author Kathryn
 *
 */
public class GenPanel extends JPanel {

	final int FONT_SIZE = 20;
	final Color purple = new Color(200, 128, 224);

	JButton btnPick;
	JButton btnAddList;
	JButton btnDone;
	JButton btnAddShirt;
	JButton btnAddPants;
	JButton btnAddSocks;
	JButton btnAddShoes;
	JButton btnAddDresses;
	JButton btnAddStockings;

	// Lists for each type of clothing item
	ArrayList<String> Shirts = new ArrayList<>();
	ArrayList<String> Pants = new ArrayList<>();
	ArrayList<String> Socks = new ArrayList<>();
	ArrayList<String> Shoes = new ArrayList<>();
	ArrayList<String> Dresses = new ArrayList<>();
	ArrayList<String> Stockings = new ArrayList<>();
	// List to contain outfits that have received a poor rating
	ArrayList<String> Rejects = new ArrayList<>();

	JTextField word1 = new JTextField(FONT_SIZE);
	JLabel word2 = new JLabel("*Dresses and Stockings are not required");
	Font btnFont = new Font("Serif", Font.PLAIN, FONT_SIZE);
	String outfit = "";

	Scanner in = new Scanner(System.in);

	public GenPanel() {
		setBackground(purple);
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700, 700));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));

		GridBagConstraints c = new GridBagConstraints();

		// Button to select clothing files
		btnAddList = new JButton("Select File");
		btnAddList.addActionListener(new ButtonListener());
		btnAddList.setFont(btnFont);
		c.ipady = 180;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		add(btnAddList, c);

		// Button to randomly pick an outfit
		btnPick = new JButton("Pick Outfit");
		btnPick.addActionListener(new ButtonListener());
		btnPick.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(btnPick, c);

		// Textfield to display outfit
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 3;
		word1.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		add(word1, c);

		// Label to provide clarification to the user
		word2.setText("*Dresses and Stockings are not required");
		word2.setFont(new Font("Arial", Font.BOLD, 20));
		c.ipady = 20;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridwidth = 3;
		c.gridheight = 1;
		add(word2, c);

		// Button to add file containing shirts
		btnAddShirt = new JButton("Shirts");
		btnAddShirt.addActionListener(new ButtonListener());
		btnAddShirt.setFont(btnFont);
		c.ipady = 100;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(btnAddShirt, c);

		// Button to add file containing pants
		btnAddPants = new JButton("Pants");
		btnAddPants.addActionListener(new ButtonListener());
		btnAddPants.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		add(btnAddPants, c);

		// Button to add file containing socks
		btnAddSocks = new JButton("Socks");
		btnAddSocks.addActionListener(new ButtonListener());
		btnAddSocks.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		add(btnAddSocks, c);

		// Button to add file containing shoes
		btnAddShoes = new JButton("Shoes");
		btnAddShoes.addActionListener(new ButtonListener());
		btnAddShoes.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 2;
		add(btnAddShoes, c);

		// Button to add file containing dresses
		btnAddDresses = new JButton("Dresses");
		btnAddDresses.addActionListener(new ButtonListener());
		btnAddDresses.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		add(btnAddDresses, c);

		// Button to add file containing stockings
		btnAddStockings = new JButton("Stockings");
		btnAddStockings.addActionListener(new ButtonListener());
		btnAddStockings.setFont(btnFont);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		add(btnAddStockings, c);

		// Button to indicate when the user is done selecting lists
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ButtonListener());
		btnDone.setFont(btnFont);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 3;
		add(btnDone, c);

		btnPick.setEnabled(false);
		word1.setEnabled(false);
		btnDone.setVisible(false);
		btnAddShirt.setVisible(false);
		btnAddPants.setVisible(false);
		btnAddSocks.setVisible(false);
		btnAddShoes.setVisible(false);
		btnAddDresses.setVisible(false);
		btnAddStockings.setVisible(false);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnAddList) { // makes buttons for different clothing types visible to the user
				btnAddList.setVisible(false);
				btnDone.setVisible(true);
				btnPick.setVisible(false);
				btnAddShirt.setVisible(true);
				btnAddPants.setVisible(true);
				btnAddSocks.setVisible(true);
				btnAddShoes.setVisible(true);
				btnAddDresses.setVisible(true);
				btnAddStockings.setVisible(true);

			} else if (event.getSource() == btnAddShirt) { // Fills shirt array
				File fn = getFile();
				Shirts = ReadFiles.returnArray(fn, Shirts);
				btnAddShirt.setEnabled(false);
			} else if (event.getSource() == btnAddPants) { // Fills pants array
				File fn = getFile();
				Pants = ReadFiles.returnArray(fn, Pants);
				btnAddPants.setEnabled(false);
			} else if (event.getSource() == btnAddSocks) { // Fills socks array
				File fn = getFile();
				Socks = ReadFiles.returnArray(fn, Socks);
				btnAddSocks.setEnabled(false);
			} else if (event.getSource() == btnAddShoes) { // Fills shoes array
				File fn = getFile();
				Shoes = ReadFiles.returnArray(fn, Shoes);
				btnAddShoes.setEnabled(false);
			} else if (event.getSource() == btnAddDresses) { // Fills dresses array
				File fn = getFile();
				Dresses = ReadFiles.returnArray(fn, Dresses);
				btnAddDresses.setEnabled(false);
			} else if (event.getSource() == btnAddStockings) { // Fills stockings array
				File fn = getFile();
				Stockings = ReadFiles.returnArray(fn, Stockings);
				btnAddStockings.setEnabled(false);

			} else if (event.getSource() == btnDone) {
				if (Shirts.isEmpty() || Pants.isEmpty() || Socks.isEmpty() || Shoes.isEmpty()) { // Checks if minimum lists are empty
					JOptionPane.showMessageDialog(null, "Minimum lists are not full.");
				} else { // User cannot go back and pick an outfit until they are full - button not enabled/visible until lists are full
					btnAddShirt.setVisible(false);
					btnAddPants.setVisible(false);
					btnAddSocks.setVisible(false);
					btnAddShoes.setVisible(false);
					btnAddDresses.setVisible(false);
					btnAddStockings.setVisible(false);
					btnDone.setVisible(false);
					btnAddList.setVisible(true);
					btnPick.setVisible(true);
					btnPick.setEnabled(true);
					word1.setEnabled(true);
				}

			} else if (event.getSource() == btnPick) {
				if (Dresses.isEmpty() || Stockings.isEmpty()) { // If there are no dresses/stockings only shirts, pants, socks and shoes will be picked
					Outfit.setTop(Shirts);
					Outfit.setBottom(Pants);
					Outfit.setAnkles(Socks);
					Outfit.setFeet(Shoes);
					outfit = Outfit.getOutfit();
				} else {
					int num = Random.getNumber(); // If there are dresses and stockings, a random number is chosen to choose between 
					                              //dress combo and pants combo

					if (num == 1) {
						Outfit.setTop(Dresses);
						Outfit.setBottom(Stockings);
						Outfit.setFeet(Shoes);
						outfit = Outfit.getOutfit();
					} else {
						Outfit.setTop(Shirts);
						Outfit.setBottom(Pants);
						Outfit.setAnkles(Socks);
						Outfit.setFeet(Shoes);
						outfit = Outfit.getOutfit();
					}
				}

				while (checkList(Rejects, outfit)) { // Outfits will continue to be selected until one that is not in the do not show list is chosen
					Outfit.setTop(Shirts);
					Outfit.setBottom(Pants);
					Outfit.setAnkles(Socks);
					Outfit.setFeet(Shoes);
					outfit = Outfit.getOutfit();
				}

				word1.setText(outfit);
				word1.setVisible(true);
				getRating(Rejects, outfit);

			}
		}
	}

	/**
	 * Method obtains file from user's computer
	 * 
	 * @returns file object
	 */
	private File getFile() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt File", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File inFile = new File(chooser.getSelectedFile().toString());
			return inFile;
		}
		return null;
	}

	/**
	 * method checks to see if the current clothing combination is in the list
	 * of outfits not to be shown again
	 * 
	 * @param array
	 *            - array of "rejected" clothing combinations
	 * @param outfit
	 *            - current outfit that has been randomly chosen
	 * @returns whether or not the outfit is in the rejected/do not show again
	 *          list
	 */
	private boolean checkList(ArrayList<String> array, String outfit) {
		boolean match = false;
		for (String element : array) {
			if (element.equals(outfit)) {
				match = true;
			}
		}
		return match;
	}

	/**
	 * Method asks for user input - rating of 1-5 Error checking implemented If
	 * the rating is below 3 the outfit is added to the arraylist of other
	 * "rejected" outfits to not be shown again
	 * 
	 * @param array
	 *            - array of "rejected" clothing combinations
	 * @param outfit
	 *            - current outfit that has been randomly chosen
	 */
	private void getRating(ArrayList<String> array, String outfit) {
		int num = 0;
		while (num < 1 || num > 5) {
			try {
				String inputValue = JOptionPane.showInputDialog("How would you rate this outfit? (1 - 5)");
				num = Integer.valueOf(inputValue);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid input");
			}
		}
		if (num < 3) {
			array.add(outfit);
		}
	}
}
