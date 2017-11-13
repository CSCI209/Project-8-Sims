import javax.swing.*;
import java.awt.*;

public class TopCellPanel extends AbstractCellPanel{
	public TopCellPanel(Cell c) {
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
	        Icon image = cell.get(cell.size() - 1).getImage();
	        int x = (getWidth() - image.getIconWidth()) / 2;
	        image.paintIcon(this, graphics, x, y);
	      }
	}
}
