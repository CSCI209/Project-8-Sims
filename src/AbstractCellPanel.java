import javax.swing.*;
import java.awt.*;

public class AbstractCellPanel extends JPanel{
	public Cell cell;
	
	public AbstractCellPanel(Cell c) {
		cell = c;
//		addMouseListener(new CellListener(new AbstractCellPanel()));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		}
	
	public Cell getCell() {
		return cell;
	}
}
