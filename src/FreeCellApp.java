import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view. 
 * (Equivalent to FreeCellApp.)
 * @author lambertk, Shepard Sims, Andrew Baca, Trip Calihan, Peter Blair
 *
 */
public class FreeCellApp{
	public FreeCellApp() {}

    public static void main(String[] args){
    		JFrame view = new AppView(new FreeCellGame());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1000, 1000);
        view.setVisible(true);
    }
}