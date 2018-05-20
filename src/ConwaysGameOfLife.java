import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  1. Check out the Wikipedia page on Conway's Game of Life to familiarize yourself
 *     with the concept.
 *     
 *	https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

/*
 *  2. Run the ConwaysGOL.jar to see a demo of the final product.
 */

/* 
 *  3. Create the program on your own or fill in the code under the comments to complete the project.
 *
 */

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static final int CELLS_PER_ROW = 350;
	
	private boolean isRunning = false;
	
	private JFrame window;
	private JPanel inputPanel;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JButton clearButton;
	private JLabel speedLabel;
	private JTextField speedField;
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {
		//build the window and start the simulation
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		inputPanel = new JPanel();
		gamePanel = new WorldPanel(WIDTH, HEIGHT, CELLS_PER_ROW);
		
		startStopButton = new JButton();
		startStopButton.setText("Start");
		startStopButton.addActionListener(this);
		
		speedLabel = new JLabel();
		speedLabel.setText("Delay");
		
		speedField = new JTextField(5);
		
		randomizeButton = new JButton();
		randomizeButton.setText("Randomize");
		randomizeButton.addActionListener(this);
		
		clearButton = new JButton();
		clearButton.setText("Clear");
		clearButton.addActionListener(this);
		
		setLayout(new BorderLayout());
		window.add(this);
		
		inputPanel.add(startStopButton);
		inputPanel.add(speedLabel);
		inputPanel.add(speedField);
		inputPanel.add(randomizeButton);
		inputPanel.add(clearButton);
		
		add(inputPanel, BorderLayout.NORTH);
		add(gamePanel);
		
		window.pack();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if startStopButton is pressed, 
			// toggle isRunning to the opposite of its current state
			// start or stop the animation based on the state of isRunning
		
		if (e.getSource() == startStopButton) {
			if (isRunning = true) {
				isRunning = false;
			}
			if (isRunning = false) {
				isRunning = true;
			}
			if (isRunning = true) {
				gamePanel.startAnimation();
			}
			if (isRunning = false) {
				gamePanel.stopAnimation();
			}
		}
		// if ranomizeButton is pressed
			// call randomizeCells
		if (e.getSource() == randomizeButton) {
			gamePanel.randomizeCells();
		}
		// if clearButton is pressed
			//call clearCells
		if (e.getSource() == clearButton) {
			gamePanel.clearCells();
		}
	}
	}

