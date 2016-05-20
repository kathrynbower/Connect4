package bower.kathryn;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

public class GenPanel extends JPanel {
	final int FONT_SIZE = 24;
	JButton btnPick;
	JButton btnAddList;
	
	
	int row = 6;
	int column = 1;

	Color purple = new Color(200, 128, 224);

	ArrayList<String> Shirts = new ArrayList<>();
	ArrayList<String> Pants = new ArrayList<>();
	ArrayList<String> Socks = new ArrayList<>();
	ArrayList<String> Shoes = new ArrayList<>();
	ArrayList<String> Dresses = new ArrayList<>();
	ArrayList<String> Stockings = new ArrayList<>();
	ArrayList<String> Cardigans = new ArrayList<>();

	String item;
	JTextField word1 = new JTextField(FONT_SIZE);
	JTextField word2 = new JTextField(FONT_SIZE);
	JTextField word3 = new JTextField(FONT_SIZE);
	JTextField word4 = new JTextField(FONT_SIZE);

	String dir = System.getProperty("user.dir");
	String fileName;

	Scanner in = new Scanner(System.in);

	public GenPanel() {
		setBackground(purple);
		setLayout(new GridLayout(row, column, 10, 10));
		setPreferredSize(new Dimension(500, 500));
		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));

		btnPick = new JButton("Pick Outfit");
		btnPick.addActionListener(new ButtonListener());
		btnAddList = new JButton("Select File");
		btnAddList.addActionListener(new ButtonListener());

		add(btnAddList);
		add(btnPick);
		add(word1);
		add(word2);
		add(word3);
		add(word4);
		
		word1.setVisible(false);
		word2.setVisible(false);
		word3.setVisible(false);
		word4.setVisible(false);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnPick) {
				createOutfit();
				word1.setVisible(true);
				word2.setVisible(true);
				word3.setVisible(true);
				word4.setVisible(true);
			} else if (event.getSource() == btnAddList) {
				btnPick.setVisible(false);
				
			}

		}
	}

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
	
	private void createOutfit() {
		try {
	
				int num = Random.getNumber();
				if (num == 1) {
					fileName = dir + "\\Shirts.txt";
					Shirts = ReadFiles.returnArray(fileName, Shirts);
					item = Random.getItem(Shirts);
					word1.setText(item);

					fileName = dir + "\\Pants.txt";
					Pants = ReadFiles.returnArray(fileName, Pants);
					item = Random.getItem(Pants);
					word2.setText(item);

					fileName = dir + "\\Socks.txt";
					Socks = ReadFiles.returnArray(fileName, Socks);
					item = Random.getItem(Socks);
					word3.setText(item);
				} else {
					fileName = dir + "\\Dresses.txt";
					Dresses = ReadFiles.returnArray(fileName, Dresses);
					item = Random.getItem(Dresses);
					word1.setText(item);

					fileName = dir + "\\Cardigans.txt";
					Cardigans = ReadFiles.returnArray(fileName, Cardigans);
					item = Random.getItem(Cardigans);
					word2.setText(item);

					fileName = dir + "\\Stockings.txt";
					Stockings = ReadFiles.returnArray(fileName, Stockings);
					item = Random.getItem(Stockings);
					word3.setText(item);

				}
				fileName = dir + "\\Shoes.txt";
				Shoes = ReadFiles.returnArray(fileName, Shoes);
				item = Random.getItem(Shoes);
				word4.setText(item);
			

		} catch (Exception e) {
			System.out.println("A problem has occurred");
			System.out.println(e.getMessage());
		}

	}
}
 