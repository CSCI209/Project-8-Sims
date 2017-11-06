import java.util.*;

public class Tableau extends AbstractCell {
	private ArrayList<Card> cardsToMove;
	
	public Tableau() {
		super(52);
	}
	
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
	
	public void addFrom(Cell c) {
		if (canAddFrom(c)) {
			while (! cardsToMove.isEmpty()) {
				c.remove();
				add((Card)cardsToMove.remove(cardsToMove.size() - 1));
			}
	}
	}
	
	public boolean inOrder() {
		if ((isEmpty()) || (cardsToMove.size() == 1)) {
			return true;
		}
		Card card = seeTop();
		for (int i = cardsToMove.size() - 2; i >= 0; i--) {
			Card nextCard = get(i);
			if ((card.sameColor(nextCard)) || (! nextCard.oneLarger(card))) {
				return false;
			}
			card = nextCard;
		}
		return true;
	}
}