import javax.swing.*;
import java.awt.*;

/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: TopCellPanel.java
 * 
 * Extends AbstractPanel to define a TopCellPanel and its methods.
 * @param a Cell (c).
 * 
 */

public class TopCellPanel extends AbstractCellPanel{
	
	/**
	 * Calls on its super, AbstractPanel, for constructor.
	 * @param a Cell (c).
	 */
	
	public TopCellPanel(Cell c) {
		super(c);
	}
	
	/**
	 * A TopCellPanel's only method. Overrides AbstractPanel's paintComponent method
	 * to correctly draw a TopCellPanel when its cell contains cards. If a TopCellPanel 
	 * is empty it will display its wire frame, if its cell contains cards it will 
	 * display only the topmost card.
	 * 
	 * @param Graphics (graphics).
	 */
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		int y = 0;
	    if ((cell == null) || (cell.isEmpty())) {
	        Icon image = Card.getBack();
	        graphics.setColor(new java.awt.Color(255, 255, 0));
	        int x = (getWidth() - image.getIconWidth()) / 2;
	        graphics.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
	      }
	      else {
	        Icon image = cell.get(cell.size() - 1).getImage();
	        int x = (getWidth() - image.getIconWidth()) / 2;
	        image.paintIcon(this, graphics, x, y);
	      }
	}
}
