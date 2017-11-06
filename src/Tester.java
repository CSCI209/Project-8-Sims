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
		game.toString();
		System.out.println("Test if card can be moved from top of tableau index 0 to free cell index 0, expect true");
		System.out.println(game.moveCard(game.getTableau(0),game.getFreeCell(0)));
		System.out.println("Test if card can be moved from free cell index 0 to free cell index 1, expect true");
		System.out.println(game.moveCard(game.getFreeCell(0),game.getFreeCell(0)));
		System.out.println("Test if card can be moved from home cell index 0 to free cell index 0, expect false");
		System.out.println(game.moveCard(game.getHomeCell(0),game.getFreeCell(0)));
		System.out.println("Test if tableau index 0 is in order, expect false");
		System.out.println(game.getTableau(0).inOrder());
		System.out.println("Test if HomeCell index 0 is empty, expect true");
		System.out.println(game.getHomeCell(0).isEmpty());
		System.out.println("Test if Tableua index 0 is empty, expect false");
		System.out.println(game.getTableau(0).isEmpty());
		System.out.println("Testing if in a position without any possible moves, expect false.");
		System.out.println(game.cantMove());
		System.out.println("Testing for completed game, expect false.");
		System.out.println(game.allDone());
		System.out.println("Test game reset method, expect new game layout");
		game.reset();
		System.out.println(game.toString());
		
	}
	
}
