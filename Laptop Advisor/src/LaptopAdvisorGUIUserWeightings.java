/*
 * This class contains a frame that allows the user to enter their weightings.
 * Author - Allen Lu
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LaptopAdvisorGUIUserWeightings extends JFrame implements ActionListener{

	//Fields and objects
	private JPanel weightingsPanel = new JPanel();
	private JButton createReport = new JButton("Create my Report");
	private JButton imageButton = new JButton();
	private Laptop[] laptopArray;
	private User user;

	//font
	private Font subTitleFont = new Font("Calibri",Font.BOLD,18);//font for subtitles
	private Font infoFont = new Font("Calibri",Font.BOLD,12);//font for helpPanel information

	private JComboBox[] comboBoxes = new JComboBox[14];
	private JLabel[] labels = new JLabel[14];
	// [0] - resolution
	// [1] - gpu
	// [2] - battery
	// [3] - RAM
	// [4] - storageType
	// [5] - storageSize
	// [6] - cpu
	// [7] - opticalDrive
	// [8] - bluetooth
	// [9] - touchscreen
	// [10] - price
	// [11] - screenSize
	// [12] - os
	// [13] - brand

	public LaptopAdvisorGUIUserWeightings(Laptop[] laptopArray, User user) {

		this.laptopArray = laptopArray;
		this.user = user;

		//call methods
		frameSetup();
		panelSetup();
		labelSetup();
		comboboxSetup();
	}

	//this method sets up all the weighting combo boxes
	private void comboboxSetup() {

		int x = 50; //initial x coordinate of the combo boxes
		int y = 90; //initial y coordinate of the combo boxes

		//set up weighting combo boxes
		for (int i = 0; i < comboBoxes.length; i++) {
			comboBoxes[i] = new JComboBox(); //create combo box
			weightingsPanel.add(comboBoxes[i]); //add to panel
			comboBoxes[i].setBounds(x, y, 250, 40); //Position combo box
			comboBoxes[i].setFont(infoFont); //set font
			comboBoxes[i].addActionListener(this);

			x += 300; //creates an even amount of space between each combo box in the same row

			if (i == 3) { //check if a new row is to be created
				x = 50;
				y = 215;
			} else if (i == 7) {
				x = 50;
				y = 340;
			} else if (i == 11) {
				x = 50;
				y = 465;
			}

			for (int weight = 0; weight <= 10; weight++)
				comboBoxes[i].addItem(weight);
		}
	}

	//this method sets up the labels on top of each combo box
	private void labelSetup() {

		int x = 50; //initial x coordinate of the labels
		int y = 50; //initial y coordinate of the labels

		//set up weighting labels
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(); //create label
			weightingsPanel.add(labels[i]); //add to panel
			labels[i].setBounds(x, y, 300, 50); //position label
			labels[i].setFont(subTitleFont); //set font

			x += 300; //creates an even amount of space between each label in the same row

			if (i == 3) { //check if a new row is to be created
				x = 50;
				y = 175;
			} else if (i == 7) {
				x = 50;
				y = 300;
			} else if (i == 11) {
				x = 50;
				y = 425;
			}
		}

		//set the text for labels
		labels[0].setText("How important is the resolution?");
		labels[1].setText("How important is the graphics (GPU)?");
		labels[2].setText("How important is the battery?");
		labels[3].setText("How important is the RAM?");
		labels[4].setText("How important is the storage type?");
		labels[5].setText("How important is the storage size?");
		labels[6].setText("How important is the processor (CPU)?");
		labels[7].setText("How important is the optical drive?");
		labels[8].setText("How important is bluetooth?");
		labels[9].setText("How important is touchscreen?");
		labels[10].setText("How important is the price?");
		labels[11].setText("How important is the screen size?");
		labels[12].setText("How important is the OS?");
		labels[13].setText("How important is the brand?");

	}

	//this method creates a button to advance to the next frame
	private void createReportButtonSetup() {
		//make a create report button
		weightingsPanel.add(createReport);
		createReport.setBounds(985, 475, 275, 175);
		createReport.setFont(subTitleFont);
		createReport.setFocusPainted(false);
		createReport.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
		createReport.addActionListener(this);

	}

	//this method sets up the panel
	private void panelSetup() {
		weightingsPanel.setBounds(0, 0, 1304, 691);
		weightingsPanel.setVisible(true);
		weightingsPanel.setLayout(null);
		weightingsPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.MAGENTA)); //add a border
		weightingsPanel.setBackground(new Color(255, 153, 255));
		add(weightingsPanel);

		//Calls the method to create the create report button
		createReportButtonSetup();

		//calls method to create image button
		imageButtonSetup();
	}

	//this method sets up the image button
	private void imageButtonSetup() {
		weightingsPanel.add(imageButton);
		imageButton.setBounds(640, 465, 300, 200);
		imageButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
		imageButton.setIcon(new ImageIcon(new ImageIcon("./src/images/report.jpg").getImage().getScaledInstance(300, 200, 0)));

	}

	//this method sets up the frame
	private void frameSetup() {
		setTitle("Weightings");
		setSize(1310, 720); //set size
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //have program reset when exited
		setVisible(true); //make the program visible to user
		setResizable(false); //make the program a constant size

	}

	/*
	 * This method handles all the actions that may occur on the GUI - menus, radio buttons, combo 
	 * boxes, report button, laptop image buttons
	 */
	public void actionPerformed(ActionEvent event) {

		//loops through each combo box and then sets the weighting of the rating to whatever was selected
		for (int i = 0; i < comboBoxes.length; i++) {
			if (event.getSource() == comboBoxes[i])
				user.setWeightings(comboBoxes[i].getSelectedIndex(), i);
		}

		//if the createReport button is clicked then terminate the current frame and open the next frame
		if (event.getSource() == createReport) {
			dispose();
			new LaptopAdvisorGUICreateReport(laptopArray, user );
		}
	}
}

