import javax.swing.*;
import java.awt.event.*; 

public class CellListener extends MouseAdapter{
	private CellPanel panel;
	
	private CellListener(CellPanel CP) {
		panel = CP;
	}
	public void clicked(MouseEvent E) {
		GUIView.panelpressed(null);
	}
}
