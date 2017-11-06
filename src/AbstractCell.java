import java.util.*;

public class AbstractCell implements Cell, Iterable<Card> {
	
	private ArrayList<Card> cards;
	private int maxSize;
	
	public AbstractCell(int size) {
		cards = new ArrayList<Card>();
		maxSize = size;
	}
	
	public boolean isHomeCell(Cell c) {
		if (c instanceof HomeCell)
			return true;
		else
			return false;
					
	}
	
	public boolean isTableau(Cell c) {
		if (c instanceof Tableau)
			return true;
		else
			return false;
	}
	
	public boolean isFreeCell(Cell c) {
		if (c instanceof FreeCell)
			return true;
		else
			return false;
	}
	
	public boolean canAddFrom(Cell c) {
		if (c.isEmpty() != false && c.size() != maxSize && isHomeCell(c ) != true) {
			return true;
		}
		else
			return false;
	}
	
	public void add(Card c) {
		cards.add(c);
	}
	
	public boolean addFrom(Cell c) {
		if (canAddFrom(c)) {
			add(c.remove());
			return true;
		}
		else
			return false;
	}
	
	public void clear() {
		cards.clear();
	}
	
	public Card remove(){
		if (cards.isEmpty())
			throw new IllegalArgumentException("Cell is empty");
		return cards.remove(cards.size()-1);
	}
	
	public Card remove(int i) {
		if (i <= 0 || i >= cards.size()) {
			throw new IllegalArgumentException("Index out of range");
		}
		return cards.remove(i);
	}
	
	public boolean isEmpty() {
		if (cards.size() == 0)
			return true;
		else
			return false;
	}
	
	public Card get(int i) {
		if (i< 0 || i<cards.size())
			throw new IllegalArgumentException("Index out of range");
		else
			return cards.get(i);
	}
	
	public Card seeTop() {
		if (cards.isEmpty() == true)
				throw new IllegalStateException("Cell is Empty");
		else
			return cards.get(cards.size()-1);
	}
	
	public Iterator<Card> iterator(){
		return cards.iterator();
	}
	
	public String toString() {
		Iterator<Card> iter = cards.iterator();
		Card currentCard = iter.next();
		String stringToReturn = currentCard.toString() + "\n";
		while (cards.iterator().hasNext()) {
			currentCard = iter.next();
			stringToReturn += currentCard.toString() + "\n";
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
