import javax.swing.*;
import java.awt.*;

public class TableauPanel extends AbstractCellPanel{
	public TableauPanel(Cell c) {
		super(c);
	}
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
