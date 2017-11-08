/**
 * File: Tester.java
 * @author Andrew Baca, Shep Sims, Peter Blair, Trip Calihan
 * 
 * The Tester class for the classes and piles needed to play
 * a game of Free Cell. 
 * 
 * The tester instantiate the piles, deal the cards to them, 
 * and test all of the methods that implement their behavior. 
 */


public class Tester {
	
	public static void main(String[] args) {
		FreeCellModel game;
		game = new FreeCellModel();
		game.reset();
		System.out.println("Test if card can be moved from top of tableau index 0 to free cell index 0, expect true\n");
		System.out.println(game.getFreeCell(0).canAddFrom(game.getTableau(0)));
		System.out.println("Show card in Tableau 0 at top, expect a Card");
		System.out.println(game.getTableau(0).get(game.getTableau(0).size()-1));
		System.out.println("Show that FreeCell 0 is empty, expect blank line");
		System.out.println(game.getFreeCell(0));
		game.moveCard(game.getTableau(0),game.getFreeCell(0));
		System.out.println("Show that FreeCell 0 now contains card previously at Tableau 0 top, expect that card");
		System.out.println(game.getFreeCell(0));
		System.out.println("Test if card can be moved from Tableau index 0 to free cell index 0, expect false, as this FreeCell is full\n");
		System.out.println(game.moveCard(game.getHomeCell(0),game.getFreeCell(0)));
		System.out.println("Test if card can be moved from HomeCell index 0 to free cell index 1, expect false, as cards cant be removed from HomeCell\n");
		System.out.println(game.moveCard(game.getHomeCell(0),game.getFreeCell(0)));
		System.out.println("Test if tableau index 0 is in order, expect false\n");
		System.out.println(game.getTableau(0).inOrder());
		System.out.println("Test if HomeCell index 0 is empty, expect true\n");
		System.out.println(game.getHomeCell(0).isEmpty());
		System.out.println("Test if Tableau index 0 is empty, expect false\n");
		System.out.println(game.getTableau(0).isEmpty());
		System.out.println("Testing if in a position without any possible moves, expect false.\n");
		System.out.println(game.cantMove());
		System.out.println("Testing for completed game, expect false.\n");
		System.out.println(game.allDone());
		System.out.println("Test game reset method, expect new game layout, free cells empty, home cells empty, Tableau cells with right number of cards\n");
		game.reset();
		System.out.println(game.toString());
		
	}
	
}
