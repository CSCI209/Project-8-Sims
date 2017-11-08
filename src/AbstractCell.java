import java.util.*;

/**
 * @author Shepherd Sims, Andrew Baca, Trip Calihan, Peter Blair
 * File: AbstractCell.java
 * Implements the Cell class and defines responsibilities
 */

public class AbstractCell implements Cell, Iterable<Card> {
	
	private ArrayList<Card> cards;
	private int maxSize;
	
	/**
	 * Constructs the class, creates an ArrayList, "cards", and establishes a maxSize
	 * @param size
	 */
	public AbstractCell(int size) {
		cards = new ArrayList<Card>();
		maxSize = size;
	}
	
	/**
	 * Determines if cell "c" is an instance of HomeCell
	 * @return true if it is or otherwise false
	 */
	public boolean isHomeCell(Cell c) {
		if (c instanceof HomeCell)
			return true;
		else
			return false;
					
	}
	
	/**
	 * Determines whether the card can be added from the pile
	 * @return true if it meets the conditions or false otherwise
	 */
	public boolean canAddFrom(Cell c) {
		return (!c.isEmpty()) && (cards.size() != maxSize) && (!(c instanceof HomeCell));
	}
	
	/**
	 * Adds cards to the ArrayList, "cards"
	 */
	public void add(Card c) {
		cards.add(c);
	}
	
	/**
	 * Adds the cards from Cell "c" if canAddFrom is true
	 * @return true if the cards are added or otherwise false
	 */
	public boolean addFrom(Cell c) {
		if (canAddFrom(c)) {
			add(c.remove());
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Clears the cards
	 */
	public void clear() {
		cards.clear();
	}
	
	/**
	 * General remove method
	 * @return cards with a size that's one smaller
	 * @throws IllegalArgumentException if the cell is empty
	 */
	public Card remove(){
		if (cards.isEmpty())
			throw new IllegalArgumentException("Cell is empty");
		return cards.remove(cards.size()-1);
	}
	
	/**
	 * Remove method  at index "i"
	 * @return the updated cards after remove
	 * @throws IllegalArgumentException if the index is out of range
	 */
	public Card remove(int i) {
		if (i <= 0 || i >= cards.size()) {
			throw new IllegalArgumentException("Index out of range");
		}
		return cards.remove(i);
	}
	
	/**
	 * Boolean method checking size of list
	 * @return true if the pile is equal to 0 or false otherwise
	 */
	public boolean isEmpty() {
		if (cards.size() == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns a card at index "i"
	 * @return the card at the index position, "i"
	 * @throws IllegalArgumentException if the index is out of range
	 */
	public Card get(int i) {
		if (i< 0 || i>cards.size())
			throw new IllegalArgumentException("Index out of range");
		else
			return cards.get(i);
	}
	/**
	 * View the top card
	 * @return the top card
	 * @throws IllegalStateException if the cell is empty
	 */
	public Card seeTop() {
		if (cards.isEmpty() == true)
				throw new IllegalStateException("Cell is Empty");
		else
			return cards.get(cards.size()-1);
	}
	
	/**
	 * Iterator for the cards
	 * @return the iterator on the cards
	 */
	public Iterator<Card> iterator(){
		return cards.iterator();
	}
	
	/**
	 * toString method displaying text version of what's happening
	 * @return the string representation of the current card plus a new line
	 * @return the size of the list, representing the cards
	 * @return true if the cards are in order or false otherwise
	 */
	public String toString() {
		Card currentCard = null;
		String stringToReturn = "";
		for (Iterator<Card> iter = iterator(); iter.hasNext(); stringToReturn = stringToReturn + currentCard + "\n") {
			currentCard = (Card)iter.next();
		}
		return stringToReturn;
	}
	
	public int size() {
		return cards.size();
	}
	
	public boolean inOrder() {
		return true;
	}
	
}
