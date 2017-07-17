/*
 * This class contains a frame that allows the user to enter their subjective ratings.
 * Also, this class includes an input box to retrieve the user's name
 * Author - Leon Li
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class LaptopAdvisorGUIUserRatings extends JFrame implements ActionListener{

	//Fields or objects
	private JPanel ratingsPanel = new JPanel();
	private JButton selectWeightings = new JButton("Select Weightings");
	private JLabel welcome = new JLabel("Laptop Advisor Program!");
	private JLabel welcome2 = new JLabel("By: Leon Li and Allen Lu");
	private JButton welcome3 = new JButton();
	private Laptop[] laptopArray;
	private User user;
	private String name;
	private UIManager UI = new UIManager();
	
	//font
	private Font titleFont = new Font("Calibri",Font.BOLD,46);//font for the main title
	private Font subTitleFont = new Font("Calibri",Font.BOLD,24);//font for subtitles
	private Font infoFont = new Font("Calibri",Font.BOLD,18);//font for combo boxes

	private ButtonGroup[] radioButtonGroups = new ButtonGroup [5];
	private JRadioButton[] brandButton = new JRadioButton[5];
	private JRadioButton[] OSButton = new JRadioButton[2];
	private JRadioButton[] screenSizeButton = new JRadioButton[3];
	private JRadioButton[] priceButton = new JRadioButton[2];
	private JRadioButton[] touchscreenButton = new JRadioButton[2];
	private JLabel[] labels = new JLabel[5];

	public LaptopAdvisorGUIUserRatings(Laptop[] laptopArray, User user) {

		this.laptopArray = laptopArray;
		this.user = user;

		//call methods
		frameSetup();
		panelSetup();
		labelSetup();
		createButttonGroups();
		brandButtons();
		OSButtons();
		screenSizeButtons();
		pricebuttons();
		touchscreenButtons();
		inputBoxSetup();
	}

	//this method sets up the panel with welcome objects
	private void welcomeSetup() {
		//create the welcome label
		ratingsPanel.add(welcome);
		welcome.setBounds(430, 35, 500, 50);
		welcome.setFont(titleFont);

		//create the second welcome label
		ratingsPanel.add(welcome2);
		welcome2.setBounds(540, 85, 250, 50);
		welcome2.setFont(infoFont);

		//create welcome image button
		ratingsPanel.add(welcome3);
		welcome3.setBounds(515, 140, 250, 175);
		welcome3.setIcon(new ImageIcon(new ImageIcon("./src/images/loading.jpg").getImage().getScaledInstance(250, 175, 0)));
		welcome3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA)); //add a border
	}

	//this method creates a button for the user to advance to the next frame
	private void userWeightingsButtonSetup() {
		//create select weightings button
		ratingsPanel.add(selectWeightings);
		selectWeightings.setBounds(505, 445, 250, 50);
		selectWeightings.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
		selectWeightings.setFont(subTitleFont);
		selectWeightings.setFocusPainted(false);
		selectWeightings.addActionListener(this);
	}

	//this method sets up the touch screen radio buttons
	private void touchscreenButtons() {
		//touch screen buttons
		touchscreenButton[0] = new JRadioButton("Yes");
		touchscreenButton[1] = new JRadioButton("No"); 

		for (int i = 0; i < touchscreenButton.length; i++) { 
			radioButtonGroups[4].add(touchscreenButton[i]);
			ratingsPanel.add(touchscreenButton[i]); // add to panel
			touchscreenButton[i].setFont(infoFont); //set the font
			touchscreenButton[i].setBounds(750, 560 + (i * 25), 250, 25); // set location
			touchscreenButton[i].setBackground(new Color(255, 153, 255)); //set the colour
			touchscreenButton[i].addActionListener(this); // add actionListener to each button
			touchscreenButton[i].setFocusPainted(false); // remove the focus ring
		}

	}

	//this method sets up the price radio buttons
	private void pricebuttons() {
		//price buttons
		priceButton[0] = new JRadioButton("Under $500");
		priceButton[1] = new JRadioButton("Between $500 to $1000"); 

		for (int i = 0; i < priceButton.length; i++) { 
			radioButtonGroups[3].add(priceButton[i]);
			ratingsPanel.add(priceButton[i]); // add to panel
			priceButton[i].setFont(infoFont); //set the font
			priceButton[i].setBounds(300, 560 + (i * 25), 250, 25); // set location
			priceButton[i].setBackground(new Color(255, 153, 255)); //set the colour
			priceButton[i].addActionListener(this); // add actionListener to each button
			priceButton[i].setFocusPainted(false); // remove the focus ring
		}

	}

	//this method sets up the screen size radio buttons
	private void screenSizeButtons() {
		//screen size Buttons
		screenSizeButton[0] = new JRadioButton("11.6 inches");
		screenSizeButton[1] = new JRadioButton("between 11.6 and 15.6 inches");
		screenSizeButton[2] = new JRadioButton("15.6 inches");

		for (int i = 0; i < screenSizeButton.length; i++) { 
			radioButtonGroups[2].add(screenSizeButton[i]);
			ratingsPanel.add(screenSizeButton[i]); // add to panel
			screenSizeButton[i].setFont(infoFont); //set the font
			screenSizeButton[i].setBounds(950, 370 + (i * 25), 250, 25); // set location
			screenSizeButton[i].setBackground(new Color(255, 153, 255)); //set the colour
			screenSizeButton[i].addActionListener(this); // add actionListener to each button
			screenSizeButton[i].setFocusPainted(false); // remove the focus ring
		}

	}

	//this method sets up the OS radio buttons
	private void OSButtons() {
		//OS Buttons
		OSButton[0] = new JRadioButton("Chrome OS");
		OSButton[1] = new JRadioButton("Windows 10");

		for (int i = 0; i < OSButton.length; i++) { 
			radioButtonGroups[1].add(OSButton[i]);
			ratingsPanel.add(OSButton[i]); // add to panel
			OSButton[i].setFont(infoFont); //set the font
			OSButton[i].setBounds(500, 370 + (i * 25), 125, 25); // set location
			OSButton[i].setBackground(new Color(255, 153, 255)); //set the colour
			OSButton[i].addActionListener(this); // add actionListener to each button
			OSButton[i].setFocusPainted(false); // remove the focus ring
		}

	}

	//this method sets up the brand radio buttons
	private void brandButtons() {
		//Brand Buttons
		brandButton[0] = new JRadioButton("Dell");
		brandButton[1] = new JRadioButton("Lenovo");
		brandButton[2] = new JRadioButton("Acer");
		brandButton[3] = new JRadioButton("ASUS");
		brandButton[4] = new JRadioButton("HP");

		for (int i = 0; i < brandButton.length; i++) { 
			radioButtonGroups[0].add(brandButton[i]);
			ratingsPanel.add(brandButton[i]); // add to panel
			brandButton[i].setFont(infoFont); //set the font
			brandButton[i].setBounds(50, 370 + (i * 25), 125, 25); // set location
			brandButton[i].setBackground(new Color(255, 153, 255)); //set the colour
			brandButton[i].addActionListener(this); // add actionListener to each button
			brandButton[i].setFocusPainted(false); // remove the focus ring
		}

	}

	//this method sets up the radio button groups
	private void createButttonGroups() {
		//create button groups
		for(int i =0; i < radioButtonGroups.length; i++)
			radioButtonGroups[i] = new ButtonGroup();

	}

	//this method sets up the labels on top of the radio buttons
	private void labelSetup() {

		int x = 50;
		int y = 330;

		for(int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			ratingsPanel.add(labels[i]);
			labels[i].setBounds(x, y, 500, 50);
			labels[i].setFont(subTitleFont);
			x += 450;
			if (i == 2) { //check if a new row is to be created
				x = 300;
				y = 520;
			}
		}

		//set the text for labels
		labels[0].setText("Which brand do you prefer?");
		labels[1].setText("Which OS do you prefer?");
		labels[2].setText("Which screen size do you prefer?");
		labels[3].setText("What is your budget?");
		labels[4].setText("Do you prefer touchscreen?");

	}

	//this method sets up the panel
	private void panelSetup() {

		add(ratingsPanel);
		ratingsPanel.setBounds(0, 0, 1304, 691);
		ratingsPanel.setVisible(true);
		ratingsPanel.setLayout(null);
		ratingsPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.MAGENTA)); //add a border
		ratingsPanel.setBackground(new Color(255, 153, 255));

		//call methods
		welcomeSetup();
		userWeightingsButtonSetup();
	}

	//this method creates an input box to get the user's name
	private void inputBoxSetup() {
		UI.put("OptionPane.background",new ColorUIResource(255, 153, 255));											//change the colour of the input box
		UI.put("Panel.background",new ColorUIResource(255, 153, 255));												//change the colour of the input box
		name = JOptionPane.showInputDialog(null, "Please enter your name", "User Name", JOptionPane.PLAIN_MESSAGE);	//create the input box
		user.setUserName(name);																						//set the name inputed to the userName variable in the user class
	}

	//this method sets up the frame
	private void frameSetup() {
		setTitle("Ratings");
		setSize(1310, 720);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //have program reset when exited
		setVisible(true); //make the program visible to user
		setResizable(false); //make the program a constant size
	}

	public void actionPerformed(ActionEvent event) {

		//loops through each radio button and then calls the respective rating method
		for(int selection = 0; selection < brandButton.length; selection++) {
			if(event.getSource() == brandButton[selection])
				setBrandRating(selection);
		}

		//loops through each radio button and then calls the respective rating method
		for(int selection = 0; selection < OSButton.length; selection++) {
			if(event.getSource() == OSButton[selection])
				setOSRating(selection);
		}

		//loops through each radio button and then calls the respective rating method
		for(int selection = 0; selection < screenSizeButton.length; selection++) {
			if(event.getSource() == screenSizeButton[selection])
				setScreenSizeRating(selection);
		}

		//loops through each radio button and then calls the respective rating method
		for(int selection = 0; selection < priceButton.length; selection++) {
			if(event.getSource() == priceButton[selection])
				setPriceRating(selection);
		}

		//loops through each radio button and then calls the respective rating method
		for(int selection = 0; selection < touchscreenButton.length; selection++) {
			if(event.getSource() == touchscreenButton[selection])
				setTouchscreenRating(selection);
		}

		//if the selectWeightings button is clicked then terminate the current frame and open the next frame
		if (event.getSource() == selectWeightings) {
			dispose();
			new LaptopAdvisorGUIUserWeightings(laptopArray, user );

		}
	}

	//Sets the subjective rating for the touch screen radio buttons
	private void setTouchscreenRating(int choice) {

		for (Laptop currentLaptop: laptopArray) {

			//if user chose yes, increase the rating for all touchscreen computers by 20
			if (choice == 0) {
				if (currentLaptop.isTouchscreen())
					currentLaptop.getRatings()[9] = 20;
				else
					currentLaptop.getRatings()[9] = 10;
			}
			//if user chose no, increase the rating for all computers without touchscreen by 20
			else if (choice == 1) {
				if (currentLaptop.isTouchscreen() == false)
					currentLaptop.getRatings()[9] = 20;
				else
					currentLaptop.getRatings()[9] = 0;
			}
		}
	}

	//Sets the subjective rating for the price radio buttons
	private void setPriceRating(int choice) {

		for (Laptop currentLaptop: laptopArray) {

			//if user chose under $500, increase the rating for all under $500 computers by 20
			if (choice == 0) {
				if (currentLaptop.getPrice() < 500)
					currentLaptop.getRatings()[10] = 20;
				else
					currentLaptop.getRatings()[10] = 10;
			}
			//if user chose between $500 and $1000, increase the rating for all between $500 and $1000 (inclusive) computers by 20
			else if (choice == 1) {
				if (currentLaptop.getPrice() >= 500 && currentLaptop.getPrice() <= 1000)
					currentLaptop.getRatings()[10] = 20;
				else
					currentLaptop.getRatings()[10] = 10;
			}
		}
	}

	//Sets the subjective rating for the screen size radio buttons
	private void setScreenSizeRating(int choice) {

		for (Laptop currentLaptop: laptopArray) {

			//if user chose 11.6 inches, increase the rating for all 11.6 inch computers by 20
			if (choice == 0) {
				if (currentLaptop.getScreenSize() == 11.6)
					currentLaptop.getRatings()[11] = 20;
				else if (currentLaptop.getScreenSize() > 11.6 && currentLaptop.getScreenSize() < 15.6)
					currentLaptop.getRatings()[11] = 10;
				else
					currentLaptop.getRatings()[11] = 0;

			}
			//if user chose between 11.6 and 15.6 inches, increase the rating for all computers that are between 11.6 and 15.6 inches by 20
			else if (choice == 1) {
				if (currentLaptop.getScreenSize() > 11.6 && currentLaptop.getScreenSize() < 15.6)
					currentLaptop.getRatings()[11] = 20;
				else
					currentLaptop.getRatings()[11] = 10;
			}
			//if user chose 15.6 inches, increase the rating for all 15.6 inch computers by 20
			else if (choice == 2) {
				if (currentLaptop.getScreenSize() == 15.6)
					currentLaptop.getRatings()[11] = 20;
				else if (currentLaptop.getScreenSize() > 11.6 && currentLaptop.getScreenSize() < 15.6)
					currentLaptop.getRatings()[11] = 10;
				else
					currentLaptop.getRatings()[11] = 0;
			}
		}
	}

	//Sets the subjective rating for the OS radio buttons
	private void setOSRating(int choice) {

		for (Laptop currentLaptop: laptopArray) {

			//if user chose Chrome OS, increase the rating for all Chrome OS computers by 20
			if (choice == 0) {
				if (currentLaptop.getOS().equalsIgnoreCase("Chrome OS"))
					currentLaptop.getRatings()[12] = 20;
				else
					currentLaptop.getRatings()[12] = 0;
			}
			//if user chose Windows 10, increase the rating for all Windows 10 computers by 20
			else if (choice == 1) {
				if (currentLaptop.getOS().equalsIgnoreCase("Windows 10"))
					currentLaptop.getRatings()[12] = 20;
				else
					currentLaptop.getRatings()[12] = 0;
			}
		}
	}

	//Sets the subjective rating for the brand radio buttons
	private void setBrandRating(int choice) {

		for(Laptop currentLaptop: laptopArray) {
			//if user chose dell, increase the rating for all dell computers by 10
			if (choice == 0) {
				if (currentLaptop.getBrand().equalsIgnoreCase("Dell"))
					currentLaptop.getRatings()[13] = 20;
				else
					currentLaptop.getRatings()[13] = 0;
			}
			//if user chose Lenovo, increase the rating for all Lenovo computers by 20
			else if (choice == 1) {
				System.out.printf(currentLaptop.getBrand());
				if (currentLaptop.getBrand().equalsIgnoreCase("Lenovo"))
					currentLaptop.getRatings()[13] = 20;
				else
					currentLaptop.getRatings()[13] = 0;
			}
			//if user chose acer, increase the rating for all acer computers by 20
			else if (choice == 2) {
				if (currentLaptop.getBrand().equalsIgnoreCase("Acer"))
					currentLaptop.getRatings()[13] = 20;
				else
					currentLaptop.getRatings()[13] = 0;
			}
			//if user chose Asus, increase the rating for all Asus computers by 20
			else if (choice == 3) {
				if (currentLaptop.getBrand().equalsIgnoreCase("ASUS"))
					currentLaptop.getRatings()[13] = 20;
				else
					currentLaptop.getRatings()[13] = 0;
			}
			//if user chose HP, increase the rating for all HP computers by 20
			else if (choice == 4) {
				if (currentLaptop.getBrand().equalsIgnoreCase("HP"))
					currentLaptop.getRatings()[13] = 20;
				else
					currentLaptop.getRatings()[13] = 0;
			}
		}
	}
}



