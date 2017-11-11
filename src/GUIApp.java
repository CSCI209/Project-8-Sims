import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk
 *
 */
public class GUIApp{

    public static void main(String[] args){
    		GUIView gameGUI = new GUIView(new FreeCellModel);
        gameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameGUI.setSize(400, 400);
        gameGUI.setVisible(true);
    }
}