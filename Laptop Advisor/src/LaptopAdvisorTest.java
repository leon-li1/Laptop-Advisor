/*
 * Name(s): Leon Li and Allen Lu
 * Date: April 28, 2017
 * Course code: ICS3U1-01
 * Purpose: To create an application that helps a user pick a laptop(s) suiting their needs based on input given.
 * Major skills: File Input, GUI, Arrays, Weighted Decision Matrix, loops, decision structures
 * Extra features: Loading screen, input box, scroll bar, image icons and different style fonts + borders.
 * Areas of concern: None but, if I had more time, we would like to create a menu bar and enhance the GUI (add moving objects).
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.Timer;

public class LaptopAdvisorTest extends JWindow {

	public static Laptop[] laptop = new Laptop[20];
	public static User user = new User();

	private static JProgressBar loadingScreenProgressBar; //creates the progress bar
	private static int count = 1; //current time
	private static int timerPause = 30;//increment speed
	private static int max = 150;//when exits progress bar
	private static Timer progressBarTimer;//timer

	public LaptopAdvisorTest() {

		JPanel panel = new JPanel();//creates a new panel
		panel.setLayout(new BorderLayout());//sets the layout
		JLabel splashImage = new JLabel(new ImageIcon("./src/images/loading.jpg"));//gets splash screen image from folder
		panel.add(splashImage);//adds image to panel

		loadingScreenProgressBar = new JProgressBar();//creates progress bar
		loadingScreenProgressBar.setMaximum(max);
		loadingScreenProgressBar.setForeground(new Color(50, 150, 200));//sets colour
		loadingScreenProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(loadingScreenProgressBar, BorderLayout.SOUTH);

		setContentPane(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		startProgressBar();//starts progress bar method
	}

	private void startProgressBar() {

		//this method runs the progress bar and at the end starts laptopAdvisorGUI
		progressBarTimer = new Timer(timerPause, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				loadingScreenProgressBar.setValue(count);

				if (count == max) {
					LaptopAdvisorTest.this.dispose();
					progressBarTimer.stop();
					new LaptopAdvisorGUIUserRatings(laptop, user);
				}

				count++;
			}

		});

		progressBarTimer.start();
	}


	public static void main(String[] args) {

		//this calls file input method and runs the program
		new LaptopAdvisorFileInput(laptop);
		new LaptopAdvisorTest();

	}
}




