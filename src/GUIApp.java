import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view. 
 * (Equivalent to FreeCellApp.)
 * @author lambertk, Shepard Sims, Andrew Baca, Trip Calihan, Peter Blair
 *
 */
public class GUIApp{

    public static void main(String[] args){
    		final FreeCellModel game = new FreeCellModel();
    		final JFrame view = new GUIView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1000, 1000);
        view.setVisible(true);
    }
}