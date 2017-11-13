import java.util.*;
/**
 * @author Peter Blair, Shep Sims, Trip Calihan, Andrew Baca
 * File: Tableau.java
 * Tableau, a subclass, extends AbstractCell and outlines three boolean methods: canAddFrom, 
 * addFrom and inOrder
 */
public class Tableau extends AbstractCell {
	private ArrayList<Card> cardsToMove;
	
	/**
	 * Calls on its superclass's (AbstractCell's) constructor.
	 * Tableaux will all have array lenghts of 13.
	 */
	public Tableau() {
		super(13);
	}
	
	/**
	 * Establishes whether cards can be added. Calls on its superclass first, then goes through a series
	 * of checks to determine whether a card can be added or not, based on color, suit and rank
	 * @param a Cell (c).
	 * @return it either returns isEmpty or the sameColor & oneLarger methods from Card.java
	 */
	public boolean canAddFrom(Cell c) {
		if (! super.canAddFrom(c)) {
			return false;
		}
		cardsToMove = new ArrayList<Card>();
		Card top = c.seeTop();
		cardsToMove.add(top);
		Card myCard = null;
		if (!isEmpty())
			myCard = seeTop();
		int i = c.size() - 2;
		while (i >= 0) {
			Card next = c.get(i);
			if ((!isEmpty()) && (myCard.getRank() - next.getRank() < 1))
				break;
			if ((top.sameColor(next)) || (! next.oneLarger(top))) break;
			cardsToMove.add(next);
			top = next;
			i--;
		}
		return (isEmpty() || (!top.sameColor(myCard) && myCard.oneLarger(top)));
	}
	
	/**
	 * Checks canAddFrom to see if conditions are met, then takes a card from cardsToMove and moves it
	 * while reducing the size of cardsToMove pile by 1
	 * @param a Cell (c).
	 * @return true if it successfully adds a card or otherwise false
	 */
	public boolean addFrom(Cell c) {
		if (canAddFrom(c)) {
			while (! cardsToMove.isEmpty()) {
				c.remove();
				add((Card)cardsToMove.remove(cardsToMove.size() - 1));
			}
			return true;
		}
		return false;
	}
	
	/**
	 * If the pile is empty or the size equals 1, it's inherently in order. If it's not the case, checks
	 * the sameColor and oneLarger method to make sure the cards are in correct order
	 * @return true if the cards are in order, otherwise returns false
	 */
	public boolean inOrder() {
		if ((isEmpty()) || (size() == 1)) {
			return true;
		}
		Card card = seeTop();
		for (int i = size() - 2; i >= 0; i--) {
			Card nextCard = get(i);
			if ((card.sameColor(nextCard)) || (! nextCard.oneLarger(card))) {
				return false;
			}
			card = nextCard;
		}
		return true;
	}
}