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
		FreeCellModel game = new FreeCellModel();
		game.reset();
		game.toString();
		
	}
	
}
