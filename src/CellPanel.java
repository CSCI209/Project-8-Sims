import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel{
	protected Cell cell;
	
	public CellPanel(Cell c) {
		cell = c;
		addMouseListener(new CellListener(cell));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Icon image;
		if (cell.isEmpty() == false) {
	    		image = cell.get(cell.size()-1).getImage();
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		int y = (getHeight() - image.getIconHeight()) / 2;
	    		image.paintIcon(this, g, x, y);
		}
	}
	public Cell getCell() {
		return cell;
	}
	
	
}
