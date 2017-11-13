import java.util.*;

/**
 * @author Peter Blair, Shep Sims, Andrew Baca, Trip Calihan
 * File: FreeCellGame.java
 * Defines the FreeCellGame class which sets up the game.
 * (Equivalent to FreeCellGame.)
 */
public class FreeCellGame
{
	private ArrayList<Cell> freeCells;
	private ArrayList<Cell> homeCells;
	private ArrayList<Cell> tableaux;
  
	/**
	 * Constructor method for the class, creates the different decks/piles
	 */
	public FreeCellGame() {
		freeCells = new ArrayList<Cell>();
		homeCells = new ArrayList<Cell>();
		tableaux = new ArrayList<Cell>();
		for (int i=0; i<4; i++) {
			freeCells.add(new FreeCell());
			homeCells.add(new HomeCell());
		}
		for (int i=0; i < 8; i++) {
			tableaux.add(new Tableau());
		}  
	}  
	
	/**
	 * Reset method that creates a new deck and resets the screen
	 */
	public void reset() {
		Deck deck = new Deck();
		deck.shuffle();
		for (Cell c:freeCells)
			c.clear();
		for (Cell c:homeCells)
			c.clear();
		for (Cell c:tableaux)
			c.clear();
		for (int i = 0; i<8;i++) {
			for (int i2 = 0;i2<6;i2++) {
				Card cardToDeal  = deck.deal();
				cardToDeal.turn();
				tableaux.get(i).add(cardToDeal);
			} 
		}
		for (int i = 0;i < 4; i++) {
			Card cardToDeal = deck.deal();
			cardToDeal.turn();
			tableaux.get(i).add(cardToDeal);
		}
	}
  
	/**
	 * Returns the object at index position, "i" in FreeCell
	 * @param i -- index position
	 * @return the cell at designated index position
	 */
	public Cell getFreeCell(int i) {
		return (Cell)freeCells.get(i);
	}
  
	/**
	 * Returns the object at index position, "i" in HomeCell
	 * @param i -- index position
	 * @return the cell at designated index position
	 */
	public Cell getHomeCell(int i) {
		return (Cell)homeCells.get(i);
	}
  
	/**
	 * Returns the object at index position, "i" in Tableau
	 * @param i -- index position
	 * @return the cell at designated index position
	 */
	public Cell getTableau(int i) {
		return (Cell)tableaux.get(i);
	}
  
	/**
	 * Moves a card from one cell to the other
	 * @param cell1
	 * @param cell2
	 * @return boolean true if possible, false if not
	 */
	public boolean moveCard(Cell cell1, Cell cell2) {
	  return cell2.addFrom(cell1);
	}
  
	/**
	 * Finish condition for tableaux 
	 * @return true if finish condition met, or false otherwise
	 */
	public boolean allDone() {
		for (Cell t:tableaux)
			if(!t.inOrder())
				return false;
		return true;
	}
  
	/**
	 * method for establishing whether a move is possible or not
	 * @return false if any of the following conditions are met which indicate that a move is
	 * possible, otherwise it returns true, indicating that no move is possible 
	 */
	public boolean cantMove() {
		Iterator<Cell> iter2;
		for(Iterator<Cell> iter = freeCells.iterator(); iter.hasNext(); iter2.hasNext()) {
			Cell free = (Cell)iter.next();
			if (free.isEmpty()) {
				return false;
			}
			iter2 = homeCells.iterator();
			Cell home = (Cell) iter2.next();
			if (home.canAddFrom(free)) {
				return false;
			}
		}
		for (int i = 0; i < tableaux.size();i++) {
			Cell tab = tableaux.get(i);
			
			for (Cell free : freeCells) {
				if (tab.canAddFrom(free))
					return false;
			}
			for (Cell home:homeCells) {
				if (home.canAddFrom(tab))
					return false;
			}
			for (int i2 = 0; i2 < tableaux.size();i2++) {
				if (i!= i2 && tableaux.get(i2).canAddFrom(tab))
					return false;
			}
		}
		return true;
	}
  
	/**
	 * method that creates a string representation of the current game state
	 * @return the string representation
	 */
	public String toString() {
		String returnMe = "";
		for (int i = 0; i<freeCells.size(); i++) {
			returnMe = returnMe + "\nFree Cell " + (i+1) + ":\n";
			returnMe = returnMe + freeCells.get(i).toString();
		}
		for (int i = 0; i<homeCells.size(); i++) {
			returnMe = returnMe + "\nHome Cell " + (i+1) + ":\n";
			returnMe = returnMe + homeCells.get(i).toString();
		}
		for (int i = 0; i<tableaux.size(); i++) {
			returnMe = returnMe + "\nTableaux " + (i+1) + ":\n";
			returnMe = returnMe + tableaux.get(i).toString();
		}
		return returnMe;
	}
}
