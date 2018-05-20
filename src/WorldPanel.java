import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//calculate the cellSize
	cellSize = w/cpr;
		
		//initialize the cells array
		cells = new Cell[cpr][cpr];
		
		//initialize each cell in the array
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells = new Cell[i][j];
			}
		}
	}
	
	public void randomizeCells() {
		// make each cell alive or dead randomly
		Random r = new Random();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (r.nextBoolean() == true) {
					cells[i][j].isAlive = true;
				}
				else{
					cells[i][j].isAlive = false;
				}
			}
		}
		repaint();
	}
	
	public void clearCells() {
		// set isAlive to false for all cells
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].isAlive = false;
			}
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//iterate through the cells and draw them
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].draw(g);
			}
		}
	}
	
	//advances world one step
	public void step() {
		//initialize the numLivingNbors variable to be the same size as the cells
		int[][] numLivingNbors;
		numLivingNbors = new int[cellSize][cellSize];
		//iterate through the cells and populate the numLivingNbors array with their neighbors
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				numLivingNbors[i][j] = getLivingNeighbors(i, j);
			}
		}
		
		repaint();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		
		//add 1 to livingNeighbors for each
		//neighboring cell that is alive
		
		//check that x > 0, x< length, y > 0, y < height
		if(x < cells.length ){
		if (cells[x+1][y].isAlive = true) {
			livingNeighbors += 1;
		}
		if (cells[x+1][y].isAlive = true) {
			livingNeighbors += 1;
		}
		}
		return livingNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//get the location of the mouse
		
		//toggle the cell at that location to either alive or dead
		//based on its current state
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
