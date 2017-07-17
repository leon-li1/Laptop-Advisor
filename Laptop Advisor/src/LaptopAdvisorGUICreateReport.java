/*
 * This class contains a frame that presents the user with the three top-ranked laptops.
 * This class provides the user with the laptop specifications and the laptop's hyperlink.
 * Author - Leon Li
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

public class LaptopAdvisorGUICreateReport extends JFrame implements ActionListener {

	//Fields and objects
	private JPanel reportPanel = new JPanel();
	private JLabel lblReport = new JLabel("Top three laptops for you!" );
	private JTextArea thanks = new JTextArea();
	private JButton exitButton = new JButton("Exit");
	private Laptop[] laptopArray;

	//font
	private Font titleFont = new Font("Calibri",Font.BOLD,46);//font for the main title
	private Font subTitleFont = new Font("Calibri",Font.BOLD,18);//font for subtitles
	private Font infoFont = new Font("Calibri",Font.BOLD,12);//font for helpPanel information

	private JButton[] hyperlinkButtons = new JButton[3];
	private JTextArea[] laptopInfo = new JTextArea[3];
	private JScrollPane[] scrollpane = new JScrollPane[3];
	private int[] scoreIndex = new int[3];
	//[0] - Laptop with the highest score
	//[1] - laptop with the second highest score
	//[2] - laptop with the third highest score

	public LaptopAdvisorGUICreateReport(Laptop[] laptopArray, User user) {

		this.laptopArray = laptopArray;
		
		//call methods
		frameSetup();
		panelSetup();
		topThreeLaptopsSetup();
		getTopthree(laptopArray, user);
		showTopthree(laptopArray);
		thankYouSetup();
	}

	//this method displays information on the top three highest ranked laptops
	private void showTopthree(Laptop[] laptopArray) {
		//sets the text area to the specifications of the three highest ranked laptops
		laptopInfo[0].setText(laptopArray[scoreIndex[0]].toString()); 
		laptopInfo[1].setText(laptopArray[scoreIndex[1]].toString());
		laptopInfo[2].setText(laptopArray[scoreIndex[2]].toString()); 

		//sets the images of the three highest ranked laptops
		hyperlinkButtons[0].setIcon(new ImageIcon(new ImageIcon("./src/images/Laptop" + scoreIndex[0] + ".jpg").getImage().getScaledInstance(250, 250, 0)));
		hyperlinkButtons[1].setIcon(new ImageIcon(new ImageIcon("./src/images/Laptop" + scoreIndex[1] + ".jpg").getImage().getScaledInstance(250, 250, 0)));
		hyperlinkButtons[2].setIcon(new ImageIcon(new ImageIcon("./src/images/Laptop" + scoreIndex[2] + ".jpg").getImage().getScaledInstance(250, 250, 0)));
	}

	private void openWebBrowser(int index) {

		//
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(laptopArray[scoreIndex[index]].getLink()));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}
	private void getTopthree(Laptop[] laptopArray, User user) {

		int score0 = 0; //keeps track of the top score in the loop
		int score1 = 0; //keeps track of the second highest score in the loop
		int score2 = 0; //keeps track of the third highest score in the loop

		for (int i = 0; i < laptopArray.length; i++) { //runs a loop for each laptop and records the index of the three highest scored laptops

			laptopArray[i].setScore(wdm(laptopArray[i], user)); //calls the wdm to rank the laptops

			if (laptopArray[i].getScore() > score0) {		 	//checks if the current laptop score is bigger than the highest score
				score2 = score1; 								//sets third highest score to current second highest
				score1 = score0; 								//sets second highest score to current highest
				score0 = laptopArray[i].getScore(); 			//changes current highest score to the new highest
				scoreIndex[2] = scoreIndex[1];					//sets the third highest laptop index to second highest
				scoreIndex[1] = scoreIndex[0];					//sets the second highest laptop index to current highest
				scoreIndex[0] = i; 								//sets current highest index to current laptop index

			} else if (laptopArray[i].getScore() > score1) {	//checks if the current laptop score is bigger than the second score
				score2 = score1; 								//sets third highest score to current second highest
				score1 = laptopArray[i].getScore(); 			//changes current second highest score to the current laptop score
				scoreIndex[2] = scoreIndex[1];					//sets the third highest laptop index to second highest
				scoreIndex[1] = i;								//sets second highest index to current laptop index

			} else if (laptopArray[i].getScore() > score2) {	//checks if the current laptop score is bigger than the third highest score
				score2 = laptopArray[i].getScore(); 			//sets third highest score score to current laptop score
				scoreIndex[2] = i; 								//sets third highest laptop index to current laptop index
			}
		}
	}

	private void topThreeLaptopsSetup() {

		//Create buttons
		for (int i = 0; i < hyperlinkButtons.length; i++) {
			hyperlinkButtons[i] = new JButton();														//create button
			reportPanel.add(hyperlinkButtons[i]); 														//add to panel
			hyperlinkButtons[i].setBounds(100 + (i * 300), 125, 250, 250); 								//position button
			hyperlinkButtons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.MAGENTA)); 	//add a border
			hyperlinkButtons[i].addActionListener(this);
		}

		//Create text areas
		for (int i = 0; i < laptopInfo.length; i++) {
			laptopInfo[i] = new JTextArea();															//create text area
			reportPanel.add(laptopInfo[i]); 															//add to panel
			laptopInfo[i].setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.MAGENTA)); 		//add a border
			laptopInfo[i].setFont(infoFont); 															//set font
			laptopInfo[i].setEditable(false); 															//make text areas non-editable
			scrollpane[i] = new JScrollPane(laptopInfo[i]);												//add a scrollpane to the text areas
			reportPanel.add(scrollpane[i]);																//add scrollpane to panel
			scrollpane[i].setBounds(100 + (i * 300), 400, 250, 250); 									//position text area
		}
	}
	private void panelSetup() {

		add(reportPanel);																		//add to frame
		reportPanel.setBounds(0, 0, 1304, 691);													//position panel 
		reportPanel.setVisible(true);															//make panel visible
		reportPanel.setLayout(null);															//allow for manual positioning
		reportPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.MAGENTA));	//add a border
		reportPanel.setBackground(new Color(255, 153, 255));									//change the background

		resultsLabelSetup();																	//call method
		exitButtonSetup();																		//call method
	}

	private void thankYouSetup() {																		//this method creates a text area
		reportPanel.add(thanks);																		//add text area to panel
		thanks.setBounds(975, 150, 300, 280);															//position text area
		thanks.setBackground(new Color(255, 153, 255));													//change the background
		thanks.setFont(titleFont);																		//set the font
		thanks.setLineWrap(true);																		//allows the text area to move to the next line
		thanks.setWrapStyleWord(true);																	//allows the text area to move to the next line
		thanks.setText("Thanks for using our program and have a nice day " + User.getUserName() + "!");	//set the text
		thanks.setEditable(false);																		//makes it non-editable
	}

	private void exitButtonSetup() {																	//this method creates an exit button
		reportPanel.add(exitButton);																	//add it to the panel
		exitButton.setBounds(1000, 555, 250, 50);														//position it
		exitButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));				//create a border
		exitButton.setFont(subTitleFont);																//set the font
		exitButton.setFocusPainted(false);																//remove the focus ring
		exitButton.addActionListener(this);																//add action listener
	}

	private void resultsLabelSetup() {				//this method creates a label
		reportPanel.add(lblReport);					//add it to the panel
		lblReport.setBounds(300, 30, 800, 75);		//position it
		lblReport.setFont(titleFont);				//set the font
	}

	private void frameSetup() {						//this method sets up the frame
		setTitle("Report");							//sets the title
		setSize(1310, 720);							//set the size
		setLocationRelativeTo(null);				//set location
		setDefaultCloseOperation(EXIT_ON_CLOSE); 	//have frame terminate when exited
		setVisible(true);							//make the frame visible to user
		setResizable(true);							//make the frame a constant size		
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == exitButton)				//if exit button is pressed, terminate the whole project
			System.exit(0);

		for (int i = 0; i < hyperlinkButtons.length; i++) { //creates a loop that checks through all buttons

			if (event.getSource() == hyperlinkButtons[i]) { //if a hyperlink button is pressed, call a method to open the web browser
				openWebBrowser(i); 
			}
		}
	}

	//this method calculates the score of a laptop by implementing the weighted-decision matrix
	private int wdm(Laptop currentlaptop, User user) {

		int totalScore = 0;

		//creates a loop that multiplies each rating by its respective weighting
		for (int index = 0; index < user.getWeightings().length; index++)
			totalScore += currentlaptop.getRatings()[index] * user.getWeightings()[index];

		return totalScore;

	}



}