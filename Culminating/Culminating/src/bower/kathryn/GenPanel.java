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
	JButton btnDone;
	
	JButton btnAddShirt;
	JButton btnAddPants;
	JButton btnAddSocks;
	JButton btnAddShoes;

	int row = 10;
	int column = 1;

	Color purple = new Color(200, 128, 224);

	ArrayList<String> Shirts = new ArrayList<>();
	ArrayList<String> Pants = new ArrayList<>();
	ArrayList<String> Socks = new ArrayList<>();
	ArrayList<String> Shoes = new ArrayList<>();
	//ArrayList<String> Dresses = new ArrayList<>();
	//ArrayList<String> Stockings = new ArrayList<>();
	//ArrayList<String> Sweaters = new ArrayList<>();

	JTextField word1 = new JTextField(FONT_SIZE);
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
		
		btnAddShirt = new JButton("Shirts");
		btnAddShirt.addActionListener(new ButtonListener());
		btnAddPants = new JButton("Pants");
		btnAddPants.addActionListener(new ButtonListener());
		btnAddSocks = new JButton("Socks");
		btnAddSocks.addActionListener(new ButtonListener());
		btnAddShoes = new JButton("Shoes");
		btnAddShoes.addActionListener(new ButtonListener());
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ButtonListener());

		add(btnAddList);
		add(btnPick);
		add(word1);
		
		add(btnAddShirt);
		add(btnAddPants);
		add(btnAddSocks);
		add(btnAddShoes);
		
		add(btnDone);

		word1.setVisible(false);
		btnDone.setVisible(false);
		btnAddShirt.setVisible(false);
		btnAddPants.setVisible(false);
		btnAddSocks.setVisible(false);
		btnAddShoes.setVisible(false);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnAddList) {
				btnAddList.setVisible(false);
				btnDone.setVisible(true);
				btnPick.setVisible(false);
				btnAddShirt.setVisible(true);
				btnAddPants.setVisible(true);
				btnAddSocks.setVisible(true);
				btnAddShoes.setVisible(true);
				
			} else if (event.getSource() == btnAddShirt) {
				File fn = getFile();
				fileName = fn.getName();
				Shirts = ReadFiles.returnArray(fileName, Shirts);
			} else if (event.getSource() == btnAddPants) {
				File fn = getFile();
				fileName = fn.getName();
				Pants = ReadFiles.returnArray(fileName, Pants);
			} else if (event.getSource() == btnAddSocks) {
				File fn = getFile();
				fileName = fn.getName();
				Socks = ReadFiles.returnArray(fileName, Socks);
			} else if (event.getSource() == btnAddShoes) {
				File fn = getFile();
				fileName = fn.getName();
				Shoes = ReadFiles.returnArray(fileName, Shoes);
			} else if (event.getSource() == btnDone) {
				btnAddShirt.setVisible(false);
				btnAddPants.setVisible(false);
				btnAddSocks.setVisible(false);
				btnAddShoes.setVisible(false);
				btnDone.setVisible(false);
				btnAddList.setVisible(true);
				btnPick.setVisible(true);
				
			} else if (event.getSource() == btnPick) {
				Outfit.setTop(Shirts);
				Outfit.setBottom(Pants);
				Outfit.setAnkles(Socks);
				Outfit.setFeet(Shoes);
				word1.setText(Outfit.getOutfit());
				word1.setVisible(true);
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


}
 