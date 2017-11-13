import javax.swing.JFrame;

/**
 * @author lambertk, Shepard Sims, Andrew Baca, Trip Calihan, Peter Blair
 * File: FreeCellApp.java
 * 
 * Main method for a GUI-based game of Free Cell
 * Instantiates a model (FreeCellGame) and passes it to a new view (AppView). 
 * 
 */
public class FreeCellApp{
	public FreeCellApp() {}

    public static void main(String[] args){
    		JFrame view = new AppView(new FreeCellGame());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1300, 1300);
        view.setVisible(true);
    }
}