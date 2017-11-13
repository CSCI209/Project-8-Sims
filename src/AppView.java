import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Container;

/**
 * @author lambertk, Shepard Sims, Andrew Baca, Trip Calihan, Peter Blair
 *
 * The main view for the game of Free Cell. 
 * 
 * It displays 16 panels in two groups of 8 panels, a bottom and a top group.
 * It also displays a button, labeled "New Game,"  at the bottom, which resets
 * the game when pressed.
 * 
 * The panels in the top correspond to the free cells and home cells, 4 each. 
 * They will display only the top card or the wire frame, if empty. The bottom
 * panels represent the 8 tableaux and will display all cards in their respective
 * stacks, or their wire frame if empty.
 * 
 * Move cards with mouse clicks from tableaux to other cells to play.
 * 
 */

public class AppView extends JFrame{
	private static Color DefaultColor = new Color(100, 150, 125);
	private ArrayList<TopCellPanel> TopCellPanels;
	private ArrayList<TableauPanel> TableauxPanels;
	private FreeCellGame model;
	private JButton button;
	
	public AppView(FreeCellGame game) {
		model = game;
		button = new JButton("New Game");
		Container c = getContentPane();
		c.setBackground(DefaultColor);
		GridBagLayout layout = new GridBagLayout();
		c.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		makeTopCellPanels(constraints, layout, c);
		makeTableauxPanels(constraints, layout, c);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
    			game.reset();
    			AppView.this.model = new FreeCellGame();
    		}
    	
    });
	}
		public void makeTopCellPanels(GridBagConstraints constraints, GridBagLayout layout, Container c) {
			TopCellPanels = new ArrayList<TopCellPanel>();
			constraints.weightx = .5;
			constraints.weighty = .5;
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			for (int i=0; i<4; i++) {
				TopCellPanels.add(new TopCellPanel(model.getFreeCell(i)));
				TopCellPanels.get(i).setBackground(DefaultColor);
				layout.setConstraints(TopCellPanels.get(i), constraints);
				constraints.gridx += 1;
				c.add(TopCellPanels.get(i));
		}
			for (int i=0; i<4; i++) {
				TopCellPanels.add(new TopCellPanel(model.getHomeCell(i)));
				TopCellPanels.get(i).setBackground(DefaultColor);
				layout.setConstraints(TopCellPanels.get(i), constraints);
				constraints.gridx += 1;
				c.add(TopCellPanels.get(i));
			}
		
		
		}
		public void makeTableauxPanels(GridBagConstraints constraints, GridBagLayout layout, Container c) {
			TableauxPanels = new ArrayList<TableauPanel>();
			constraints.weightx = .5;
			constraints.weighty = .5;
			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.gridwidth = 1;
			for (int i=0; i<8; i++) {
				TableauxPanels.add(new TableauPanel(model.getTableau(i)));
				TableauxPanels.get(i).setBackground(DefaultColor);
				layout.setConstraints(TableauxPanels.get(i), constraints);
				constraints.gridx += 1;
				c.add(TopCellPanels.get(i));
		}
}
}