import javax.swing.*;
import java.awt.*;

/**
 * @author Shepherd Sims, Andrew Baca, Trip Calihan, Peter Blair
 * File: AbstractCellPanel.java
 * 
 * Implements the Cell Panel class and defines responsibilities.
 * @param a cell. (All cell panels have a cell parameter.)
 * 
 */

public class AbstractCellPanel extends JPanel{
	public Cell cell;
	
	/**
	 * Constructor for AbstractCellPanel.
	 * @param a cell.
	 */
	
	public AbstractCellPanel(Cell c) {
		cell = c;
	}
	
	/**
	 * Method for paint the cell in the GUI. 
	 * All CellPanels will display the same background when their cells are empty.
	 * @param Graphics.
	 */
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		}
	
	/**
	 * Returns cell contained by cell panel.
	 * @return the cell of the panel.
	 */
	
	public Cell getCell() {
		return cell;
	}
}
