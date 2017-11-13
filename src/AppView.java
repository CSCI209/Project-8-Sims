import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class AppView extends javax.swing.JFrame
{
  public static final Color DefaultColor = new Color(75, 175, 100);
  private ArrayList<AbstractCellPanel> homeCellPanels;
  private ArrayList<AbstractCellPanel> freeCellPanels;
  private ArrayList<AbstractCellPanel> tableauPanels;
  private JButton button;
  private FreeCellGame game;
  
  public AppView(FreeCellGame g)
  {
    setTitle("Free Cell");
    game = g;
    Container c = getContentPane();
    GridBagLayout layout = new GridBagLayout();
    c.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    c.setBackground(DefaultColor);
    
    JButton button = new javax.swing.JButton("Press here to Start a New Game!");
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
    		button.setText("New Game");
        	game.reset();
        	repaint();
            }
    });
    gbc.fill = 0;
    gbc.gridwidth = 8;
    gbc.gridx = 0;
    gbc.gridy = 3;
    layout.setConstraints(button, gbc);
    c.add(button);
    
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    
    
    javax.swing.JLabel Label1 = new javax.swing.JLabel("Free Cells");
    Label1.setForeground(DefaultColor);
    gbc.gridwidth = 4;
    gbc.weighty = .05;
    gbc.gridx = 0;
    gbc.gridy = 0;
    Label1.setForeground(Color.black);
    Label1.setOpaque(true);
    Label1.setBackground(DefaultColor);
    layout.setConstraints(Label1, gbc);
    c.add(Label1);
    
    javax.swing.JLabel Label2 = new javax.swing.JLabel("Home Cells");
    gbc.gridwidth = 4;
    gbc.gridx = 4;
    gbc.gridy = 0;
    Label2.setOpaque(true);
    Label2.setBackground(DefaultColor);
    layout.setConstraints(Label2, gbc);
    c.add(Label2);
    
    TopCellPanels(gbc, layout, c);
    TableauPanels(gbc, layout, c);
  }
  
  private void TopCellPanels(GridBagConstraints gbc, GridBagLayout layout, Container c)
  {
    homeCellPanels = new ArrayList<AbstractCellPanel>();
    freeCellPanels = new ArrayList<AbstractCellPanel>();
    gbc.fill = 1;
    gbc.weightx = 1;
    gbc.weighty = .35;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    for (int i = 0; i < 4; i++) {
      freeCellPanels.add(new TopCellPanel(game.getFreeCell(i)));
      freeCellPanels.get(i).setBackground(DefaultColor);
      layout.setConstraints(freeCellPanels.get(i), gbc);
      gbc.gridx += 1;
      c.add(freeCellPanels.get(i));
    }
    for (int i = 0; i < 4; i++) {
    		homeCellPanels.add(new TopCellPanel(game.getFreeCell(i)));
        homeCellPanels.get(i).setBackground(DefaultColor);
        layout.setConstraints(homeCellPanels.get(i), gbc);
        gbc.gridx += 1;
        c.add(homeCellPanels.get(i));
    }
  }
  
  private void TableauPanels(GridBagConstraints gbc, GridBagLayout layout, Container c)
  {
    tableauPanels = new ArrayList<AbstractCellPanel>();
    gbc.fill = 1;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.gridx = 0;
    gbc.gridy = 2;
    for (int i = 0; i < 8; i++) {
      tableauPanels.add(new TableauPanel(game.getTableau(i)));
      tableauPanels.get(i).setBackground(DefaultColor);
      layout.setConstraints(tableauPanels.get(i), gbc);
      gbc.gridx += 1;
      c.add(tableauPanels.get(i));
    }
  }
  
}