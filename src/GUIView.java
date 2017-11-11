import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUIView extends JFrame{
	public static Color DefaultColor = new Color(20, 200, 20);
	private ArrayList<CellPanel> FreeCellPanels;
	private ArrayList<CellPanel> HomeCellPanels;
	private ArrayList<CellPanel> TableauxPanels;
	private FreeCellModel model;
	private CellPanel clickedPanel;
	
	public AppView(FreeCellModel currentGame) {
		setBackground(DefaultColor);
		clickedPanel = null;
		model = currentGame;
		
		
	}
	
}
