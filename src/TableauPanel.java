import javax.swing.*;
import java.awt.*;

/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: TableauPanel.java
 * 
 * Extends AbstractPanel to define a TableauPanel and its methods.
 * @param a Cell (c).
 * 
 */

public class TableauPanel extends AbstractCellPanel{
	
	/**
	 * Calls on its super, AbstractPanel, for constructor.
	 * @param a Cell (c).
	 */
	
	public TableauPanel(Cell c) {
		super(c);
	}
	
	/**
	 * A TableauPanel's only method. Overrides AbstractPanel's paintComponent method
	 * to correctly draw a TableauPanel when its cell contains cards. If a TableauPanel 
	 * is empty it will display its wire frame, if its cell contains cards it will 
	 * display all of them--each overlayed somewhat by the other, except for 
	 * the topmost card.
	 * 
	 * @param Graphics (graphics).
	 */
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		int y = 0;
	    if ((cell == null) || (cell.isEmpty())) {
	        Icon image = Card.getBack();
	        graphics.setColor(new java.awt.Color(100, 100, 0));
	        int x = (getWidth() - image.getIconWidth()) / 2;
	        graphics.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
	      }
	      else {
	    	  for (int i = 0;i<cell.size();i++) {
	    		  Icon image = cell.get(i).getImage();
	    		  int x = (getWidth() - image.getIconWidth()) / 2;
	    		  image.paintIcon(this, graphics, x, y);
	    		  y+=35;
	    	  }
	      }
	}
}
